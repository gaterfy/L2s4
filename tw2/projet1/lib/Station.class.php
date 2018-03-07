<?php
/*
Station.class.php

Projet : V'LiVe
Noms : LOMBART Thomas- VASILEV Martin
Date : 20 Mars 2017
*/

class Station
{
    private $id;
    private $name;
    private $city;
    private $address;
    private $type;
    private $nbBicycles;
    private $nbPlaces;
    private $state;
    private $coordinates;
    private $timestamp;

  /*
   * A station is initialized with all its values and the record timestamp
   */
  public function __construct($fields, $timestamp)
  {
      $this->id = $fields->{'libelle'};
      // Name
      $name = explode(" ",$fields->{'nom'});
      if ($name[count($name)-1]=='(CB)') {
        unset($name[count($name)-1]);
      }
      unset($name[0]);
      $this->name = implode(" ",$name);
      $this->city = $fields->{'commune'};
      $this->address = $fields->{'adresse'};
      $this->type = $fields->{'type'};
      $this->nbBicycles = $fields->{'nbVelosDispo'};
      $this->nbPlaces = $fields->{'nbPlacesDispo'};
      $this->state = $fields->{'etat'};
      $this->coordinates = $fields->{'geo'};
      $this->timestamp = $timestamp;
  }

  /*
   * Builds the HTML Code corresponding to a station in a list
   * @return the HTML Code corresponding to a station in a list
   */
    public function toListElement()
    {
        $name = "<li class='address'><strong>{$this->name}, {$this->city}</strong></li>";
        $info = "<li class='nb-info'><span>{$this->nbBicycles} <i class='fa fa-bicycle' aria-hidden='true'></i> </span><span>{$this->nbPlaces} <i class='fa fa-plug' aria-hidden='true'></i></span></li>";
        $button = "<div class='btn-info'><a class='btn btn-detail' href=\"lib/detail.php?id={$this->id}\">Voir le detail</a><a class='btn btn-carte' >Voir sur la carte</a></div>";
        $res = "<ul id=\"{$this->id}\" data-nbb=\"{$this->nbBicycles}\" data-nbp=\"{$this->nbPlaces}\" data-name=\"{$this->name}\" data-state=\"{$this->state}\" data-city=\"{$this->city}\" data-adress=\"{$this->address}\" data-lon=\"{$this->coordinates[0]}\" data-lat=\"{$this->coordinates[1]}\" > {$name} {$info} {$button}</ul>";
        return $res;
    }

    /*
     * Builds the HTML Code corresponding to a station in full description
     * @return the HTML Code corresponding to a station in full description
     */
    public function toFullDescription()
    {
        $title = "<h1 class='underline bold'>Fiche complète</h1>";
        $name = "<h3 class='name'><span class='underline bold'>Station</span>: {$this->name}</h3>";
        $adress = "<h4 class='adress'><span class='bold underline'>Adresse complète</span>:</h4><p> - {$this->address}, {$this->city}";
        $coord = "<h4 class=\"coord bold underline\">Coordonnées :</h4><p>Longitude : {$this->coordinates[0]}, Latitude : {$this->coordinates[1]}</p>";
        $state = "<p class='state'><span class='underline'>Etat de la station</span>: <span id=\"state\">{$this->state}</span></p>";
        $table = "<table><tr><th>Terminal de paiement électronique:</th><th>Nombre de vélos disponibles</th><th>Nombre de places disponibles</th></tr><tr>";
        $table .= "<td><span><i class='fa fa-credit-card' aria-hidden='true'></i> {$this->type}</span></td>";
        $table .= "<td><span>{$this->nbBicycles} <i class='fa fa-bicycle' aria-hidden='true'></i></span></td>";
        $table .= "<td><span>{$this->nbPlaces} <i class='fa fa-plug' aria-hidden='true'></i></span></td></tr></table>";
        $res = "<div id=\"id\" data-lon=\"{$this->coordinates[0]}\" data-lat=\"{$this->coordinates[1]}\">{$title} {$name} {$adress} {$coord} {$state} {$table}</div>";
        return $res;
    }
}
