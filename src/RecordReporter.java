/**
 *
 * Class holds a single record location
 *
 * @author Brandon Potts
 * @version September 05, 2015
 */
public class RecordReporter {

    private long offset;
    private String fID;


    public RecordReporter(long offset, String fID){

        this.offset = offset;
        this.fID = fID;
    }

    public long getOffset() {
        return offset;
    }

    public String getfID() {
        return fID;
    }

}
