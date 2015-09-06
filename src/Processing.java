import java.io.IOException;

/**
 *
 *  Class controls the processing of the files
 *
 * @author Brandon Potts
 * @version August 29, 2015
 */
public class Processing {

    // File that contains where the results will be posted
    private FileOutput outputFile;
    // File that contains the GIS Records
    private FileNavigator gISRecordFile;
    // File that contains commands
    private FileNavigator commandFile;


    /***
     * Class constructor
     * @param gisRecordPath path to the GIS record
     * @param commandFilePath path to the command record
     */
    public Processing(String gisRecordPath , String commandFilePath){

        gISRecordFile = new FileNavigator(gisRecordPath);
        commandFile = new FileNavigator(commandFilePath);
        outputFile = new FileOutput("Results.txt");
    }

    /***
     * Processes all the files in the appropriate order
     */
    public void processFiles(){

        begin(); // TODO I could remove this method

        // Process all the record locations
        processRecordLocations();
    }

    /***
     * Processes all the locations of Records
     */
    private void processRecordLocations(){

        try {
            RecordReporter recordReport = gISRecordFile.processNextRecordLocation();
            // Keeps running until all the records have been processed
            while(recordReport != null){
               outputFile.printRecordReporter(recordReport);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        outputFile.printNewLine();
    }

    /***
     *
     */
    private void begin(){
        outputFile.printHeader();
    }
}
