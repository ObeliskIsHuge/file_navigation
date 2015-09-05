/**
 *
 * Class holds a single record location
 *
 * @author Brandon Potts
 * @version September 05, 2015
 */
public class RecordReporter {

    private long offset;
    private long fID;


    public RecordReporter(long offset, long fID){

        this.offset = offset;
        this.fID = fID;
    }

    public long getOffset() {
        return offset;
    }

    public long getfID() {
        return fID;
    }

}
