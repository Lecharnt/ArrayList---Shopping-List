import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    final int FRAME_WIDTH = 400;
    final int FRAME_HEIGHT = 400;
    public Main() {
        // Adds the total title sets the width and the height
        setTitle("BigY Store");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // creating a bar panel
        JPanel titleBar = new JPanel();
        titleBar.setPreferredSize(new Dimension(FRAME_WIDTH, 30));
        titleBar.setBackground(new Color(158, 143, 82));
        //creates labels for the UI
        JLabel heading = new JLabel("BigY Store");
        heading.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel title = new JLabel("What would you like to buy:");
        title.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel size = new JLabel("Buy three of something and get half off");
        size.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel LabelApple = new JLabel("Apple for $2.22 expires in 21 days");
        JLabel LabelMilk = new JLabel("Milk for $1.23 expires in 14 days");
        JLabel LabelEgg = new JLabel("Egg for $2.33 expires in 31 days");
        // Allows for user to input how much they want
        JTextField Apple = new JTextField("0");
        JTextField Milk = new JTextField("0");
        JTextField Egg = new JTextField("0");
        // Creates the buttion
        JButton button = new JButton("Confirm Purchase");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from JTextField
                int appleNum = Integer.parseInt(Apple.getText());
                int milkNum = Integer.parseInt(Milk.getText());
                int eggNum = Integer.parseInt(Egg.getText());
                // Defines the definition for the items
                Item appleDef = new Item("apple", 2.22,21);
                Item milkDef = new Item("milk", 4.52,14);
                Item eggDef = new Item("egg", 3.38,31);
                // This creates the message
                StringBuilder message = new StringBuilder("You have selected:\n\n");
                // This creates the shopping cart
                ItemOrder integrate = new ItemOrder(milkDef,0);
                ShoppingCart OrderShop = new ShoppingCart(integrate);
                //adds the items to the GUI
                if (appleNum>0) {
                    ItemOrder appleOrder = new ItemOrder(appleDef,appleNum);
                    OrderShop.addArrayList(appleOrder);
                }
                if (milkNum>0) {
                    ItemOrder milkOrder = new ItemOrder(milkDef,milkNum);
                    OrderShop.addArrayList(milkOrder);
                }
                if (eggNum>0) {
                    ItemOrder eggOrder = new ItemOrder(eggDef,eggNum);
                    OrderShop.addArrayList(eggOrder);
                }
                // Puts all info into the message
                for (ItemOrder order : OrderShop.getArrayList()) {
                    message.append("| " + order.getItem().getName() + " |\nQuantity:` " + order.getAmount()+"\nExpires in " + order.getItem().getExDate() +" days"+ "\nPrice: " + order.getAmount() * order.getItem().getPrice() / order.getDeal()+"\n");
                    if (order.getDeal() == 2){
                        message.append("You got a deal for half off of on " +  order.getItem().getName()+"\n\n");
                    }
                    else {
                        message.append("\n");
                    }
                }
                //displays the order summary
                JOptionPane.showMessageDialog(Main.this, message.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //adds all of the ui elements
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 1));
        contentPane.add(titleBar);
        contentPane.add(heading);
        contentPane.add(title);
        contentPane.add(size);
        contentPane.add(LabelApple);
        contentPane.add(Apple);
        contentPane.add(LabelMilk);
        contentPane.add(Milk);
        contentPane.add(LabelEgg);
        contentPane.add(Egg);
        contentPane.add(button);
        //adds it to the frame
        getContentPane().add(contentPane);
    }
    //make the frame visible
    public static void main(String[] args) {
        Main example = new Main();
        example.setVisible(true);
    }
}
