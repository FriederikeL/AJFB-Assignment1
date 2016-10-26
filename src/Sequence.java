/**
 * Created by user on 21.10.2016.
 */
public class Sequence {

    private String header = "";
    private int numbA = 0;
    private int numbG = 0;
    private int numbC = 0;
    private int numbU = 0;
    private int numbSpace = 0;
    private String sequence = " ";
    private int Slength = 0;

    public Sequence(String seq, String head){
        sequence = seq;
        numbA = countAs(seq);
        numbG = countGs(seq);
        numbU = countUs(seq);
        numbC = countCs(seq);
        numbSpace = countSpaces(seq);
        Slength = seq.length();
        header = head;
    }

    public int getAs(){
        return(numbA);
    }
    public int getGs(){
        return(numbG);
    }
    public int getCs(){
        return(numbC);
    }
    public int getUs(){
        return(numbU);
    }
    public String getSequence(){
        return(sequence);
    }
    public int getSlength(){
        return(Slength);
    }
    public int getSpaces(){
        return(numbSpace);
    }
    public String getHeader(){
        return(header);
    }




    private static int countAs(String seq){
        int number = 0;
        for(int i =0; i< seq.length(); i++) {
            if (seq.charAt(i) == 'A') {
                number++;
            }
        }
        return(number);
    }
    private static int countGs(String seq){
        int number = 0;
        for(int i =0; i< seq.length(); i++) {
            if (seq.charAt(i) == 'G') {
                number++;
            }
        }
        return(number);
    }
    private static int countCs(String seq){
        int number = 0;
        for(int i =0; i< seq.length(); i++) {
            if (seq.charAt(i) == 'C') {
                number++;
            }
        }
        return(number);
    }
    private static int countUs(String seq){
        int number = 0;
        for(int i =0; i< seq.length(); i++) {
            if (seq.charAt(i) == 'U') {
                number++;
            }
        }
        return(number);
    }
    private static int countSpaces(String seq){
        int number = 0;
        for(int i =0; i< seq.length(); i++) {
            if (seq.charAt(i) == '-') {
                number++;
            }
        }
        return(number);
    }



}
