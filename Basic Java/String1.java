public class String1 {
    public static void main(String[] args) {
      char character = 'Z';
      String magicWord = "XYZZY";
      char h='m';
      
      char anotherChar = magicWord.charAt(0);
  
      System.out.println(anotherChar + h );

      System.out.println((char) anotherChar + (char) h );
      System.out.println( String.valueOf(anotherChar) + String.valueOf(h) );
      
    }
  }