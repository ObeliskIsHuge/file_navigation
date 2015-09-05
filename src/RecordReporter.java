/**
 *
 * Class holds a single record location
 *
 * @author Brandon Potts
 * @version September 05, 2015
 */
public class RecordReporter {

    private String offset;
    private String fID;


    public RecordReporter(String offset, String fID){

        this.offset = offset;
        this.fID = fID;
    }

    public String getOffset() {
        return offset;
    }

    public String getfID() {
        return fID;
    }

}
