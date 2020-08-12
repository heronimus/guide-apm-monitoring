import os
import requests
import time
import redis
from flask import Flask
from flask import jsonify

import opentracing
from jaeger_client import Config
from flask_opentracing import FlaskTracing


## Initialize App + JaegerAPM
app = Flask(__name__)

def init_jaeger_tracer(service_name='random-cat'):
    config = Config(config={ # usually read from some yaml config
                'sampler': {
                    'type': 'const',
                    'param': 1,
                },
                'local_agent': {
                    'reporting_host': 'jaeger-allinone',
                    'reporting_port': '6831',
                },
                'logging': True,
            },
            service_name=service_name,
            validate=True
        )
    return config.initialize_tracer()

flask_tracer = FlaskTracing(init_jaeger_tracer, True, app)

url_cat = "http://loremflickr.com/400/400"
cache = redis.Redis(host='redis', port=6379)

def get_hit_count():
    retries = 5
    while True:
        try:
            return cache.incr('hits')
        except redis.exceptions.ConnectionError as exc:
            if retries == 0:
                raise exc
            retries -= 1
            time.sleep(0.5)

@app.route('/')
def index():
    parent_span = flask_tracer.get_span()

    with opentracing.tracer.start_span('redis-hitcount', child_of=parent_span) as span:
        count = get_hit_count()

    with opentracing.tracer.start_span('get-random-cat', child_of=parent_span) as span:
        span.set_tag("http.url",url_cat)
        response_cat = requests.get(url_cat, allow_redirects=True)
        span.set_tag("http.status_code", response_cat.status_code)

    response_service = jsonify(service_name="random-cat",
                                cat_img_url=response_cat.url,
                                hit=count)

    return response_service
