var express = require('express');
var got = require('got');
var router = express.Router();
var apigateway = 'http://backend-cloudgateway:8080'

/* GET random cat */
router.get('/', function(req, res, next) {
  (async () => {
      try {
          const imageresponse = await got(apigateway+'/meow-api/');
          console.log(JSON.parse(imageresponse.body).cat_img_url);

          res.render('random-cat', {
                imageurl: JSON.parse(imageresponse.body).cat_img_url,
          });

      } catch (error) {
          console.log(error.response.body);
      }
  })();
});

module.exports = router;
