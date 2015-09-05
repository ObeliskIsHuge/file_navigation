/**
 *
 *  Object is the 'connection' between input and output
 *
 * @author Brandon Potts
 * @version August 29, 2015
 */
public class Processing {


    private FileOutput outputFile;


    /***
     * Class Constructor
     */
    public Processing(){

        outputFile = new FileOutput("Results.txt");
    }


    public void begin(){
        outputFile.printHeader();
    }
}
