public class Item{
    private String name;
    private double price;
    private double exDate;
    public Item(String name,double price, double exDate){
        this.name = name;
        this.price = price;
        this.exDate = exDate;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public double getExDate(){
        return exDate;
    }
}