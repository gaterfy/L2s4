<?php
/*
Identite.class.php

Noms : LOMBART Thomas- VASILEV Martin
Date : 27 Mars 2017
*/

session_start();

class Identite
{
    private $login;
    private $nom;
    private $prenom;

  /**
   * Constructs this Identity object
   * @param string $login the login used
   * @param string $nom the name used
   * @param string $prenom the first name used
   */
  public function __construct($login, $nom, $prenom)
  {
      $this->login = $login;
      $this->nom = $nom;
      $this->prenom = $prenom;
  }

  public function getName() {
    return $this->nom;
  }

  public function getFirstName() {
    return $this->prenom;
  }
}
