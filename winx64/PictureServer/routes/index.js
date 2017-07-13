var express = require('express');
var router = express.Router();
var urlencode = require('urlencode');
var node_echarts = require('node-echarts');
var path = require('path');
var Canvas =require('canvas');
/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});
/* echarts for testing. */
router.get('/echarts', function(req, res, next) {
    console.log("=================================");

    console.log(req.query.options);

    node_echarts({
        canvas: Canvas,
        font: '12px 华文仿宋',
        //path: '/home/free/' + '/中文字体demo.png',
        res:res,
        //option: req.query.options,
        option: JSON.parse(req.query.options),
        width:  1000,
        height: 500
    });
    //res.send('I am in Echarts!\r\n'+req.query.options);
});
module.exports = router;
