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
     * Returns the location of the last record
     * @return location of the last record
     */
    public long getFinalOffset() {
        return finalOffset;
    }

    /****
     * Sets the location of the last record
     * @param finalOffset location of the last offset
     */
    public void setFinalOffset(long finalOffset) {
        this.finalOffset = finalOffset;
    }

    /***
     *  Returns the offset of the first record
     * @return offset of the first record
     */
    public long getFirstRecordOffset() {
        return firstRecordOffset;
    }

    /***
     * Sets the first record
     * @param firstRecordOffset new first record
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
     * @return correct record or error if one occurred
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


//    private GISRecord seekToRecord(long offset){
//
//        //TODO start here
//        return null;
//    }

    /***
     *  Executes the show latitude command
     * @param offset offset of the record
     * @return correct record or error if one occurred
     */
    public String commandShowLatitude(long offset){

        String validOffset = validateOffset(offset);

        // Checks to see if an error was found
        if(validOffset != null){
            return validOffset;
        }

        // Reads the valid line and parses the line
        LineParser line = new LineParser(readCurrentLine());
        GISRecord record = line.buildGISRecord();

        return latAndLongFormatConvert("latitude" , record.getpLatitudeDMS());
    }

    /***
     *  Executes the show longitude command
     * @param offset offset of the record
     * @return correct record or error if one occurred
     */
    public String commandShowLongitude(long offset){

        String validOffset = validateOffset(offset);

        // Checks to see if an error was found
        if(validOffset != null){
            return validOffset;
        }

        // Reads the valid line and parses the line
        LineParser line = new LineParser(readCurrentLine());
        GISRecord record = line.buildGISRecord();

        return latAndLongFormatConvert("longitude" , record.getpLongitudeDMS());
    }

    /***
     * Executes the show elevation command
     * @param offset offset of the record
     * @return correct record or error if one occurred
     */
    public String commandShowElevation(long offset){

        String validOffset = validateOffset(offset);

        // Checks to see if an error was found
        if(validOffset != null){
            return validOffset;
        }

        // Reads the valid line and parses the line
        LineParser line = new LineParser(readCurrentLine());
        GISRecord record = line.buildGISRecord();

        // Checks to see if an elevation exists
        if (record.getElevationInFeet().equals("")){
            return "Elevation not given";
        }

        return record.getElevationInFeet();
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
        } else if (goalOffset < firstRecordOffset){
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


    /***
     * Converts a string representing the latitude or longitude and formats it properly
     * @param latOrLong latitude or longitude
     * @param line full line of the record
     * @return string in the converted format
     */
    private String latAndLongFormatConvert(String latOrLong , String line){

        String direction = "";
        String seconds;
        String minutes;
        String days;
        StringBuilder stringBuilder = new StringBuilder(line);
        int lineLength = stringBuilder.length();

        // holds the symbol for direction
        char directionChar = stringBuilder.charAt(lineLength - 1);

        switch (directionChar){

            case 'N':
                direction = "North";
                break;
            case 'E':
                direction = "East";
                break;
            case 'S':
                direction = "South";
                break;
            case 'W':
                direction = "West";
                break;
            default:
                // Do nothing
                break;
        }

        seconds = stringBuilder.substring(lineLength - 2 , lineLength - 3);

        // gets rid of the unnecessary '0' if it exists
        if(seconds.charAt(0) == '0'){
            seconds = "" + seconds.charAt(1);
        }

        minutes = stringBuilder.substring(lineLength - 4 , lineLength - 5);
        // gets rid of the unnecessary '0' if it exists
        if(minutes.charAt(0) == '0'){
            minutes = "" + minutes.charAt(1);
        }

        // checks to see if the we're converting for a latitude
        if(latOrLong.equals("latitude")){
            days = stringBuilder.substring(lineLength - 6 , lineLength - 7);
            if (days.charAt(0) == '0'){
                days = "" + days.charAt(1);
            }
            // will be true when we're converting for a longitude
        } else {
            days = stringBuilder.substring(lineLength - 6 , lineLength - 8);
            if (days.charAt(0) == '0'){
                days = "" + days.charAt(1) + days.charAt(2);
            }
        }

        return days + "d " + minutes + "m " + seconds + "s " + direction;
    }
}
