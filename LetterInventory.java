// Yiran Jia
// 4/5/18
// CSE143
// TA:  JASON WAATAJA 
// Assignment 1: LetterInventory
//
// This programs keeps tracking the count of each letter for the given string. 

public class LetterInventory {
   private String word; // input string  
   private int[] elementWord; // list of characters
   private int size; // total number of elements in the list
   
   public static final int DEFAULT_CAPACITY = 26; // capacity of list is a constant  
   
   // post: constructs a list of counts of the alphabetic letters 
   public LetterInventory(String data) {
      word = data.toLowerCase();  
      elementWord = new int[DEFAULT_CAPACITY];
      size = 0;
      for (int i = 0; i < word.length(); i++) {
         for (char j = 'a'; j <= 'z'; j++) {
            if (word.charAt(i) == j) {
               elementWord[word.charAt(i) - 'a']++;
               size++;
            }
         }
      } 
   } 
   
   // post: makes this letter lowercase
   private char lowerLetter(char letter) {
      letter = Character.toLowerCase(letter);
      return letter;
   }
   
   // post: checks if the given letter is alphabetic or if the value is positive, 
   // throwing an IllegalArgumentException it is not
   private void checkChar(char letter, int value) {
      if (!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException(); 
      }
   }
   
   // post: returns the current number of elements in the list
   public int size() {
      return size;
   }
   
   // post: returns if the list of letters is empty
   public boolean isEmpty() {
      return size == 0;
   } 
   
   // pre: the character is alphabetic    // post: returns how many of this letter are in the list 
   public int get(char letter) {
      letter = lowerLetter(letter);
      checkChar(letter, 1);
      return elementWord[letter - 'a'];
   }
   
   // post: creates bracketed version list of letters
   public String toString() {
      if (size == 0) {
         return "[]";
      } else {
         String result = "[";
         for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            for (int j = 0; j < elementWord[i]; j++) {
               result += (char)('a' + i);
            }
         }
         result += "]";
         return result;
      }
   }
   
   // pre: the character is alphabetic and the value is positive
   // (throws IllegalArgumentException if not)
   // post: makes the list contains the given value of the given letter
   public void set(char letter, int value) {
      letter = lowerLetter(letter);
      checkChar(letter, value);
      int oldValue = elementWord[letter - 'a'];
      elementWord[letter - 'a'] = value;
      size += value - oldValue; 
   }

   // post: creates a new inventory of letters   
   private LetterInventory create(String input) {
      LetterInventory newList = new LetterInventory(input);
      return newList;
   }
 
   // post: returns a new list contains the sum of the two lists
   public LetterInventory add(LetterInventory other) {
      LetterInventory addList = create(word + other.word);
      return addList;
   }
   
   // post: returns a new list shows the difference of counts of letters between 
   // two lists. It returns null if any count of letter is negative after subtracting
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory subList = create(word);
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         if (subList.elementWord[i] >= other.elementWord[i]) {
            subList.elementWord[i] -= other.elementWord[i];
         } else {
            return null;
         }
      }
      subList.size -= other.size;
      return subList;
   } 
}
   
       
      


            