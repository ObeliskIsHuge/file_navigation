/**
 *
 * Object represents a single GIS Record
 *
 * @author Brandon Potts
 * @version August 29, 2015
 */
public class GISRecord {


    // Feature ID
    private int fId;
    // Feature Name
    private String fName;
    // Feature Class
    private String fClass;
    // State Alphabetic Code
    private char [] sAC;
    // State Numeric Code
    private int sNC;
    // Country Name
    private String cName;
    // County Numeric Code
    private int cNC;
    // Primary latitude (DMS)
    private Coordinate pLatitudeDMS;
    // Primary longitude (DMS)
    private Coordinate pLongitudeDMS;
    // Primary latitude (dec deg)
    private double pLatitudeDD;
    // Primary longitude (dec deg)
    private double pLongitudeDD;
    // Source latitude (DMS)
    private Coordinate sLatitude;
    // Source longitude (DMS)
    private Coordinate sLongitude;

    private int elevationInMeters;
    private int elevationInFeet;
    private String mapName;
    private String dateCreated;
    private String dateEdited;

    public GISRecord(int nFId , String nFName , String nFClass , char [] nSAC, int nSNC , String nCName, int nCNC,
                     Coordinate nPLatitudeDMS , Coordinate nPLongitudeDMS , double nPLatitudeDD , double nPLongitudeDD,
                     Coordinate nSLatitude , Coordinate nSLongitude , int nElevationInMeters, int nElevationInFeet ,
                     String nMapName, String nDateCreated, String nDateEdited){

        fId = nFId;
        fClass = nFClass;
        fName = nFName;
        sAC = nSAC;
        sNC = nSNC;
        cName = nCName;
        cNC = nCNC;
        pLatitudeDMS = nPLatitudeDMS;
        pLongitudeDMS = nPLongitudeDMS;
        pLatitudeDD = nPLatitudeDD;
        pLongitudeDD = nPLongitudeDD;
        sLatitude = nSLatitude;
        sLongitude = nSLongitude;
        elevationInMeters = nElevationInMeters;
        elevationInFeet = nElevationInFeet;
        mapName = nMapName;
        dateCreated = nDateCreated;
        dateEdited = nDateEdited;

    }


    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfClass() {
        return fClass;
    }

    public void setfClass(String fClass) {
        this.fClass = fClass;
    }

    public char[] getsAC() {
        return sAC;
    }

    public void setsAC(char[] sAC) {
        this.sAC = sAC;
    }

    public int getsNC() {
        return sNC;
    }

    public void setsNC(int sNC) {
        this.sNC = sNC;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcNC() {
        return cNC;
    }

    public void setcNC(int cNC) {
        this.cNC = cNC;
    }

    public Coordinate getpLatitudeDMS() {
        return pLatitudeDMS;
    }

    public void setpLatitudeDMS(Coordinate pLatitudeDMS) {
        this.pLatitudeDMS = pLatitudeDMS;
    }

    public Coordinate getpLongitudeDMS() {
        return pLongitudeDMS;
    }

    public void setpLongitudeDMS(Coordinate pLongitudeDMS) {
        this.pLongitudeDMS = pLongitudeDMS;
    }

    public double getpLatitudeDD() {
        return pLatitudeDD;
    }

    public void setpLatitudeDD(double pLatitudeDD) {
        this.pLatitudeDD = pLatitudeDD;
    }

    public double getpLongitudeDD() {
        return pLongitudeDD;
    }

    public void setpLongitudeDD(double pLongitudeDD) {
        this.pLongitudeDD = pLongitudeDD;
    }

    public Coordinate getsLatitude() {
        return sLatitude;
    }

    public void setsLatitude(Coordinate sLatitude) {
        this.sLatitude = sLatitude;
    }

    public Coordinate getsLongitude() {
        return sLongitude;
    }

    public void setsLongitude(Coordinate sLongitude) {
        this.sLongitude = sLongitude;
    }

    public int getElevationInMeters() {
        return elevationInMeters;
    }

    public void setElevationInMeters(int elevationInMeters) {
        this.elevationInMeters = elevationInMeters;
    }

    public int getElevationInFeet() {
        return elevationInFeet;
    }

    public void setElevationInFeet(int elevationInFeet) {
        this.elevationInFeet = elevationInFeet;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(String dateEdited) {
        this.dateEdited = dateEdited;
    }

}
