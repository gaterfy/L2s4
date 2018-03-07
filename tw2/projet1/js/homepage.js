/*
homepage.js

Projet : V'LiVe
Noms : LOMBART Thomas- VASILEV Martin
Date : 20 Mars 2017
*/

// VARIABLES GLOBALES
var markerList = [];
var pointsList = [];
var map;

function dessinerCarte(){
    map = L.map('carteCampus').setView([50.60976, 3.13909], 16);

    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '©️ <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    placerMarquers(map);
}

function placerMarquers(map) {
    var listeStations = document.querySelectorAll("#stations-div ul");
    for (var i=0; i<listeStations.length; i++) {
    	//Informations utiles
    	var nbVelos = listeStations[i].dataset.nbb
    	var nbPlaces = listeStations[i].dataset.nbp;
    	var nom = listeStations[i].querySelector('li.address').innerHTML;
    	var id = listeStations[i].getAttribute('id');
    	//var icon = new VliveImage(parseInt(nbVelos),parseInt(nbPlaces)); /* L\'icon fait buger le mouseover (VOIR AVEC PROF) */
    	var divPopup = document.createElement("div");
      divPopup.className = "popuptext";
      divPopup.setAttribute("data-id",id);
      divPopup.innerHTML = nom;
      var info = document.createElement("h3");
      info.innerHTML = nbVelos + " <i class='fa fa-bicycle' aria-hidden='true'></i><br>" + nbPlaces + "<i class='fa fa-plug' aria-hidden='true'></i>";
      var button = document.createElement("button");
      button.className = "btn btn-popup";
      button.innerHTML = "Mettre en tete de liste";
      divPopup.appendChild(info);
      divPopup.appendChild(button);
    	var point = [listeStations[i].dataset.lon,listeStations[i].dataset.lat];
    	var marker = L.marker(point).addTo(map).bindPopup(divPopup);
      marker.on("mouseover",function() {
        this.openPopup();
      });
      marker.on("popupopen",function(e) {
        var noeudPopup = e.popup._contentNode;
        var bouton = noeudPopup.querySelector("button");
        bouton.addEventListener("click",selectStation);
      });
    	pointsList.push(point);
      markerList[id] = marker;
    }
    map.fitBounds(pointsList);
}

function selectStation() {
  var oldSelected = document.getElementsByClassName("selected")[0];
  var selectedStation = document.getElementById(this.parentElement.dataset.id);
  var parent = selectedStation.parentElement;
  if (oldSelected) {
    oldSelected.classList.remove('selected');
  }
  selectedStation.classList.add("selected");
  parent.removeChild(selectedStation);
  parent.insertBefore(selectedStation, parent.firstChild);

}

function popOnMouseOver() {
  markerList[this.getAttribute('id')].openPopup();
}

function voirSurCarte() {
  var station = this.parentElement.parentElement;
  var coords = [station.dataset.lon, station.dataset.lat];
  map.fitBounds([coords]);
  fillFocusBlock(station);
}

/**
 * Fonctions qui remets la carte a son etat originale
 */
function resetMap() {
  map.fitBounds(pointsList);
}

/**
 * Fonction qui change le contenu du div#focus
 */
function fillFocusBlock(station) {
  var stationsDiv = document.getElementById("stations-div")
  stationsDiv.style.display = "none";
  var focus = document.getElementById("focus");
  focus.style.display = "block";
  // Reset first the content
  focus.innerHTML = "";
  var title = document.createElement("h2");
  title.innerHTML = "Station " + station.dataset.name;
  var address = document.createElement("p");
  address.innerHTML = "<strong>Adresse complète : </strong><br>" + station.dataset.adress + ", "+ station.dataset.city;
  var state = document.createElement("span");
  state.innerHTML = "En service : ";
  state.innerHTML += station.dataset.state === "EN SERVICE" ? "<i class='fa fa-check' aria-hidden='true'></i>" : "<i class='fa fa-times' aria-hidden='true'></i>";
  var info = document.createElement("div");
  info.className = "btn-info";
  var detail = document.createElement("a");
  detail.className = "btn btn-detail";
  detail.href = "lib/detail.php?id=" + station.getAttribute('id');
  detail.innerHTML = "Voir le détail";
  var stationList = document.createElement("a");
  stationList.className = "btn btn-list";
  stationList.innerHTML = "Liste des stations";
  stationList.addEventListener("click",function() {
    map.fitBounds(pointsList);
    stationsDiv.style.display = 'block';
    focus.style.display = 'none';
  });
  info.appendChild(detail)
  info.appendChild(stationList);
  focus.appendChild(title)
  focus.appendChild(address)
  focus.appendChild(state)
  focus.appendChild(info);
}

function filter() {
  document.getElementById('carteCampus').classList.remove('blur');
  var formDiv = document.getElementById("form-div");
  var stationsDiv = document.getElementById("stations-div");
  var focusDiv = document.getElementById("focus");
  focusDiv.style.display = "none";
  formDiv.style.display = "none";
  stationsDiv.style.display = "block";
}

function stationList() {
  document.getElementById('carteCampus').classList.add('blur');
  var formDiv = document.getElementById("form-div");
  var stationsDiv = document.getElementById("stations-div");
  var focusDiv = document.getElementById("focus");
  focusDiv.style.display = 'none';
  stationsDiv.style.display = "none";
  formDiv.style.display = "flex";
  formDiv.style.justifyContent = "center";
  formDiv.style.alignItems = "center";
}

function init() {
  var stations_btn = document.getElementById("stations");
  var form = document.getElementById("search");

  stations_btn.addEventListener("click", filter);
  form.addEventListener("click", stationList);

  var stationsDiv = document.getElementById("stations-div");
  var stations = stationsDiv.querySelectorAll('ul');
  for (i=0; i<stations.length; i++) {
    //La fonctionalite de `Voir sur carte`
    stations[i].querySelector('.btn-carte').addEventListener('click',voirSurCarte);
    //On rajoute l'event listener sur le survol d'une station
    stations[i].addEventListener('mouseover',popOnMouseOver);
  }

  //On rajoute la fonctionalite de `reset` de la carte
  var floatBtn = document.querySelector("#float button");
  floatBtn.addEventListener('click',resetMap);

  dessinerCarte();
}

window.addEventListener('load',init);
