import os
import requests
import time
import redis
from flask import Flask
from flask import jsonify
from elasticapm.contrib.flask import ElasticAPM

## Initialize App + ElasticAPM
app = Flask(__name__)

app.config['ELASTIC_APM'] = {
    'SERVICE_NAME': 'random-cat',
    'SERVER_URL': 'http://'+os.getenv('APM_HOST', 'localhost:8200'),
    'ENABLED': os.getenv('APM_ENABLED', 'True'),
}

apm = ElasticAPM(app)

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
    count = get_hit_count()
    response_cat = requests.get(url_cat, allow_redirects=True)
    response_service = jsonify(service_name="random-cat",
                                cat_img_url=response_cat.url,
                                hit=count)

    return response_service
