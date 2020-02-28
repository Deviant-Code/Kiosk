let dropArea = document.getElementById("drop-area")

// Prevent default drag behaviors
;
['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
  dropArea.addEventListener(eventName, preventDefaults, false)
  document.body.addEventListener(eventName, preventDefaults, false)
})

// Highlight drop area when item is dragged over it
;
['dragenter', 'dragover'].forEach(eventName => {
  dropArea.addEventListener(eventName, highlight, false)
})



// Handle dropped files
dropArea.addEventListener('drop', handleDrop, false)

function preventDefaults(e) {
  e.preventDefault()
  e.stopPropagation()
}

function highlight(e) {
  dropArea.classList.add('highlight')
}

function unhighlight(e) {
  dropArea.classList.remove('active')
}

function handleDrop(e) {
  var dt = e.dataTransfer
  var files = dt.files

  handleFiles(files)
}

function handleFiles(files) {
  files = [...files]
  files.forEach(previewFile)
}

function previewFile(file) {
  let reader = new FileReader()
  reader.readAsDataURL(file)
  reader.onloadend = function () {
    let img = document.createElement('img')

    if(isVideo(file.name)){
      //Set video to default thumbnail
      img.src = null
    }else{
      img.src = reader.result
    }
    document.getElementById('gallery').appendChild(img)
  }
}

function isVideo(filename) {
  var ext = (filename + '').split('.').pop();
  switch (ext.toLowerCase()) {
  case 'm4v':
  case 'avi':
  case 'mpg':
  case 'mp4':
  case 'mov':
      return true;
  }
  return false;
}

function getVideoThumnail(image, path, i){
  //If thumbnail exists, use it, if not, generate it and upload it
  if(image.thumbnail != ""){
    document.getElementById('uploadGallery').innerHTML += '<div id="uploadedImage"> <img draggable="true" ondrop="drop(event)" ondragover="allowDrop(event)" ondragstart="drag(event)" src="'
                                                                  + "../" + image.thumbnail + '" id="' + path + '"alt="image' + i + '"/>'
                                                                  + '<div id="top-left">'+ (i + 1) + '</div>'
                                                                  + '<div id="top-right" onclick="deleteUpload(' + '\'' + path + '\'' + ')"> X </div>' +
                                                                  '</div>';
    //document.getElementById('uploadGallery').innerHTML += '<img src="' + "../" + image.thumbnail + '" id="' + path + '"alt="" onclick="deleteUpload(' + '\'' + path + '\'' + ')"/>';
  }else{
    var video = document.createElement('video');
    var loc = image.location;

    video.src = "../" + image.location;

    var canvas = document.createElement('canvas');
    var context = canvas.getContext('2d');

    video.addEventListener('loadeddata', function() {
        context.drawImage(video, 0, 0, canvas.width, canvas.height);
        var URI = canvas.toDataURL('image/jpeg');
        document.getElementById('uploadGallery').innerHTML += '<div id="uploadedImage"> <img draggable="true" ondrop="drop(event)" ondragover="allowDrop(event)" ondragstart="drag(event)" src="'
                                                                  + URI + '" id="' + path + '"alt="image' + i + '"/>'
                                                                  + '<div id="top-left">'+ (i + 1) + '</div>'
                                                                  + '<div id="top-right" onclick="deleteUpload(' + '\'' + path + '\'' + ')"> X </div>'
                                                                  + '<div id="bottom-left"> ⚙️ </div>' +
                                                                  '</div>';
        //document.getElementById('uploadGallery').innerHTML += '<img src="' + URI + '" id="' + path + '"alt="" onclick="deleteUpload(' + '\'' + path + '\'' + ')"/>';
        updateSlideThumbnail(loc, URI);
    });
  }
}

//Sends the thumbnail in base64 and the associated slide location
function updateSlideThumbnail(filePath, thumbnail) {
  xhttp = new XMLHttpRequest();
  xhttp.open('POST', '/updateSlideThumbnail');
  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhttp.onload = function () {
    if (xhttp.status !== 200) {
      alert('Request failed.  Returned status of ' + xhttp.status);
    }
  };
  xhttp.send(encodeURI('path=' + filePath + '&thumbnail='+ thumbnail));
}

// Navigation Menu
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginRight = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginRight = "0";
}

function dropdown() {
  var dropdown = document.getElementsByClassName("dropdown-btn");
  var i;

  for (i = 0; i < dropdown.length; i++) {
    dropdown[i].addEventListener("click", function () {
      this.classList.toggle("active");
      var dropdownContent = this.nextElementSibling;
      if (dropdownContent.style.display === "block") {
        dropdownContent.style.display = "none";
      } else {
        dropdownContent.style.display = "block";
      }
    });
  }
}

