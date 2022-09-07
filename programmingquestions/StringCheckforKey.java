package programmingquestions;
public class StringCheckforKey {

    public static void main(String[] args) {
        String message = "The quick brown fox jumps over the lazy dog";
        String message1 = "Codility We test coders";
        String message2 = "Why not              ";
        String message3 = "To crop or not to crop";

        int key = 100;

        String result = checkForKey(message2,key);
        
        System.out.println(result);
        System.out.println("Result Message Length: "+result.length());
    }

    private static String checkForKey(String str, int key) {

        System.out.println("Message: "+ str);
        System.out.println("Message Length: "+str.length());
        System.out.println("Key: "+ key);

        System.out.println("**** starting processing ****");

        // if k > str length, return str
        if(key >= str.length()){
            System.out.println("**** key is greater than or equals to str length ****");
            return str.trim();
        }

        else{
                
            System.out.println("**** key is smaller than str length ****");

            if(Character.isWhitespace(str.charAt(key))){
                System.out.println("**** white space just after key, string end is valid word ****");
                String newstr = str.substring(0, key);
                System.out.println("**** newstr="+newstr+" ****");
                return newstr;
            }
            else{
                System.out.println("**** no white space just after key, string end is invalid word ****");
                String newstr = str.substring(0, key);
                System.out.println("**** tempstr=" +newstr+" ****");
                System.out.println("**** processing last word ****");
                newstr = newstr.substring(0, newstr.lastIndexOf(" "));
                System.out.println("**** newstr="+ newstr + " ****");
                return newstr;
            }
             
        }
    }

    
}
