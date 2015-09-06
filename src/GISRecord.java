/**
 *
 * Object represents a single GIS Record
 *
 * @author Brandon Potts
 * @version August 29, 2015
 */
public class GISRecord {


    // Feature ID
    private String fId;
    // Feature Name
    private String fName;
    // Feature Class
    private String fClass;
    // State Alphabetic Code
    private String sAC;
    // State Numeric Code
    private String sNC;
    // Country Name
    private String cName;
    // County Numeric Code
    private String cNC;
    // Primary latitude (DMS)
    private String pLatitudeDMS;
    // Primary longitude (DMS)
    private String pLongitudeDMS;
    // Primary latitude (dec deg)
    private String pLatitudeDD;
    // Primary longitude (dec deg)
    private String pLongitudeDD;
    // Source latitude (DMS)
    private String sLatitude;
    // Source longitude (DMS)
    private String sLongitude;
    // Source Latitude (dec deg)
    private String sLatitudeDD;
    // Source Longitude (dec deg)
    private String sLongitudeDD;
    // Elevation in Meters
    private String elevationInMeters;
    // Elevation in Feet
    private String elevationInFeet;
    // Map Name
    private String mapName;
    // Date Created
    private String dateCreated;
    // Date Edited
    private String dateEdited;

    /***
     * Class constructor
     */
    public GISRecord(){

        this.fId = "";
        this.fClass = "";
        this.fName = "";
        this.sAC = "";
        this.sNC = "";
        this.cName = "";
        this.cNC = "";
        this.pLatitudeDMS = "";
        this.pLongitudeDMS = "";
        this.pLatitudeDD = "";
        this.pLongitudeDD = "";
        this.sLatitude = "";
        this.sLongitude = "";
        this.elevationInMeters = "";
        this.elevationInFeet = "";
        this.mapName = "";
        this.sLatitudeDD = "";
        this.sLongitudeDD = "";
        this.dateCreated = "";
        this.dateEdited = "";

    }


    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
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

    public String getsAC() {
        return sAC;
    }

    public void setsAC(String sAC) {
        this.sAC = sAC;
    }

    public String getsNC() {
        return sNC;
    }

    public void setsNC(String sNC) {
        this.sNC = sNC;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcNC() {
        return cNC;
    }

    public void setcNC(String cNC) {
        this.cNC = cNC;
    }

    public String getpLatitudeDMS() {
        return pLatitudeDMS;
    }

    public void setpLatitudeDMS(String pLatitudeDMS) {
        this.pLatitudeDMS = pLatitudeDMS;
    }

    public String getpLongitudeDMS() {
        return pLongitudeDMS;
    }

    public void setpLongitudeDMS(String pLongitudeDMS) {
        this.pLongitudeDMS = pLongitudeDMS;
    }

    public String getpLatitudeDD() {
        return pLatitudeDD;
    }

    public void setpLatitudeDD(String pLatitudeDD) {
        this.pLatitudeDD = pLatitudeDD;
    }

    public String getpLongitudeDD() {
        return pLongitudeDD;
    }

    public void setpLongitudeDD(String pLongitudeDD) {
        this.pLongitudeDD = pLongitudeDD;
    }

    public String getsLatitude() {
        return sLatitude;
    }

    public void setsLatitude(String sLatitude) {
        this.sLatitude = sLatitude;
    }

    public String getsLongitude() {
        return sLongitude;
    }

    public void setsLongitude(String sLongitude) {
        this.sLongitude = sLongitude;
    }

    public String getElevationInMeters() {
        return elevationInMeters;
    }

    public void setElevationInMeters(String elevationInMeters) {
        this.elevationInMeters = elevationInMeters;
    }

    public String getElevationInFeet() {
        return elevationInFeet;
    }

    public void setElevationInFeet(String elevationInFeet) {
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


    public String getsLatitudeDD() {
        return sLatitudeDD;
    }

    public void setsLatitudeDD(String sLatitudeDD) {
        this.sLatitudeDD = sLatitudeDD;
    }

    public String getsLongitudeDD() {
        return sLongitudeDD;
    }

    public void setsLongitudeDD(String sLongitudeDD) {
        this.sLongitudeDD = sLongitudeDD;
    }

}
