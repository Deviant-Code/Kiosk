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
  files.forEach(uploadFile)
  files.forEach(previewFile)
}

function previewFile(file) {
  let reader = new FileReader()
  reader.readAsDataURL(file)
  reader.onloadend = function () {
    let img = document.createElement('img')
    img.src = reader.result
    document.getElementById('gallery').appendChild(img)
  }
}

// Navigation Menu
function openNav() {
  getSlideshowParams();
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft = "0";
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

function getSlideshowParams() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);
      console.log(res.willTransition);
      document.getElementById("speedValue").value = res.transitionSpeed;
      document.getElementById("transitionValue").checked = (res.willTransition == true);
      document.getElementById("autoValue").checked = (res.autoPlayVideo == true);
      document.getElementById("defaultValue").checked = (res.default == true);
    }
  };
  xhttp.open("GET", "/getSlideshowParams", true);
  xhttp.send();
}

function deleteUpload(filePath) {
  //Remove from html
  var element = document.getElementById(filePath);
  element.parentNode.removeChild(element);

  xhttp = new XMLHttpRequest();
  //Re-add the public\\uploads
  filePath = 'public\\Uploads\\' + filePath;
  xhttp.open('POST', '/deleteFile');
  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhttp.onload = function () {
    if (xhttp.status !== 200) {
      alert('Request failed.  Returned status of ' + xhttp.status);
    }
  };
  xhttp.send(encodeURI('filePath=' + filePath));
}

function loadImages() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);
      var images = [];

      for (var i = 0; i < res.images.length; i++) {
        images.push("../" + res.images[i].location.replace('public\\', ''));
      }

      for (var i = 0; i < images.length; i++) {
        document.getElementById('uploadGallery').innerHTML += '<img src="' + images[i] + '" id="' + res.images[i].location.replace('Uploads\\', '') + '"alt="" onclick="deleteUpload(' + '\'' + res.images[i].location.replace('Uploads\\', '') + '\'' + ')"/>';
      }
    }
  };
  xhttp.open("GET", "/getSlideshowParams", true);
  xhttp.send();
}