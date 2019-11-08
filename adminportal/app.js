var createError = require('http-errors');
var express = require('express');
var multer = require('multer');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var serveIndex = require('serve-index');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var slideshowJson = require('./js/slideshowJson');
var fs = require('fs');

var app = express();


// storage engine setup
const storage = multer.diskStorage({
  destination: 'public/Uploads/',
  filename: function (req, file, cb) {
    cb(null, file.fieldname + Date.now() + path.extname(file.originalname));
  }
})

// Init Upload
const upload = multer({
  storage: storage,
  //limits:{}, fileszie limits?
  fileFilter: function (req, file, cb) {
    checkFileType(file, cb);
  }
}).single('slideImage');

// Check file type
function checkFileType(file, cb) {
  const filetypes = /jpeg|jpg|png/;
  const extname = filetypes.test(path.extname(file.originalname).toLowerCase());
  const mimetype = filetypes.test(file.mimetype);

  if (mimetype && extname) {
    return cb(null, true);
  } else {
    cb('Error: Only jpeg,jpg, or png filetypes supported');
  }
}

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({
  extended: false
}));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

// Post request for file upload
app.post('/upload', (req, res) => {
  upload(req, res, err => {
    if (err) {
      res.send(err + " - Use the arrow buttons to return to the previous page");
      console.log(err);
    } else {
      if (req.file == undefined) {
        res.send("No file selected - Use the arrow buttons to return to the previous page");
        console.log("No file selected");
      } else {
        res.redirect('back');
        console.log("Slideshow Image Uploaded!");
        slideshowJson.addSlide(req.file);
      }
    }
  });
});

//Call when wanting to delete a file and pass the file's path
app.post('/deleteFile', function (req, res) {
  console.log(req.body.filePath);
  slideshowJson.removeSlide(req.body.filePath);
  fs.unlink(req.body.filePath, (err) => {
    if (err)
      console.log(err);
  });
  res.redirect('back');
});


//Update Slideshow module's settings json
app.post('/updateSlideshowParams', function (req, res) {
  var object = slideshowJson.getJson();
  console.log(req.body);
  object.transitionSpeed = parseInt(req.body.speedValue);
  object.willTransition = (req.body.transitionValue == 'true');
  object.autoPlayVideo = (req.body.autoValue == 'true');
  object.default = (req.body.defaultValue == 'true');
//if this is true then open other jsons and make it false

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/slideshow.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });
  res.redirect('back');
});

//Get Slideshow module's settings json
app.get('/getSlideshowParams', function (req, res) {
  var object = slideshowJson.getJson();
  res.json(object);
});

app.use('/', indexRouter);
app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;