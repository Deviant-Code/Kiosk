
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

//Sends the thumbnail in base64 and the associated slide location
function updateSlideThumbnail(filePath, thumbnail) {
  xhttp = new XMLHttpRequest();
  xhttp.open('POST', '/updateDeptThumbnail');
  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhttp.onload = function () {
    if (xhttp.status !== 200) {
      alert('Request failed.  Returned status of ' + xhttp.status);
    }
  };
  xhttp.send(encodeURI('path=' + filePath + '&thumbnail='+ thumbnail));
}

function checkHiddenValues() {
  //Hide hidden values if real is checked
  if (document.getElementById("enabledValue").checked) {
    document.getElementById('enabledValueHidden').disabled = true;
  }
  if (document.getElementById("defaultValue").checked) {
    document.getElementById('defaultValueHidden').disabled = true;
  }
}


function deleteUpload(filePath) {
  //Remove from html
  var element = document.getElementById(filePath).parentNode;
  element.parentNode.removeChild(element);

  xhttp = new XMLHttpRequest();
  //Re-add the public/uploads/department
  filePath = 'public/Uploads/' + filePath;
  xhttp.open('POST', '/deleteDeptFile');
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

function loadDepartmentContent() {
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

        document.getElementById('uploadGallery').innerHTML += '<div id="uploadedImage"> <img draggable="true" ondrop="drop(event)" ondragover="allowDrop(event)" ondragstart="drag(event)" src="'
                                                                  + images[i] + '" id="' + path + '"alt="image' + i + '"/>'
                                                                  + '<div id="top-left">'+ (i + 1) + '</div>'
                                                                  + '<div id="top-right" onclick="deleteUpload(' + '\'' + path + '\'' + ')"> X </div>' +
                                                                  '</div>';
      }

      document.getElementById("enabledValue").checked = (res.moduleEnabled == true);
      document.getElementById("defaultValue").checked = (res.default == true);

      var roomTypeSelect = document.getElementById("roomTypeSelect");
      var roomTypeSelectRemove = document.getElementById("roomTypeRemove");

      for (var i = 0; i < res.roomTypes.length; i++) {
        //Populate options for form
        var option = document.createElement("option");
        option.text = res.roomTypes[i].name;
        option.className = "roomTypeContent"
        roomTypeSelect.add(option);
        option = document.createElement("option");
        option.text = res.roomTypes[i].name;
        option.className = "roomTypeContent"
        roomTypeSelectRemove.add(option);

        //Populate rooms manager
        var typeHeading = document.createElement("h2");
        typeHeading.innerHTML = res.roomTypes[i].name;
        document.getElementById("roomManagerPortal").appendChild(typeHeading);

        //add all rooms for each room type in its own div with delete button
        for (var j = 0; j < res.roomTypes[i].rooms.length; j++) {
          var roomDiv = document.createElement("div");
          roomDiv.id = res.roomTypes[i].name + res.roomTypes[i].rooms[j].title;
          roomDiv.className = "room-display"
          document.getElementById("roomManagerPortal").appendChild(roomDiv);

          var button = document.createElement('button');
          button.innerHTML = "x";
          var name=res.roomTypes[i].name;
          var title = res.roomTypes[i].rooms[j].title;

          button.onclick = function(){deleteRoom(name,title, roomDiv.id)};
          button.type = "submit"
          roomDiv.appendChild(button);

          var roomTitle = document.createElement("h4");
          roomTitle.innerHTML = res.roomTypes[i].rooms[j].title;
          roomDiv.appendChild(roomTitle);

          var roomP = document.createElement("p");
          roomP.innerHTML = res.roomTypes[i].rooms[j].faculty + "<br> Start: " +
                                res.roomTypes[i].rooms[j].startTime + " End: " + res.roomTypes[i].rooms[j].startTime;
          roomDiv.appendChild(roomP);
        }
      }

    }
  };
  xhttp.open("GET", "/getDepartmentParams", true);
  xhttp.send();
}

function deleteRoom(roomType, roomTitle, divId) {
  //Remove room from html
  var element = document.getElementById(divId);
  element.parentNode.removeChild(element);

  xhttp = new XMLHttpRequest();
  xhttp.open('POST', '/deleteRoom');
  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhttp.onload = function () {
    if (xhttp.status !== 200) {
      alert('Request failed.  Returned status of ' + xhttp.status);
    }
  };
  xhttp.send(encodeURI('roomType=' + roomType + '&roomTitle='+ roomTitle));
  location.reload();
}
