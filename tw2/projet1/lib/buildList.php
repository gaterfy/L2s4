<?php
/*
buildList.php

Projet : V'LiVe
Noms : LOMBART Thomas- VASILEV Martin
Date : 20 Mars 2017
*/

require_once('Station.class.php');

function buildList($data)
{
    $stationList = '';
    foreach ($data->{'records'} as $record) {
        $station = new Station($record->{'fields'}, $record->{'record_timestamp'});
        $stationList .= $station->toListElement();
    }
    return $stationList;
}

function buildFullDescription($data)
{
  $html = '';
  $record = $data->{'records'}[0];
  $station = new Station($record->{'fields'}, $record->{'record_timestamp'});
  return $station->toFullDescription();
}
