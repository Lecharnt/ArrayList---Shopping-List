public class ItemOrder{
    private Item Item;
    private double amount;
    public ItemOrder(Item Item,double amount){
        this.Item = Item;
        this.amount = amount;
    }
    public Item getItem(){
        return Item;
    }
    public double getAmount(){
        return amount;
    }
    public int getDeal(){
        if(amount >= 3){
            return 2;
        }
        return 1;
    }
}