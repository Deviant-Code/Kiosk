/* Functions used on the schedules kiosk module page */

//Grabs Json from server and parses then populates page with data
function loadSchedulesContent() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      //Clear all content on the page
      document.getElementById("scheduleManagerKiosk").innerHTML = "";
      document.getElementById("scheduleTypeSelect").innerHTML = "";

      var scheduleTypeSelect = document.getElementById("scheduleTypeSelect");

      for (var i = 0; i < res.scheduleTypes.length; i++) {
        //Populate options for form
        var option = document.createElement("option");
        option.text = res.scheduleTypes[i].name;
        option.className = "scheduleTypeContent"
        scheduleTypeSelect.add(option);

        //Populate schedules manager
        var typeHeading = document.createElement("h2");
        typeHeading.innerHTML = res.scheduleTypes[i].name; 
        document.getElementById("scheduleManagerKiosk").appendChild(typeHeading);

        //add all schedules for each schedule type in its own div with delete button
        for (var j = 0; j < res.scheduleTypes[i].schedules.length; j++) {
          var scheduleDiv = document.createElement("div");
          scheduleDiv.id = res.scheduleTypes[i].name + res.scheduleTypes[i].schedules[j].title;
          scheduleDiv.className = "schedule-display"
          document.getElementById("scheduleManagerKiosk").appendChild(scheduleDiv);

          var scheduleTitle = document.createElement("h4");
          scheduleTitle.innerHTML = res.scheduleTypes[i].schedules[j].title; 
          scheduleDiv.appendChild(scheduleTitle);

          var scheduleP = document.createElement("p");
          scheduleP.innerHTML = res.scheduleTypes[i].schedules[j].description + "<br> Start: " + 
                                res.scheduleTypes[i].schedules[j].startTime + " End: " + res.scheduleTypes[i].schedules[j].startTime; 
          scheduleDiv.appendChild(scheduleP);
        }
      }
    }
  };
  xhttp.open("GET", "/getSchedulesParams", true);
  xhttp.send();
}

// Used by the serach div to reload the schedule manager display with specfici parameters as defined
function search(){
  title = document.getElementById("scheduleTitle").value;
  type = document.getElementById("scheduleTypeSelect").value;

  loadSchedulesContentAux(type, title);
}

// Is called by search to reload content on the kiosk
function loadSchedulesContentAux(type, title) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      //Clear all content in the div
      document.getElementById("scheduleManagerKiosk").innerHTML = "";

      for (var i = 0; i < res.scheduleTypes.length; i++) {
        if(type == "" || type == res.scheduleTypes[i].name){
          //Populate schedules manager
          var typeHeading = document.createElement("h2");
          typeHeading.innerHTML = res.scheduleTypes[i].name; 
          document.getElementById("scheduleManagerKiosk").appendChild(typeHeading);
        }else{
          continue;
        }

        //add all schedules for each schedule type in its own div with delete button
        for (var j = 0; j < res.scheduleTypes[i].schedules.length; j++) {
          if(title == "" || title == res.scheduleTypes[i].schedules[j].title){
            var scheduleDiv = document.createElement("div");
            scheduleDiv.id = res.scheduleTypes[i].name + res.scheduleTypes[i].schedules[j].title;
            scheduleDiv.className = "content-input"
            document.getElementById("scheduleManagerKiosk").appendChild(scheduleDiv);
  
            var scheduleTitle = document.createElement("h4");
            scheduleTitle.innerHTML = res.scheduleTypes[i].schedules[j].title; 
            scheduleDiv.appendChild(scheduleTitle);
  
            var scheduleP = document.createElement("p");
            scheduleP.innerHTML = res.scheduleTypes[i].schedules[j].description + "<br> Start: " + 
                                  res.scheduleTypes[i].schedules[j].startTime + " End: " + res.scheduleTypes[i].schedules[j].startTime; 
            scheduleDiv.appendChild(scheduleP);
          }
        }
      }
    }
  };
  xhttp.open("GET", "/getSchedulesParams", true);
  xhttp.send();
}