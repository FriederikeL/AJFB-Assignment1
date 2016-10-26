


/**
 * Created by user on 21.10.2016.
 */
public class CommandLine {
/**
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

    public static void writeOut(FastaTool tool){
        int splitter = 0;
        Sequence actualSeq;
        int formatter = 57;

        while(splitter < tool.getNumbers()[4]){
            if(splitter+59 <= tool.getNumbers()[4]) {
                System.out.println(String.format("%27s %" + formatter+"s", splitter+1 , splitter+60));
            }
            else{
                System.out.println(String.format("%28s %" + formatter+"s", splitter+1 , tool.getNumbers()[4]));
            }
            for(int i = 0; i< tool.getSequenclist().size(); i++){
                actualSeq = tool.getSequenclist().get(i);
                if(splitter+59 <= tool.getNumbers()[4]) {
                    System.out.println(String.format("%-25s %s", actualSeq.getHeader().substring(1), actualSeq.getSequence().substring(splitter, splitter + 60)));
                }
                else{
                    System.out.println(String.format("%-25s %s", actualSeq.getHeader().substring(1), actualSeq.getSequence().substring(splitter, tool.getNumbers()[4])));
                }
            }
            splitter +=60;
        }

        System.out.println("");
        System.out.println(String.format("%-15s %s", "Number of sequences: ", tool.getSequenclist().size()));
        System.out.println(String.format("%-20s%-5s%-15s%s", "Shortest length: " , tool.getNumbers()[0] , " (excluding '-'s: " , tool.getNumbers()[1] + ")")) ;
        System.out.println(String.format("%-20s%-5s%-15s%s","Average length: " , tool.getNumbers()[2] , " (excluding '-'s: " , tool.getNumbers()[3] + ")"));
        System.out.println(String.format("%-20s%-5s%-15s%s", "Longest length: " , tool.getNumbers()[4] , " (excluding '-'s: " , tool.getNumbers()[5] + ")"));
        System.out.println("Counts: A: " + tool.getNumbers()[6] + ", C: " + tool.getNumbers()[7] + ", G: " + tool.getNumbers()[8] + ", U: " +tool.getNumbers()[9] + ", '-': " + tool.getNumbers()[10]);

    }

    public static void main(String[] args) {

        if (args.length == 0) {

            System.out.println("Error. No Filename received");
            System.exit(0);
        }

        FastaTool myTool = new FastaTool(args);
        writeOut(myTool);


    }
}
