package programmingquestions;

import java.util.LinkedHashSet;

public class RemoveDuplicatesString {
    public static void main(String[] args) {
        String str = "This is a is a string to check for duplicates";
        String newstr = removeDuplicates(str);
        System.out.println(newstr);
    }

    private static String removeDuplicates(String str) {
        String[] words = str.split(" ");

        LinkedHashSet lhset = new LinkedHashSet<String>();
        for(String word : words){
            lhset.add(word);
        }

        String newstr = lhset.toString();
        newstr = newstr.replace(",","").replace("[","").replace("]", "");
        
        
        return newstr;
    }
}
