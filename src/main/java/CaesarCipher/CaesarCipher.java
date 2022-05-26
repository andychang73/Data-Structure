package CaesarCipher;

import java.util.HashMap;
import java.util.Map;


public class CaesarCipher {

   private final Map<Character, Character> encryptMap;
   private final Map<Character, Character> decryptMap;

   public CaesarCipher(int rotation){
        encryptMap = new HashMap<>(52);
        decryptMap = new HashMap<>(52);
        initMaps(rotation);
   }

   private void initMaps(int rotation){
       initMap('a','z', rotation, encryptMap, new Encryption());
       initMap('A','Z', rotation, encryptMap, new Encryption());
       initMap('a','z', rotation, decryptMap, new Decryption());
       initMap('A','Z', rotation, decryptMap, new Decryption());
   }

   private void initMap(char first, char last, int rotation, Map<Character, Character> map, Shift shift){
       for(char i = first; i <= last; i++){
           map.put(i, shift.shift(first, i, last, rotation));
       }
   }

   public String encrypt(String input){
       return shift(input, encryptMap);
   }

   public String decrypt(String input){
       return shift(input, decryptMap);
   }

   private String shift(String input, Map<Character, Character> map){
       char[] charArray = input.toCharArray();
       for(int i = 0; i < charArray.length; i++){
           if(charArray[i] != ' '){
               charArray[i] = map.get(charArray[i]);
           }
       }
       return new String(charArray);
   }

   public static class Encryption implements Shift{

       @Override
       public char shift(int first, int current, int last, int rotation) {
           return (char)(first + ((current - first + rotation) % 26));
       }
   }

   public static class Decryption implements Shift{

       @Override
       public char shift(int first, int current, int last, int rotation) {
           return (char)(first + (current - first - rotation + 26) % 26);
       }
   }
}
