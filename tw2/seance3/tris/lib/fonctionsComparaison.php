<?php
/**
* Compares two absolute values
*
* @param int $i first value
* @param int $j second value
* @return a number < 0 if  $i < $j, 0 if $i == $j, > 0 if $i > $j
*/
function compareAbs($i, $j) {
  return abs($i)-abs($j);
}


/**
* Compares two strings depending on their length
*
* @param string $str1 first string
* @param string $str2 second string
* @return a number < 0 if the str1's length < str2's length
* 0 if they have the same length
* a number > 0 if str1's length > str2's length
*/
function comparerChainesParLongueur($str1, $str2) {
  return strlen($str1) - strlen($str2);
}


/**
* Compares two strings depending on their length
*
* @param string $str1 first string
* @param string $str2 second string
* @return a number < 0 if the str1's length < str2's length
* the opposite result of strcmp function if they have the same length
* a number > 0 if str1's length > str2's length
*/
function comparerChainesParLongueurPlus($str1, $str2) {
  $diff = strlen($str1) - strlen($str2);
  if ($diff == 0) {
    return -strcmp($str1, $str2);
  } else {
    return $diff;
  }
}
?>
