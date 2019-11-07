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
  var fetch = http.request({
    hostname: 'localhost',
    port: 3000,
    path: '/updateSlideshowParams',
    method: 'GET',
    withCredentials: false
  }, function (res) {
    res.on('data', d => {
      document.getElementById("speedValue").value = d.transitionSpeed;
      document.getElementById("transitionValue").checked = d.willTransition;
      document.getElementById("autoValue").checked = d.autoPlayVideo;
      document.getElementById("defaultValue").checked = d.default;
    });
    res.on('error', error => {
      console.error(error)
    });
    res.on('end', function () {
      console.log("response.................");
      console.log(result);
    });
  });
}