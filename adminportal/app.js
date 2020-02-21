var createError = require('http-errors');
var express = require('express');
var session = require('express-session');
var multer = require('multer');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var serveIndex = require('serve-index');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var slideshowJson = require('./js/slideshowJson');
var departmentJson = require('./js/departmentJson');
var pollJson = require('./js/pollJson');
var schedulesJson = require('./js/schedulesJson');
var defaultHandler = require('./js/defaultModuleHandler');
var passJson = require('./js/passwordManager');

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
}).any();

// Check file type
function checkFileType(file, cb) {
  const filetypes = /jpeg|jpg|png|mov|mp4|avi|wmv|m4v|mpg/;
  const extname = filetypes.test(path.extname(file.originalname).toLowerCase());
  const mimetype = filetypes.test(file.mimetype);

  if (mimetype && extname) {
    return cb(null, true);
  } else {
    cb('Error: Only jpeg,jpg,png,mov,mp4,avi,wmv,m4v,mpg filetypes supported');
  }
}

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

app.use(logger('dev'));
app.use(session({
	secret: 'secret',
	resave: true,
	saveUninitialized: true
}));
app.use(express.json());
app.use(express.urlencoded({
  extended: false
}));
app.use(cookieParser());

//Add our public directory to be served
var statics = express.static(path.join(__dirname, 'public'));
//Declare all hidden content until logged in
var hiddenContent = ['/pages/slideshow.html', '/pages/home.html', '/pages/poll.html', '/pages/schedules.html', '/pages/department.html'
                     ,'/javascripts/uploadHandlerSlideshow.js', '/javascripts/uploadHandlerSchedules.js', '/javascripts/uploadHandlerPoll.js', '/javascripts/uploadHandlerDepartment.js'];

function hidePages(pathsToHide = []) {
  return function (req, res, next) {
    //If we are already logged in then skip the login page
    if((req.path == "/index.html" || req.path == "/") && req.session.loggedin){
      res.redirect('/pages/home.html');
      return statics(req, res, next);
    }

    //If we have no hidden content or we are logged in then serve
    if (pathsToHide.length === 0 || req.session.loggedin) {
      return statics(req, res, next); // Do not secure, forward to static route
    }

    //If is included in hidden content then return with error
    else if (pathsToHide.indexOf(req.path) > -1) {
      return res.status(403).send('<h1>403 Forbidden</h1><h2>Login to gain access</h2>' +
                                  '<a href="../index.html"><button type="button" class="module">Return to Login</button></a>'); // Stop request
    }

    return statics(req, res, next); // forward to static route
  };
}

// serve everything but hidden pages
app.use(hidePages(hiddenContent));

// Post request for logging into portal
app.post('/login', (req, res) => {
  var username = req.body.username;
  var password = req.body.password;
	if (username && password) {
		if (username == passJson.getJson().username && password == passJson.getJson().password) {
      //No longer hide pages
			req.session.loggedin = true;
			res.redirect('/pages/home.html');
		} else {
			res.send('<h2>Incorrect Username and/or Password!</h2>' +
               '<a href="index.html"><button type="button" class="module">Return to Login</button></a>');
		}
	} else {
		res.send('<h2>Please enter Username and Password!</h2>' +
              '<a href="index.html"><button type="button" class="module">Return to Login</button></a>');
	}
});

// Post request for updating password
app.post('/updatePassword', (req, res) => {
  var currentPass = req.body.currentPass;
  var newPass = req.body.newPass;
	if (currentPass && newPass) {
		if (currentPass == passJson.getJson().password) {
      passJson.updatePassword(newPass);
			res.send('<h2>Password updated!</h2>' +
               '<a href="/pages/home.html"><button type="button" class="module">Return to Home</button></a>');
		} else {
			res.send('<h2>Incorrect Password! Password not updated</h2>' +
               '<a href="/pages/home.html"><button type="button" class="module">Return to Home</button></a>');
		}
	} else {
		res.send('<h2>Please enter Password</h2>' +
              '<a href="/pages/home.html"><button type="button" class="module">Return to Home</button></a>');
	}
});

