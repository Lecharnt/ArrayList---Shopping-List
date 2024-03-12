import java.util.ArrayList;

public class ShoppingCart {
    private ItemOrder ItemOrder;
    private ArrayList<ItemOrder> list;
    public ShoppingCart(ItemOrder ItemOrder){
        this.ItemOrder = ItemOrder;
        list = new ArrayList<ItemOrder>();
    }
    public void addArrayList(ItemOrder ItemOrder){
        list.add(ItemOrder);
    }
    public ArrayList<ItemOrder> getArrayList() {
        return list;
    }
}