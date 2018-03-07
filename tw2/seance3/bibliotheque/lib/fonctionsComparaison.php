<?php
/**
* Compares two books by their titles
*
* @param book $book1 operand for the comparison
* @param book $book2 operand for the comparison
* @return int <0 if $book1 is greater, >0 if $book2 is greater, 0 if equal
*/
function compareBooks($book1, $book2) {
  $title1 = $book1['titre'];
  $title2 = $book2['titre'];
  return strcmp($title1, $title2);
}
/**
* Compares two books by their categories => year of release => titles
*
* @param book $book1 operand for the comparison
* @param book $book2 operand for the comparison
* @return int <0 if $book1 is greater, >0 if $book2 is greater, 0 if equal
*/
function compareBooksCategories($book1, $book2) {
  if (strcmp($book1['catégorie'], $book2['catégorie']) == 0) {
    if (abs($book1['année']) - abs($book2['année2']) == 0) {
      return compareBooks($book1, $book2);
    } else {
      return abs($book1['année']) - abs($book2['année2']);
    }
  } else {
    return strcmp($book1['catégorie'], $book2['catégorie']);
  }
}
?>