// Post request for department image upload
app.post('/departmentUpload', (req, res) => {
  upload(req, res, err => {
    if (err) {
      res.send(err + " - Use the arrow buttons to return to the previous page");
      console.log(err);
    } else {
      if (req.files == undefined) {
        res.send("No file selected - Use the arrow buttons to return to the previous page");
        console.log("No file selected");
      } else {
        res.redirect('back');
        console.log("Department Image Uploaded!");
        departmentJson.addImage(req.files);
      }
    }
  });
});

// Post request for file upload
app.post('/upload', (req, res) => {
  upload(req, res, err => {
    if (err) {
      res.send(err + " - Use the arrow buttons to return to the previous page");
      console.log(err);
    } else {
      if (req.files == undefined) {
        res.send("No file selected - Use the arrow buttons to return to the previous page");
        console.log("No file selected");
      } else {
        res.redirect('back');
        console.log("Slideshow Image Uploaded!");
        slideshowJson.addSlide(req.files);
      }
    }
  });
});

//Call when wanting to delete a file and pass the file's path
app.post('/deleteFile', function (req, res) {
  slideshowJson.removeSlide(req.body.filePath);
  fs.unlink(req.body.filePath, (err) => {
    if (err)
      console.log(err);
  });
  res.redirect('back');
});

//Call when wanting to delete a file from /department
app.post('/deleteDeptFile', function (req, res) {
  departmentJson.removeImage(req.body.filePath);
  fs.unlink(req.body.filePath, (err) => {
    if (err)
      console.log(err);
  });
  res.redirect('back');
});


//Update Slideshow module's image order in json file and reload page
app.post('/updateSlideOrder', function (req, res) {
  slideshowJson.reorderSlides(req.body.movingPath, req.body.targetPath);
  res.redirect('back');
});

//Update Slideshow module's settings json
app.post('/updateSlideThumbnail', function (req, res) {
  slideshowJson.addThumbnail(req.body.path, req.body.thumbnail);
});

//Update Department module's settings json
app.post('/updateDeptThumbnail', function (req, res) {
  slideshowJson.addThumbnail(req.body.path, req.body.thumbnail);
});

//Update Slideshow module's settings json
app.post('/updateSlideshowParams', function (req, res) {
  var object = slideshowJson.getJson();
  object.moduleEnabled = (req.body.enabledValue == 'true');
  object.transitionSpeed = parseInt(req.body.speedValue);
  object.willTransition = (req.body.transitionValue == 'true');
  object.autoPlayVideo = (req.body.autoValue == 'true');
  object.default = (req.body.defaultValue == 'true');
  //if this is true then open other jsons and make it false
  if(object.default)
    defaultHandler.setDefault("slideshow");

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

//Update Department module's settings json
app.post('/updateDepartmentParams', function (req, res) {
  var object = departmentJson.getJson();
  object.moduleEnabled = (req.body.enabledValue == 'true');
  object.default = (req.body.defaultValue == 'true');
  //if this is true then open other jsons and make it false
  if(object.default)
    defaultHandler.setDefault("department");

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/department.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });
  res.redirect('back');
});

//Update Department module's settings json with new content
app.post('/updateDepartment', function (req, res) {
  var object = departmentJson.getJson();
  object.heading = req.body.heading;
  object.description = req.body.description;

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/department.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });

  res.redirect('back');
});

//Update department module's types with new type
app.post('/updateDeptTypes', function (req, res) {
  departmentJson.addRoomType(req.body.newRoomType);
  res.redirect('back');
});

