import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class coffeeShop {
    private JFrame frame;
    private JTextField textField1;
    private JComboBox<String> comboBox;
    private JButton button;

    public coffeeShop() {
        //JFrame window
        frame = new JFrame("Coffee Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        new JLabel("Order:");
        textField1 = new JTextField(10);
        new JTextField(10);
        String[] items = {"Espresso", "Cappuccino", "Latte","Moca"};
        comboBox = new JComboBox<String>(items);

        //button and add an action listener
        button = new JButton("Order");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String order = (String) comboBox.getSelectedItem();
                int cups = Integer.parseInt(textField1.getText());
                double price = 0.0;
                switch (order) {
                    case "Espresso":
                        price = 2.5;
                        break;
                    case "Cappuccino":
                        price = 3.0;
                        break;
                    case "Latte":
                        price = 3.5;
                        break;
                    case "Moca":
                        price = 0.8;
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Invalid order.");
                        return;
                }
                double total = price * cups;
                JOptionPane.showMessageDialog(frame, "Order: " + order + "\nCups: " + cups +
                        "\nPrice per cup: $" + price + "\nTotal price: $" + total);
            }
        });

        //JPanel and add the components
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Order:"));
        panel.add(comboBox);
        panel.add(new JLabel("Cups:"));
        panel.add(textField1);
        panel.add(button);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        // Add the panel to the JFrame and make it visible
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //instance of the CoffeeShopGUI class
        new coffeeShop();
    }
}
