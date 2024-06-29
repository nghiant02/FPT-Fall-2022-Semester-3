
public class SoftDrink implements Comparable<SoftDrink> {

    String productLine;//type of product
    String company = null;//manufacturer
    int volume = 0;
    int price = 0;
//contrustors

    public SoftDrink(String productLine) {
        this.productLine = productLine;
    }

    public SoftDrink(String pLine, String company, int volume, int price) {
        this.productLine = pLine;
        this.company = company;
        this.volume = volume;
        this.price = price;
    }

    //tool for search operation - based on their productLine
    @Override
    public boolean equals(Object obj) {
        SoftDrink aSD = (SoftDrink) obj;
        return this.productLine.equals(aSD.productLine);
    }

    //tool for ascending soer by soft drink price then by pruduct line
    @Override
    public int compareTo(SoftDrink o) {
        int priceDif = this.price - o.price;
        if (priceDif < 0) {
            return -1;
        }
        if (priceDif > 0) {
            return 1;
        }
        return this.productLine.compareTo(o.productLine);
    }
    //convert data of the soft drink to String

    @Override
    public String toString() {
        return productLine + ", " + company + ", " + volume + ", " + price;
    }

}
