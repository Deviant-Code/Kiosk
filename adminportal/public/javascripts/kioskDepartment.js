/* Functions used on the department kiosk module page */

//Grabs Json from server and parses then populates page with data
function loadDepartmentContent() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      //Clear all content on the page
      document.getElementById("departmentManagerKiosk").innerHTML = "";

      //For each floor
      for (var i = 0; i < res.images.length; i++) {
        
        //Add a floor div
        var floorDiv = document.createElement("div");
        floorDiv.className = "content-input"
        document.getElementById("departmentManagerKiosk").appendChild(floorDiv);

        //Add a floor heading
        var floorHeading = document.createElement("h2");
        floorHeading.innerHTML = "Floor " + i; 
        floorDiv.appendChild(floorHeading);

        //Add image for floor
        var floorImg = document.createElement("IMG");
        floorImg.setAttribute("src", res.images[i].location);
        floorImg.setAttribute("alt", "Floor " + i + " Plan");
        floorDiv.appendChild(floorImg);

        //add all rooms for floor
        /*
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
        }*/
      }
    }
  };
  xhttp.open("GET", "/getDepartmentParams", true);
  xhttp.send();
}

// Used by the serach div to reload the department manager display with specfied parameters as defined
function search(){
  term = document.getElementById("searchTerm").value;

  loadDepartmentContentAux(term);
}

// Is called by search to reload content on the kiosk
function loadDepartmentContentAux(term) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      //Clear all content in the div
      document.getElementById("departmentManagerKiosk").innerHTML = "";

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
  xhttp.open("GET", "/getDepartmentParams", true);
  xhttp.send();
}