import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * Object handles the seeking across the file
 *
 * @author Brandon Potts
 * @version August 29, 2015
 */
public class FileNavigator {


//    private String lineTerminator;
    // Current file that is being processed
    private RandomAccessFile currentFile;
    // Holds location of the last valid offset
    private long finalOffset;
    // Holds the location of the first official character
    private long firstRecordOffset;

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
//        lineTerminator = System.getProperty("line.separator");
        finalOffset = -1;
        firstRecordOffset = -1;
    }

    /***
     *
     * @return
     */
    public long getFinalOffset() {
        return finalOffset;
    }

    /****
     *
     * @param finalOffset
     */
    public void setFinalOffset(long finalOffset) {
        this.finalOffset = finalOffset;
    }

    /***
     *
     * @return
     */
    public long getFirstRecordOffset() {
        return firstRecordOffset;
    }

    /***
     *
     * @param firstRecordOffset
     */
    public void setFirstRecordOffset(long firstRecordOffset) {
        this.firstRecordOffset = firstRecordOffset;
    }


    /***
     * Processes the next line of Records
     * @return RecordReporter of the next record
     *         null if the file has reached the end
     */
    public RecordReporter processNextRecordLocation() throws IOException {

        // Discards the header line of the text file
        if(currentFile.getFilePointer() == 0 ){
            currentFile.readLine();
            firstRecordOffset = currentFile.getFilePointer();
        }

        long offset = currentFile.getFilePointer();
        String currentLine = currentFile.readLine();

        // Checks to see if the end has been reached
        if(currentLine == null){

            this.finalOffset = offset;
            resetFilePointer();
            return null;
        }

        LineParser parsedLine = new LineParser(currentLine);
        GISRecord gisRecord = parsedLine.buildGISRecord();

        return new RecordReporter(offset , gisRecord.getfId());
    }

    /***
     * Closes the current file
     */
    public void closeFile(){
        try {
            currentFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * Returns the next command
     * @return String that contains the next command
     */
    public String getNextCommand(){

        String currentLine = null;

        try {
            currentLine = currentFile.readLine();

            // Checks to see if the end has been reached
            if(currentLine == null){
                return null;
            }
            while(currentLine.charAt(0) == ';'){
                currentLine = currentFile.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return currentLine;
    }

    /***
     * Executes the "Show Name" command
     * @param offset is the offset in the file
     * @return
     */
    public String commandShowName(long offset){

        String validOffset = validateOffset(offset);

        // Checks to see if an error was found
        if(validOffset != null){
            return validOffset;
        }

        // Reads the valid line and parses the line
        LineParser line = new LineParser(readCurrentLine());
        GISRecord record = line.buildGISRecord();

        return record.getfName();
    }


    private GISRecord seekToRecord(long offset){

        //TODO start here
        return null;
    }

    /***
     *
     * @param offset
     * @return
     */
    public long commandShowLatitude(long offset){
        return -1;
    }

    /***
     *
     * @param offset
     * @return
     */
    public long commandShowLongitude(long offset){
        return -1;
    }

    /***
     *
     * @param offset
     * @return
     */
    public long commandShowElevation(long offset){
        return -1;
    }


    /****
     * Checks to see if the offset is valid
     * @param goalOffset location of the offset
     * @return null if no errors
     *         String of the error if error is found
     */
    private String validateOffset(long goalOffset){

        // Checks to see if the offset is positive
        if(goalOffset < 0){
            return "Offset not positive";
            // Checks to see if the offset is within range
        } else if (goalOffset > finalOffset) {
            return "Offset too large";
            // Checks to see if the offset is aligned
        } else if (goalOffset < firstRecordOffset){ //TODO this may need to be fixed
            return "Unaligned offset";
        }

        seekToPosition(firstRecordOffset);
        long currentOffset = getCurrentFilePointer();
//        long oldOffset = -1;
        String currentLine = readCurrentLine();

        // Runs until the end of the file is reached ( which should never happen )
        while(currentLine != null){

            // Will be true when we've found the offset
            if(currentOffset == goalOffset){
                seekToPosition(currentOffset);
                return null;
                // Will be true when we've passed our sought after offset
            } else if (currentOffset > goalOffset){
                return "Unaligned offset";
            }

            // Moves to the next line and updates the pointer
//            oldOffset = currentOffset;
            currentOffset = getCurrentFilePointer();
            currentLine = readCurrentLine();
        }
        return null;
    }

    /***
     * Seeks to the position that the parameter specifies
     * @param offset position that will be seeked to
     */
    private void seekToPosition(long offset){
        try {
            currentFile.seek(offset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * Returns the offset of the current file pointer
     * @return offset of the current file pointer
     */
    private long getCurrentFilePointer(){
        long currentOffset = -1;
        try {
            currentOffset = currentFile.getFilePointer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentOffset;
    }

    /***
     * Reads the line that currentFile is currently pointing at
     * @return String of the currentLine
     *         null if the end of the file has been reached
     */
    private String readCurrentLine(){

        String currentLine = null;
        try {
            currentLine = currentFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return currentLine;
    }

    /***
     * Resets the location of the file pointer
     */
    private void resetFilePointer(){
        try {
            currentFile.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
