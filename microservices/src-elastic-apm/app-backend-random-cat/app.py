import requests
from flask import Flask
from flask import jsonify
from elasticapm.contrib.flask import ElasticAPM

## Initialize App + ElasticAPM
app = Flask(__name__)

app.config['ELASTIC_APM'] = {
    'SERVICE_NAME': 'random-cat',
}
### Variable set via Docker ENV
#    ELASTIC_APM_SERVER_URL: http://localhost:9200
#    ELASTIC_APM_ENABLED: True

apm = ElasticAPM(app)

url_cat = "http://loremflickr.com/400/400"

@app.route('/')
def index():
    response_cat = requests.get(url_cat, allow_redirects=True)
    response_service = jsonify(service_name="random-cat",
                                cat_img_url=response_cat.url)

    return response_service
