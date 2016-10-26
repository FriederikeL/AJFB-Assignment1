import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 21.10.2016.
 */
public class FastaTool {

    private int[] numbers;
    private ArrayList<Sequence> sequencelist = new ArrayList<>();


    public FastaTool(String[] files){
        sequencelist = parseFile(files);
        numbers = searchNumbers(sequencelist);
    }

    public ArrayList<Sequence> getSequenclist(){
        return(sequencelist);
    }
    public int[] getNumbers(){
        return(numbers);
    }



    private static ArrayList<Sequence> parseFile(String[] files){
        ArrayList<Sequence> seqs = new ArrayList<Sequence>();
        try{
            String actualSeq = "";
            String actualHead = "";
            BufferedReader br = new BufferedReader(new FileReader(files[0]));
            String line;
            // process the lines
            while((line = br.readLine()) != null){
                // concatenate the lines of sequence to one string and build a Sequence object with it.

                if(line.charAt(0) != '>'){
                    actualSeq += line;
                }
                else{
                    if(actualHead != ""){
                        seqs.add(new Sequence(actualSeq, actualHead));
                    }
                    actualSeq = "";
                    actualHead = line;
                }
            }
            seqs.add(new Sequence(actualSeq, actualHead));
            return(seqs);
        } catch (FileNotFoundException e) {
            System.out.println("Filepath could not be opened");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return(seqs);
    }
/**gets the requiered numbers:
    numbers[0] = shortestlength
    numbers[1] = shortestlength excluding "-"s
    numbers[2] = average length
    numbers[3] = average length excluding "-"s
    numbers[4] = longest length
    numbers[5] = longest length excluding "-"s
    numbers[6] = counts A
    numbers[7] = counts C
    numbers[8] = counts G
    numbers[9] =counts U
    numbers[10] = counts -
    **/

    private static int[] searchNumbers(ArrayList<Sequence> list){
        int numbers[] = new int[11];
        numbers[0] = list.get(0).getSlength();
        numbers[1] = numbers[0] - list.get(0).getSpaces();
        numbers[4] = numbers[0];
        numbers[5] = numbers[1];

        for(int i = 0; i< list.size(); i++ ){
            Sequence actualseq = list.get(i);
            // get average and counts Nucleotids
            numbers[2] += actualseq.getSlength();
            numbers[6] += actualseq.getAs();
            numbers[8] += actualseq.getGs();
            numbers[7] += actualseq.getCs();
            numbers[9] += actualseq.getUs();
            numbers[10] += actualseq.getSpaces();
            numbers[3] = numbers[6] + numbers[8] + numbers[7] + numbers[9];
            // get shortest and longest length
            if(actualseq.getSlength() < numbers[0]){
                numbers[0] = actualseq.getSlength();
            }
            else if(actualseq.getSlength() > numbers[4]){
                numbers[4] = actualseq.getSlength();
            }
            if(actualseq.getSlength()- actualseq.getSpaces() < numbers[1]){
                numbers[1] = actualseq.getSlength() - actualseq.getSpaces();
            }
            else if(actualseq.getSlength()-actualseq.getSpaces() > numbers[5]){
                numbers[5] = actualseq.getSlength() - actualseq.getSpaces();
            }
        }

        numbers[2] = numbers[2]/list.size();
        numbers[3] = numbers[3]/list.size();
        numbers[5] = numbers[5];
        return(numbers);
    }


}
