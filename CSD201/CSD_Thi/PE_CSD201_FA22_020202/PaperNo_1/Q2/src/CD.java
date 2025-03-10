// =========================================================
// Do NOT modify this file 
// =========================================================

class CD {
    String owner;
    int price,color;
    
    // Default constructure
    CD () {}
    
    // Constructor with full parameter
    CD (String xOwner, int xPrice, int xColor) {
        this.owner = xOwner;
        this.price = xPrice; 
        this.color = xColor;
    }
    
    @Override
    public String toString(){
        return "(" +owner+","+price + "," + color + ")";
    }

    public int getPrice() {
        return this.price;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public void setColor(int inColor) {
        this.color = inColor;
    }
    
    public void setPrice(int inPrice) {
        this.price = inPrice;
    }
    
    public void setOwner(String inOwner) {
        this.owner = inOwner;
    }
}