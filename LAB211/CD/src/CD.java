public class CD {
    private String CDName, CDType, CDtitle, CDID, PublishingYear;
    private double UnitPrice;

    public CD() {
    }

    public CD(String CDID, String CDName, String CDType, String CDtitle, double UnitPrice, String PublishingYear) {
        super();
        this.CDName = CDName;
        this.CDType = CDType;
        this.CDtitle = CDtitle;
        this.CDID = CDID;
        this.UnitPrice = UnitPrice;
        this.PublishingYear = PublishingYear;
    }

    public String getCDName() {
        return CDName;
    }

    public void setCDName(String CDName) {
        this.CDName = CDName;
    }

    public String getCDType() {
        return CDType;
    }

    public void setCDType(String CDType) {
        this.CDType = CDType;
    }

    public String getCDtitle() {
        return CDtitle;
    }

    public void setCDtitle(String CDtitle) {
        this.CDtitle = CDtitle;
    }

    public String getCDID() {
        return CDID;
    }

    public void setCDID(String CDID) {
        this.CDID = CDID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitprice) {
        this.UnitPrice = unitprice;
    }

    public String getPublishingYear() {
        return PublishingYear;
    }

    public void setPublishingYear(String PublishingYear) {
        this.PublishingYear = PublishingYear;
    }

    public void print() {
        System.out.printf("%-7s|%-15s|%-15s|%-12s|%-12s|%-6s\n", CDID, CDName, CDType, CDtitle, UnitPrice, PublishingYear);
    }

    @Override
    public String toString() {
        return CDID + "," + CDName + "," + CDType + "," + CDtitle + "," + UnitPrice + "," + PublishingYear;
    }


}
