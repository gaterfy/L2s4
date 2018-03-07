<?php
/**
* Returns the name of the line given if there is a ':' in line
*
* @param string $line The line in which there is the property name
* @return string The name of the property
*/
function propertyName($line) {
  if (strpos($line,':')==false) {
    throw new Exception("There is no ':' in line");
  }
  return trim(explode(':',$line)[0]);
}


/**
* Returns the value of the line given if there is a ':' in line
*
* @param string $line The line in which there is the property name
* @return string The value of the property
*/
function propertyValue($line) {
  if (strpos($line,':')==false) {
    throw new Exception("There is no ':' in line");
  }
  return trim(explode(':',$line)[1]);
}

/*
function readBook($file) {
  $table = array();
  $line = fgets($file);
  while ($line !== FALSE) {
      $table[propertyName($line)] = propertyValue($line);
      $line = fgets($file);
  }
  return $table;
}
*/


/**
* Read a file and construct a table of books in which property names are keys and property values the values
*
* @param string $file The file of books
* @return array A table of books
*/
function readBook($file) {
  $table = array();
  $line = fgets($file);
  if ($line == FALSE) {
    return $table;
  }
  $line = trim($line);
  if ($line == '') {
    while ($line == '') {
      $line = trim(fgets($file));
    }
  }
  while (($line !== '') && ($line !== FALSE)) {
    $table[propertyName($line)] = propertyValue($line);
    $line = trim(fgets($file));
  }
  return $table;
}


/**
* Build a simple HTML element
*
* @param string $propName The name of the class
* @param string $elementType The type of the element
* @param string $text The content of the element
* @return string The HTML code corresponding to the simple element
*/
function elementBuilder($propName, $elementType, $text) {
  return '<'.$elementType.' class="'.$propName.'">'.$text.'</'.$elementType.'>';
}


/**
* Build the HTML code corresponding to the authors
*
* @param string $propName The name of the class
* @return string The HTML code corresponding to the authors
*/
function authorsToHTML($authors) {
  $authors = explode(' - ',$authors);
  return '<span>'.implode('</span> <span>',$authors).'</span>';
}


/**
* Build the HTML code corresponding to the cover of the book
*
* @param string $fileName The value of the attribute 'src'
* @return string The HTML code corresponding to the img element
*/
function coverToHTML($fileName) {
  return '<img src="couvertures/'.$fileName.'" alt="image de couverture" />';
}


/**
* Build the HTML code depending on the property given
*
* @param string $propName The name of the property
* @param string $propName The value of the property
* @return string The HTML element corresponding to the good property
*/
function propertyToHTML($propName, $propValue) {
  switch ($propName) {
    case 'titre':
      return elementBuilder($propName, 'h2', $propValue);
      break;
    case 'couverture':
      return elementBuilder($propName, 'div', coverToHTML($propValue));
      break;
    case 'auteurs':
      return elementBuilder($propName,'div', authorsToHTML($propValue));
      break;
    case 'annee':
      return elementBuilder($propName, 'time', $propValue);
      break;
    default:
      return elementBuilder($propName, 'div', $propValue);
      break;
  }
}


/**
* Build the HTML code for a book
*
* @param array $book The table of properties and the values corresponding
* @return string The HTML code corresponding to a book
*/
function bookToHTML($book) {
  $description = array();
  foreach ($book as $prop => $value) {
    if ($prop !== 'couverture') {
      $description[$prop] = propertyToHTML($prop,$value);
    }
  }
  return elementBuilder('livre','article',propertyToHTML('couverture',$book['couverture']).elementBuilder('description','div',implode('',$description)));
}


/**
* Build the HTML code for a library
*
* @param file $file The file describing the books
*/
function libraryToHTML($file) {
  $book = readBook($file);
  while ($book != array()) {
    echo bookToHTML($book);
    echo "\n";
    $book = readBook($file);
  }
}
?>
