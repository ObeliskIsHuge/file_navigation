import java.io.*;

/**
 *
 * File handles the outfile printing
 *
 * @author Brandon Potts
 * @version September 04, 2015
 */
public class FileOutput {


    //TODO this class prints to the file instead of the console

//    private RandomAccessFile outputFile;
//    private String lineTerminator;
//    private File file;
    private RandomAccessFile writer;
    private int commandCount;

    /***
     * Class constructor
     * @param fileName name of the file
     */
    public FileOutput(String fileName){
        File file = new File(fileName);
        try {
            this.writer = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        commandCount = 1;
    }


    /**
     * Prints the header for the results file
     */
    public void printHeader(){

        String header = "GIS data file contains the following records:";
        printLine(header);
        printNewLine();
    }


    /**
     * Prints a line to the output file
     *
     * @param line String that will be printed
     */
    public void printLine(String line){
//        try {
//            writer.writeChars(line);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(line);
    }

    /***
     * Prints a new line
     */
    public void printNewLine(){
//        try {
//            writer.writeChar('\n');
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.print("\n");
    }

    /***
     * Formats and prints the command output
     * @param commandLine command from the command file
     * @param response result from the execution of that command
     */
    public void printCommandResponse(String commandLine , String response){

        System.out.println(commandCount + ": " + commandLine + "\n\t" + response);
        commandCount++;
    }

    /***
     * Formats and prints a RecordReporter object
     * @param recordReporter RecordReporter that will be printed
     */
    public void printRecordReporter(RecordReporter recordReporter){

//        try {
//            writer.writeChars("    " + recordReporter.getOffset() + "   " + recordReporter.getfID());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("    " + recordReporter.getOffset() + "   " + recordReporter.getfID());
    }

    /***
     * Closes the writer file
     */
    public void closeFile(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stillImplementing(String command){
        System.out.println("Still implementing: " + command);
    }


}
