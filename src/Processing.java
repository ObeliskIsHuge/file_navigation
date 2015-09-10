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

        // Processes the command file
        processCommands();

        closeFiles();


    }

    /***
     * Closes all the files
     */
    private void closeFiles(){
        gISRecordFile.closeFile();
        commandFile.closeFile();
        outputFile.closeFile();
    }

    /***
     * Processes the command file
     */
    private void processCommands(){

        String commandLine = commandFile.getNextCommand();

        // Keep running until all the commands have been processed
        while (commandLine != null){

            String[] pieces = commandLine.split("\\t");
            // Decides which action to take
            switch(pieces[0]) {

                case "show_name":
                    outputFile.stillImplementing("show_name");
                    break;
                case "show_latitude":
                    outputFile.stillImplementing("show_latitude");
                    break;
                case "show_longitude":
                    outputFile.stillImplementing("show_longitude");
                    break;
                case "show_elevation":
                    outputFile.stillImplementing("show_elevation");
                    break;
                case "quit":
                    outputFile.stillImplementing("quit");
                    break;
                default:
                    // Do Nothing
                    break;
            }

            commandLine = commandFile.getNextCommand();
        }
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
                recordReport = gISRecordFile.processNextRecordLocation();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputFile.printNewLine();
    }

    /***
     * Prints the header information for the Results.txt file
     */
    private void begin(){
        outputFile.printHeader();
    }
}
