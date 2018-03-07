<?php
/**
* Builds a <circle> element
* @param int $cx the cx attribute
* @param int $cy the cy attribute
* @param int $r the r attribute
* @return the HTML code corresponding to the circle element
*/
function cercle($cx, $cy, $r) {
  return "<circle cx=$cx cy=$cy r=$r />";
}

/**
* Builds a <rect> element inside a <circle> element
* @param int $cx the cx attribute of the <circle> element
* @param int $cy the cy attribute of the <circle> element
* @param int $r the r attribute of the <circle> element
* @param int $angle the angle we want to apply to the <rect> element in order to rotate it
*/
function carre($cx, $cy, $r, $angle = 0) {
  $c = $r*sqrt(2);
  $cxn = $cx - ($c/2);
  $cyn = $cy - ($c/2);
  return "<rect x=\"$cxn\" y=\"$cyn\" width=\"$c\" height=\"$c\" transform=\"rotate($angle,$cx,$cy)\" />";
}

/**
* Builds a <polygon> element inside a <circle> element
* @param int $cx the cx attribute of the <circle> element
* @param int $cy the cy attribute of the <circle> element
* @param int $r the r attribute of the <circle> element
* @param int $angle the angle we want to apply to the <polygon> element in order to rotate it
* @return the HTML code corresponding to the <polygon> element
*/
function triangleInscrit($cx, $cy, $r, $angle = 0) {
  $s1 = $cx.','.($cy + $r);
  $s2 = ($cx - (($r*sqrt(3))/2)).','.($cy - ($r/2));
  $s3 = ($cx + (($r*sqrt(3))/2)).','.($cy - ($r/2));
  return "<polygon points=\"$s1 $s2 $s3\" transform=\"rotate($angle,$cx,$cy)\" />";
}
?>
