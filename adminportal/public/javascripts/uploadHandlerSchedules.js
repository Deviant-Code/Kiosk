
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


function loadSchedulesContent() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      document.getElementById("enabledValue").checked = (res.moduleEnabled == true);
      document.getElementById("defaultValue").checked = (res.default == true);

      var scheduleTypeSelect = document.getElementById("scheduleTypeSelect");

      for (var i = 0; i < res.scheduleTypes.length; i++) {
        //Populate options for form
        var option = document.createElement("option");
        option.text = res.scheduleTypes[i].name;
        scheduleTypeSelect.add(option);

        //Populate schedules manager
        var typeHeading = document.createElement("h2");
        typeHeading.innerHTML = res.scheduleTypes[i].name; 
        document.getElementById("scheduleManager").appendChild(typeHeading);

        //add all schedules for each schedule type in its own div with delete button
        for (var j = 0; j < res.scheduleTypes[i].schedules.length; j++) {
          var scheduleDiv = document.createElement("div");
          scheduleDiv.id = res.scheduleTypes[i].name + res.scheduleTypes[i].schedules[j].title;
          document.getElementById("scheduleManager").appendChild(scheduleDiv);

          var button = document.createElement('button');
          button.innerHTML = "x";
          var name=res.scheduleTypes[i].name;
          var title = res.scheduleTypes[i].schedules[j].title;

          button.onclick = function(){deleteSchedule(name,title, scheduleDiv.id)};
          scheduleDiv.appendChild(button);

          var scheduleTitle = document.createElement("h4");
          scheduleTitle.innerHTML = res.scheduleTypes[i].schedules[j].title; 
          scheduleDiv.appendChild(scheduleTitle);

          var scheduleP = document.createElement("p");
          scheduleP.innerHTML = res.scheduleTypes[i].schedules[j].description + "\n" + 
                                res.scheduleTypes[i].schedules[j].startTime + " " + res.scheduleTypes[i].schedules[j].startTime; 
          scheduleDiv.appendChild(scheduleP);
        }
      }
    }
  };
  xhttp.open("GET", "/getSchedulesParams", true);
  xhttp.send();
}

function deleteSchedule(scheduleType, scheduleTitle, divId) {
  //Remove schedule from html
  var element = document.getElementById(divId).parentNode;
  element.parentNode.removeChild(element);

  xhttp = new XMLHttpRequest();
  xhttp.open('POST', '/deleteSchedule');
  xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhttp.onload = function () {
    if (xhttp.status !== 200) {
      alert('Request failed.  Returned status of ' + xhttp.status);
    }
  };
  xhttp.send(encodeURI('scheduleType=' + scheduleType + '&scheduleTitle='+ scheduleTitle));
}