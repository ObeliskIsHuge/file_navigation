import java.io.*;

/**
 *
 * File handles the outfile printing
 *
 * @author Brandon Potts
 * @version September 04, 2015
 */
public class FileOutput {

//    private RandomAccessFile outputFile;
//    private String lineTerminator;
//    private File file;
    private RandomAccessFile writer;

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
//        try {
//            outputFile = new RandomAccessFile(file , "rw");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        this.lineTerminator = System.getProperty("line.separator");
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
//            outputFile.writeChars(line + lineTerminator);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            writer.writeChars(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * Prints a new line
     */
    public void printNewLine(){
        try {
            writer.writeChar('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * Formats and prints a RecordReporter object
     * @param recordReporter RecordReporter that will be printed
     */
    public void printRecordReporter(RecordReporter recordReporter){

        try {
            writer.writeChars("    " + recordReporter.getOffset() + "   " + recordReporter.getfID());
        } catch (IOException e) {
            e.printStackTrace();
        }
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


}
