import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * File handles the outfile printing
 *
 * @author Brandon Potts
 * @version September 04, 2015
 */
public class FileOutput {

    private RandomAccessFile outputFile;
    private String lineTerminator;

    /***
     * Class constructor
     * @param fileName name of the file
     */
    public FileOutput(String fileName){
        File file = new File(fileName);
        try {
            outputFile = new RandomAccessFile(file , "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lineTerminator = System.getProperty("line.separator");
    }


    /**
     * Prints the header for the results file
     */
    public void printHeader(){

        String header = "GIS data file contains the following records:";
        printLine(header);
        printLine("\n");
    }


    /**
     * Prints a line to the output file
     *
     * @param line String that will be printed
     */
    public void printLine(String line){
        try {
            outputFile.writeChars(line + lineTerminator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
