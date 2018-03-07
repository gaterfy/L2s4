<?php
/*
proxyConfig.php

Projet : V'LiVe
Noms : LOMBART Thomas- VASILEV Martin
Date : 20 Mars 2017
*/

$configContext = array(
	       'http' => array(
	       	      'proxy' => 'tcp://cache.univ-lille1.fr:3128',
		      'request_fulluri' => true
		      )
	);
stream_context_set_default($configContext);
?>
