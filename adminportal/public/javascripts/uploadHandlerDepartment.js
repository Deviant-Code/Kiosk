
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

      var floorSelect = document.getElementById("floorSelect");
      var floorSelectRemove = document.getElementById("floorSelectRemove");

      for (var i = 0; i < res.floors.length; i++) {
        //Populate options for form
        var option = document.createElement("option");
        option.text = res.floors[i].name;
        option.className = "roomTypeContent"
        floorSelect.add(option);
        option = document.createElement("option");
        option.text = res.floors[i].name;
        option.className = "roomTypeContent"
        floorSelectRemove.add(option);

        //Populate rooms manager
        var typeHeading = document.createElement("h2");
        typeHeading.innerHTML = res.floors[i].name;
        document.getElementById("roomManagerPortal").appendChild(typeHeading);

        //add all rooms for each room type in its own div with delete button
        for (var j = 0; j < res.floors[i].rooms.length; j++) {
          var roomDiv = document.createElement("div");
          roomDiv.id = res.floors[i].name + res.floors[i].rooms[j].name;
          roomDiv.className = "room-display"
          document.getElementById("roomManagerPortal").appendChild(roomDiv);

          var button = document.createElement('button');
          button.innerHTML = "x";
          var floorName = res.floors[i].name;
          var roomName_ = res.floors[i].rooms[j].name;

          button.onclick = function(){
              deleteRoom(floorName, roomName_, roomDiv.id);
          };
          button.type = "submit"
          roomDiv.appendChild(button);

          var roomName = document.createElement("h4");
          roomName.innerHTML = res.floors[i].rooms[j].name;
          roomDiv.appendChild(roomName);

          var roomP = document.createElement("p");
          roomP.innerHTML = res.floors[i].rooms[j].faculty + "<br>"+
          res.floors[i].rooms[j].attribute + "<br> Hours: " +
          res.floors[i].rooms[j].startHour + " - " + res.floors[i].rooms[j].endHour;

          roomDiv.appendChild(roomP);
        }
      }

    }
  };
  xhttp.open("GET", "/getDepartmentParams", true);
  xhttp.send();
}

function deleteRoom(floorName, roomName, divId) {
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
  
  xhttp.send(encodeURI('floorName=' + floorName + '&roomName='+ roomName));
  location.reload();
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
  xhttp.open('POST', '/updateFloorOrder');
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
