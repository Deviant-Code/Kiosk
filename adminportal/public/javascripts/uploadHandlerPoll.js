var resp1,resp2;

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

function loadPollContent() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      document.getElementById("poll1").value = res.pollResp1;
      document.getElementById("poll2").value = res.pollResp2;
      document.getElementById("pollQuestion").value = res.pollQuestion;
      document.getElementById("CurrentResponse").innerHTML =
        "Response 1 (" + res.pollResp1 +")<br>total votes = " + res.pollResp1Val +
        "<br><br>Response 2 (" + res.pollResp2 + ")<br>total votes = " + res.pollResp2Val ;
      document.getElementById("enabledValue").checked = (res.moduleEnabled == true);
      document.getElementById("defaultValue").checked = (res.default == true);
    }
  };
  xhttp.open("GET", "/getPollParams", true);
  xhttp.send();
}