/**
 * WordMain class : a class that uses Word class and executes its methods
 *
 * @author : LOMBART Thomas - VASILEV Martin
 */

public class WordMain {
    
    public static void usage() {
	System.out.println("usage: java WordMain <myWord>");
	System.exit(0);
    }
    
    public static void main(String[] args) {
	if (args.length != 1) {
	    usage();
	} else {
	    Word m = new Word(args[0]);
	    System.out.println("Your word is : " + m);
	    System.out.println("Number of characters : " + m.nbOfChars());
	    System.out.println("Your reversed word is : " + m.reverse());
	    System.out.println("Your word is a palindrome : " + m.isPalindrome());
	    System.out.println("Your word is a proper noun : " + m.isProperNoun());
	    Word t = new Word("banana");
	    System.out.println(m.isAnagram(t));
	    System.out.println(t);
	}
    }
}