function checkHiddenValues() {
  //Hide hidden values if real is checked
  if (document.getElementById("enabledValue").checked) {
    document.getElementById('enabledValueHidden').disabled = true;
  }
  if (document.getElementById("defaultValue").checked) {
    document.getElementById('defaultValueHidden').disabled = true;
  }
  if (document.getElementById("autoValue").checked) {
    document.getElementById('autoValueHidden').disabled = true;
  }
  if (document.getElementById("transitionValue").checked) {
    document.getElementById('transitionValueHidden').disabled = true;
  }
}

function deleteUpload(filePath) {
  //Remove from html
  var element = document.getElementById(filePath).parentNode;
  element.parentNode.removeChild(element);

  xhttp = new XMLHttpRequest();
  //Re-add the public/uploads
  filePath = 'public/Uploads/' + filePath;
  xhttp.open('POST', '/deleteFile');
  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhttp.onload = function () {
    if (xhttp.status !== 200) {
      alert('Request failed.  Returned status of ' + xhttp.status);
    }else{
      window.location.reload();
    }
  };
  xhttp.send(encodeURI('filePath=' + filePath));
}

function loadSlideshowContent() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);
      var images = [];

      for (var i = 0; i < res.images.length; i++) {
        var path = res.images[i].location.replace('public/', '');
        images.push("../" + path);
      }

      for (var i = 0; i < images.length; i++) {
        var path = res.images[i].location.replace('Uploads\\', '');
        path = path.replace('Uploads/', '');
        if(isVideo(path)){
          getVideoThumnail(res.images[i], path, i);
        }else{
          document.getElementById('uploadGallery').innerHTML += '<div id="uploadedImage"> <img draggable="true" ondrop="drop(event)" ondragover="allowDrop(event)" ondragstart="drag(event)" src="'
                                                                  + images[i] + '" id="' + path + '"alt="image' + i + '"/>'
                                                                  + '<div id="top-left">'+ (i + 1) + '</div>'
                                                                  + '<div id="top-right" onclick="deleteUpload(' + '\'' + path + '\'' + ')"> X </div>'
                                                                  + '<div id="bottom-left" onclick="openSlideSettings(' + '\'' + path + '\' ,' + i + ')"> ⚙️ </div>' +
                                                                  '</div>';
        }
      }

      document.getElementById("enabledValue").checked = (res.moduleEnabled == true);
      document.getElementById("speedValue").value = res.transitionSpeed;
      document.getElementById("transitionValue").checked = (res.willTransition == true);
      document.getElementById("autoValue").checked = (res.autoPlayVideo == true);
      document.getElementById("defaultValue").checked = (res.default == true);
    }
  };
  xhttp.open("GET", "/getSlideshowParams", true);
  xhttp.send();
}

function allowDrop(ev) {
  ev.preventDefault();
}

function drag(ev) {
  ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
  ev.preventDefault();
  var movingImage = 'public/Uploads/' + ev.dataTransfer.getData("text");
  var targetImage = 'public/Uploads/' + ev.target.id;

  xhttp = new XMLHttpRequest();
  xhttp.open('POST', '/updateSlideOrder');
  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhttp.onload = function () {
    if (xhttp.status !== 200) {
      alert('Request failed.  Returned status of ' + xhttp.status);
    }else{
      window.location.reload();
    }
  };
  xhttp.send(encodeURI('movingPath=' + movingImage + '&targetPath='+ targetImage));
}

//open slide settings menu and populate with current settings
function openSlideSettings(path, i){
  document.getElementById("slideSettingsForm").style.display = "inline-block";
  document.getElementById("slideSettingsImage").src = "../Uploads/" + path;
  document.getElementById("slideSettingsImage").name = "Uploads/" + path;

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);
      
      document.getElementById("slideTransitionTime").value = res.images[i].transitionTime;
      document.getElementById("slideExpDate").value = res.images[i].expiration;
    }
  };
  xhttp.open("GET", "/getSlideshowParams", true);
  xhttp.send();
}

function updateSlideSettings(){
  xhttp = new XMLHttpRequest();
  xhttp.open('POST', '/updateSlideSettings');
  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhttp.onload = function () {
    if (xhttp.status !== 200) {
      alert('Request failed.  Returned status of ' + xhttp.status);
    }else{
      window.location.reload();
    }
  };
  xhttp.send(encodeURI( 'path=' + document.getElementById("slideSettingsImage").name
                        + '&transitionTime=' + document.getElementById("slideTransitionTime").value 
                        + '&expirationDate='+ document.getElementById("slideExpDate").value));
}

function closeSlideSettings(){
  document.getElementById("slideSettingsForm").style.display = "none";
}