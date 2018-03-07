/**
 * Word class : a class to represent word with several usefull functions
 *
 * @author : LOMBART Thomas - VASILEV Martin
 */

public class Word {

    // ATTRIBUTS
    /* contains the string that represents the characters of this word */
    private String value;

    // CONSTRUCTEURS
    /** builds Word defined by its characters
     * @param s the string that contains the characters for this Word object
     */
    public Word(String s) {
	this.value = s;
    }

    // METHODES
    /**
     * returns <code>true</code> if <code>o</code> is equals to this word object, ie if
     * <code>o</code> is a Word and its value is the same as this word's value
     *
     * @param o the object to be compared with this Word
     * @return <code>true</code> iff <code>o</code> is a Word with the same value as this word.
     */
    public boolean equals(Object o) {
	if (o instanceof Word) {
	    Word theOther = (Word) o;
	    return this.value.equals(theOther.value);
	} else {
	    return false;
	}
    }

    /**
     * gives the number of characters of the word
     * @return the word object value's length
     */
    public int nbOfChars() {
	return this.value.length();
    }

    /**
     * Represents the word object
     * @return a String object representing the word object
     */
    public String toString() {
	return this.value;
    }

    /**
     * Gives the number of occurrences of the character <code>c</code> in this Word
     * @param c the character we want to count in the word
     * @return the number of occurrences of the character given in parameter in the Word
     */
    public int nbOccurrencesOfChar(char c) {
	int countChar = 0;
	for (int i = 0; i < this.value.length(); i++) {
	    if (this.value.charAt(i) == c) {
		countChar++;
	    }
	}
	return countChar;
    }

    /**
     * Reverses this Word value
     * @return a new Word object whose value is the string reversed of this Word object
     */
    public Word reverse() {
	String reversedString = "";
	for (int i = this.value.length()-1; i >= 0; i--) {
	    reversedString += this.value.charAt(i);
	}
	Word reversedWord = new Word(reversedString);
	return reversedWord;
    }

    /**
     * Checks if this Word is a palindrom
     *
     * @return <code>true</code> if this Word is a palindrom.
     */
    public boolean isPalindrome() {
	Word reversedWord = this.reverse();
	return reversedWord.equals(this);
    }

    /**
     * Checks if this Word value's contains <code>m</code>
     * @param m the word to check
     * @return <code>true</code> iff the Word contains <code>m</code>
     */
    public boolean contains(Word m) {
	int position = this.value.indexOf(m.toString().charAt(0));
	if (position != -1) {
	    return this.value.substring(position, position + m.nbOfChars()).equals(m.toString());
	} else {
	    return false;
	}
    }

    /**
     * Tells if the last three characters of  <code>m</code> are the same as this Word's value last three characters
     * @param m the word to check
     * @return <code>true</code> iff the last three characters of <code>m</code> are the same as this Word's value last three characters
     */
    public boolean rhymesWith(Word m) {
	if ((m.nbOfChars() > 3) && (this.value.length() > 3)) {
	    String lastThreeCharsOfWord = m.toString().substring(m.toString().length()-3);
	    return this.value.endsWith(lastThreeCharsOfWord);
	}
	return false;
    }

    /**
     * Checks whether this Word is a proper noun (starts with an upper-case letter) or not
     * @return <code>true</code> if this Word is a proper noun.
     */
    public boolean isProperNoun() {
	return Character.isUpperCase(this.value.charAt(0));
    }

    /**
     * Checks whether this Word is an anagram (contains the same letters) or not
     * @param m The Word that will be compared
     * @return <code>true</code> if this word is an anagram.
     */
    public boolean isAnagram(Word m) {
	String word = m.value;
	if (this.value.length() != m.value.length()) return false;
	else {
	    for (int i=0; i<this.value.length(); i++) {
		int j = word.indexOf(this.value.charAt(i));
		if (j==-1) return false;
		else {
		    //Remove the character that has been found
		    word = word.substring(0,j) + word.substring(j+1);
		}
	    }
	    //Passed all tests
	    return true;
	}
    }

    /**
     * Divides this Word into a list of two subwords with <code>c</code>
     * @param c The character with which the word is to be divided
     * @return A list of the subwords divided by <code>c</code>
     */
    public Word[] extractBefore(char c) {
	int i = this.value.indexOf(c);
	if (i != -1) {
	    Word[] W =  {new Word(this.value.substring(0,i+1)),
			  new Word(this.value.substring(i+1))};
	    return W;
	}
	else {
	    Word[] W = {new Word(""), this};
	    return W;
	}
    }
}
