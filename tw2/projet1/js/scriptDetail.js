/*
scriptDetail.js

Projet : V'LiVe
Noms : LOMBART Thomas- VASILEV Martin
Date : 20 Mars 2017
*/

window.addEventListener("load", function makeMap(e) {
  // Creation de la carte
  var map = L.map("carteStation");
  // Ajouter les annotations
  L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: '©️ <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
  }).addTo(map);
  // Placer les marquers
  putStationOnMap(map);
  //setStateColor
  setStateColor();
});

function putStationOnMap(map) {
  //Get the element
  var theEl = document.querySelector("div#id");
  // point creation
  var point = [theEl.dataset.lon, theEl.dataset.lat];
  //Marker creation
  marker = L.marker(point).addTo(map);
  //Center the map onto the marker
  map.fitBounds([point]);
}

function setStateColor() {
  var span = document.getElementById('state');
  if (span.innerHTML == "EN SERVICE") {
    span.style.backgroundColor = 'lightgreen';
    span.style.padding = "1%";
  }
  else {
    span.style.backgroundColor = 'lightred';
  }
}

function errorPage() {
  document.body.innerHTML = '<span class=\'error\'>Something went wrong</span>';
}