//Update department module's with a new schedule
app.post('/updateRooms', function (req, res) {
  departmentJson.addRoom(req.body.roomType,
                            req.body.newRoomNumber,
                            req.body.newFaculty,
                            req.body.newHourStart,
                            req.body.newHourEnd);
  res.redirect('back');
});

//Remove a room type from our json
app.post('/deleteRoomTypes', function (req, res) {
  departmentJson.deleteRoomType(req.body.scheduleType);
  res.redirect('back');
});

//Get Department module's settings json
app.get('/getDepartmentParams', function (req, res) {
  var object = departmentJson.getJson();
  res.json(object);
});


//Update Poll module's settings json
app.post('/updatePollParams', function (req, res) {
  var object = pollJson.getJson();
  object.moduleEnabled = (req.body.enabledValue == 'true');
  object.default = (req.body.defaultValue == 'true');
  //if this is true then open other jsons and make it false
  if(object.default)
    defaultHandler.setDefault("poll");

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/poll.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });
  res.redirect('back');
});

//Update Poll module's json with new content
app.post('/updatePoll', function (req, res) {
  var object = pollJson.getJson();
  object.pollQuestion = req.body.pollQuestion;
  object.pollResp1 = req.body.pollResp1;
  object.pollResp2 = req.body.pollResp2;

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/poll.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });
  res.redirect('back');
});

//Update Poll response one count
app.post('/votePollOne', function (req, res) {
  var object = pollJson.getJson();
  object.pollResp1Val += 1;

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/poll.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });
  var object = pollJson.getJson();
  res.status(200);
});


//Update Poll response two count
app.post('/votePollTwo', function (req, res) {
  var object = pollJson.getJson();
  object.pollResp2Val += 1;

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/poll.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });
  var object = pollJson.getJson();
  res.status(200);
});

//Rest Poll module's json stats
app.post('/resetPollStats', function (req, res) {
  var object = pollJson.getJson();
  object.pollResp1Val = 0;
  object.pollResp2Val = 0;

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/poll.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });
  res.redirect('back');
});

//Get Poll module's settings json
app.get('/getPollParams', function (req, res) {
  var object = pollJson.getJson();
  res.json(object);
});

//Update Schedules module's settings json
app.post('/updateSchedulesParams', function (req, res) {
  var object = schedulesJson.getJson();
  object.moduleEnabled = (req.body.enabledValue == 'true');
  object.default = (req.body.defaultValue == 'true');
  //if this is true then open other jsons and make it false
  if(object.default)
    defaultHandler.setDefault("schedules");

  let data = JSON.stringify(object, null, 2);

  fs.writeFileSync("public/json/schedules.json", data, (err) => {
    if (err) {
      console.error(err);
      return;
    };
  });
  res.redirect('back');
});

//Update Schedule module's with a new schedule
app.post('/deleteSchedule', function (req, res) {
  schedulesJson.deleteSchedule(req.body.scheduleType,
                              req.body.scheduleTitle);
  res.redirect('back');
});

//Remove a schedule type from our json
app.post('/deleteScheduleTypes', function (req, res) {
  schedulesJson.deleteScheduleType(req.body.scheduleType);
  res.redirect('back');
});

//Update Schedule module's with a new schedule
app.post('/updateSchedules', function (req, res) {
  schedulesJson.addSchedule(req.body.scheduleType,
                            req.body.newScheduleTitle,
                            req.body.newScheduleDescription,
                            req.body.newScheduleStart,
                            req.body.newScheduleEnd);
  res.redirect('back');
});

//Update Schedule module's types with new type
app.post('/updateScheduleTypes', function (req, res) {
  schedulesJson.addScheduleType(req.body.newScheduleType);
  res.redirect('back');
});

//Get Department module's settings json
app.get('/getSchedulesParams', function (req, res) {
  var object = schedulesJson.getJson();
  res.json(object);
});

//Catch favicon requests since we don't have right now
app.get('/favicon.ico', (req, res) => res.status(204));

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  next(createError(404));
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
