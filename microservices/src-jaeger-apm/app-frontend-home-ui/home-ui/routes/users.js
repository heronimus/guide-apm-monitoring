var express = require('express');
var got = require('got');
var router = express.Router();
var apigateway = 'http://backend-cloudgateway:8080'
/* GET users listing. */
router.get('/', function(req, res, next) {
  (async () => {
      try {
          const response = await got(apigateway+'/user-api/');
          console.log(response.body);

          res.render('users', {
                title: 'Microservices: Home-UI (Demo)',
                users: JSON.parse(response.body)
          });

      } catch (error) {
          console.log(error.response.body);
      }
  })();

});

/* GET users by id. */
router.get('/:id', function(req, res, next) {
  (async () => {
      try {
          const imageresponse = await got(apigateway+'/meow-api/');
          const userresponse = await got(apigateway+'/user-api/'+req.params.id);
          console.log(userresponse.body);
          console.log(JSON.parse(imageresponse.body).cat_img_url);

          res.render('users-detail', {
                title: 'Microservices: Home-UI (Demo)',
                user: JSON.parse(userresponse.body),
                imageurl: JSON.parse(imageresponse.body).cat_img_url,
          });

      } catch (error) {
          console.log(error.response.body);
      }
  })();
});

module.exports = router;
