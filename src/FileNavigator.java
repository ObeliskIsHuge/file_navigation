import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * Object handles the seeking across the file
 *
 * @author Brandon Potts
 * @version August 29, 2015
 */
public class FileNavigator {


    private String lineTerminator;
    private RandomAccessFile currentFile;

    /***
     * Class constructor
     * @param fileName is the name of the file that will be seeked through
     */
    public FileNavigator(String fileName){

        File file = new File(fileName);
        try {
            currentFile = new RandomAccessFile(file , "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lineTerminator = System.getProperty("line.separator");
    }




    /***
     * Resets where the location of the file pointer
     */
    private void resetFilePointer(){
        //TODO
    }
}
