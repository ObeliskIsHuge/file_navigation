/**
 *
 * Class holds the data necessary to report record locations
 *
 *
 * @author Brandon Potts
 * @version September 05, 2015
 */
public class RecordReporter {

    // offset of record location
    private long offset;
    // Feature Name of the record
    private String fID;


    /***
     * Constructor for the class
     * @param offset offset of the record
     * @param fID feature name of the record
     */
    public RecordReporter(long offset, String fID){

        this.offset = offset;
        this.fID = fID;
    }

    /***
     * Returns the offset of the record
     * @return offset
     */
    public long getOffset() {
        return offset;
    }

    /***
     * Returns the Feature Id of the class
     * @return Feature Id
     */
    public String getfID() {
        return fID;
    }

}
