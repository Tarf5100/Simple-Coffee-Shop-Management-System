
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShopGUI extends JFrame {
    JFrame frame = new JFrame();
    
    public CoffeeShopGUI(CoffeeShop cafe) {
            
        frame.add(Box.createVerticalStrut(40));
        
        
        // Cofee Shop Welcome Label
        JLabel cafeName = new JLabel();
        cafeName.setText("WELCOME TO JAVA CAFE");
        cafeName.setForeground(Color.GRAY);
        cafeName.setFont(new Font("Times New Roman", Font.BOLD, 24));
        cafeName.setAlignmentX(Component.CENTER_ALIGNMENT);
        cafeName.setHorizontalTextPosition(JLabel.CENTER);
        cafeName.setVerticalTextPosition(JLabel.BOTTOM);
        frame.add(cafeName);
        
        // space 
        frame.add(Box.createVerticalStrut(50));
        
        // explains scenario
        JLabel info = new JLabel();
        info.setText("Fill in the following information to create a new menu item:");
        info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setHorizontalTextPosition(JLabel.CENTER);
        info.setVerticalTextPosition(JLabel.BOTTOM);
        frame.add(info);
        
        // creates space between two labels
        frame.add(Box.createVerticalStrut(20));
        
        // item type label
        JLabel itemType = new JLabel();
        itemType.setText("Choose item type:");
        itemType.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(itemType);
        
        // space
        frame.add(Box.createVerticalStrut(10));
        
        // radio option buttons 
        JRadioButton coffeeButton = new JRadioButton("Coffee");
        JRadioButton sweetsButton = new JRadioButton("Sweets");
        ButtonGroup group = new ButtonGroup();
        group.add(coffeeButton);
        group.add(sweetsButton);
        frame.add(coffeeButton);
        frame.add(sweetsButton);
        JPanel radioPanel = new JPanel();
        radioPanel.setOpaque(false);
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
        radioPanel.add(Box.createHorizontalGlue());
        radioPanel.add(coffeeButton);
        radioPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        radioPanel.add(sweetsButton);
        radioPanel.add(Box.createHorizontalGlue());
        frame.add(radioPanel);
        
        // creates space between two labels
        frame.add(Box.createVerticalStrut(40));
        
        // item name label
        JLabel itemNameLabel = new JLabel();
        itemNameLabel.setText("Enter item's name:");
        itemNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(itemNameLabel);
        
        // text field for item name
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setBounds(0, 300, 720, 100); // not sure
        textFieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        textFieldPanel.setBackground(new Color(0xFFF4F2));
        JTextField itemName = new JTextField();
        itemName.setPreferredSize(new Dimension(300, 40));
        textFieldPanel.add(itemName);
        frame.add(textFieldPanel);
                
                
        // item name label
        JLabel itemPriceLabel = new JLabel();
        itemPriceLabel.setText("Enter item's price:");
        itemPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(itemPriceLabel);
        
        // text field for item name
        JPanel priceFieldPanel = new JPanel();
        priceFieldPanel.setBounds(0, 300, 720, 50); // not sure
        priceFieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        priceFieldPanel.setBackground(new Color(0xFFF4F2));
        JTextField itemPrice = new JTextField();
        itemPrice.setPreferredSize(new Dimension(300, 40));
        priceFieldPanel.add(itemPrice);
        frame.add(priceFieldPanel);
        
        //add item button
        JButton add = new JButton();
        add.setBounds(200, 100, 250, 100);
        add.setPreferredSize(new Dimension(100, 50));
        add.setText("Add Item");
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemType = "";
                if (coffeeButton.isSelected()) {
                    String cName = itemName.getText();
                    int cExist = cafe.searchItemList(cName);
                    if(cExist == -1){
                    double cPrice = Double.parseDouble(itemPrice.getText());
                    Coffee c = new Coffee (cName, cPrice);
                    cafe.addToItemList(c);
                    JOptionPane.showMessageDialog(null, "Item added.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Item already exists.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                                            
                } else if (sweetsButton.isSelected()) {
                    String sName = itemName.getText();
                    int sExist = cafe.searchItemList(sName);
                    if(sExist == -1){
                    double sPrice = Double.parseDouble(itemPrice.getText());
                    Coffee s = new Coffee (sName, sPrice);
                    cafe.addToItemList(s);
                    JOptionPane.showMessageDialog(null, "Item added.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Item already exists.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(add);
        frame.add(Box.createVerticalGlue());
        frame.add(buttonPanel);
        
        
        // display menu button
        JButton menu = new JButton();
        menu.setBounds(200, 100, 250, 100);
        menu.setPreferredSize(new Dimension(150, 50));
        menu.setText("Display Menu");
        menu.setFocusable(false);
        menu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MainFrame frame = new MainFrame(cafe);
            }
        });
        JPanel button2Panel = new JPanel();
        button2Panel.setOpaque(false);
        button2Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        button2Panel.add(menu);
        frame.add(Box.createVerticalGlue());
        frame.add(button2Panel);
                
        
        frame.setTitle("Java Cafe");    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 720);
        frame.setLayout(null);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().setBackground(new Color(0xFFF4F2));
        frame.setVisible(true);
        
    }
    
    public static void main (String [] args)throws IOException{
      Scanner in = new Scanner(System.in);
            
      // cafe name:
      String cafeName = "Java cafe";
      // the maximum number of items in the shop :
      int itemList = 50;
      // the maximum expected number of order:
      int numO = 100;
      
      CoffeeShop cafe = new CoffeeShop(cafeName, itemList, numO);
      
      Item sw1 = new Sweets("Cookie", 7);
      Item sw2 = new Sweets("Pancake", 20);
      Item sw3 = new Sweets("Brownie", 10);
      
      cafe.addToItemList(sw1);
      cafe.addToItemList(sw2);
      cafe.addToItemList(sw3);
      
      Item c1 = new Coffee("Latte", 5);
      Item c2 = new Coffee("Cappuccino", 7);
      Item c3 = new Coffee("Cortado", 8);
      
      cafe.addToItemList(c1);
      cafe.addToItemList(c2);
      cafe.addToItemList(c3);
   
      int option;
      //file
      File f=new File("Menu.ser");
      FileOutputStream fos=new FileOutputStream(f);
      ObjectOutputStream oos=new ObjectOutputStream(fos);


     Item [] menu=cafe.itemL();
     
      for(int i=0;i<menu.length;i++){
               oos.writeObject(menu[i]);
           
               }

;
      CoffeeShopGUI gui = new CoffeeShopGUI(cafe);
      
      do {
         
         System.out.println("*** Actions ***");
         System.out.println("    1- Add Item to the menu");
         // System.out.println("    2- Remove Item from the menu");
         System.out.println("    2- Take Customer Order");
         System.out.println("    3- Display Inventory");
         System.out.println("    4- Update Inventory");
         System.out.println("    5- Exit System");
         System.out.println("Enter the number of your action: ");
         option = in.nextInt();
         
         switch (option){
            case 1:
            
               System.out.println("Enter 'Sweet' or 'Coffee' :");
               char type = in.next().charAt(0);
            
               switch (type){
                  case 'S':
                  case 's':
                     in.nextLine();
                     System.out.println("Enter item name:");
                     String sName = in.nextLine();
                     int sExist = cafe.searchItemList(sName);
                     double sPrice = 0;
                     if (sExist == -1){
                     
                     boolean enter=true;
                      Item s;
                      
                      while(enter){
                      try{
                        System.out.println("Enter item's base price:");
                        sPrice = in.nextDouble();
                        if(sPrice<=0){
                        throw new NegativePriceEx();
                        }
                        enter=false;
                        s = new Sweets(sName, sPrice);
                      
                        if (cafe.addToItemList(s)){
                           System.out.println("Item successfully added.");
                           oos.writeObject(s);
                         

                        }
                        else{
                           System.out.println("Item cannot be added.");
                           
                        }

                        }//unchecked exceptin 
                        catch (InputMismatchException m){
                        String str=in.next();
                        System.out.println("invalid input try again");
                       }//user define exceptin 
                       catch(NegativePriceEx N){
                       System.out.println(N.getMessage());
                       }
                      catch (FileNotFoundException j){
                          System.out.println("File does not exist");
                      }
                        }
                                             }
                     else{
                        System.out.println("The item already exists.");
                     }
                     break;
                  case 'C':
                  case 'c':
                     in.nextLine();
                     System.out.println("Enter item name:");
                     String cName = in.nextLine();
                     int cExist = cafe.searchItemList(cName);
                     double cPrice = 0;
                     if (cExist == -1){
                        System.out.println("Enter item's base price:");
                        cPrice = in.nextDouble();
                        Item c = new Coffee(cName, cPrice);
                        if (cafe.addToItemList(c)){
                           System.out.println("Item successfully added.");
                           oos.writeObject(c);
                        
                        }
                        else{
                           System.out.println("Item cannot be added.");
                        }
                     }
                     else{
                        System.out.println("The item already exists.");
                     }
                     break;
               }
                           
          
                             
               break;
               
            case 2:
            
               System.out.println("***MENU***");
      
               try{ 
               ObjectInputStream ois= new ObjectInputStream(new FileInputStream(new File("Menu.ser")));
               Item c;
               for(int i=0;i<menu.length;i++){
               c=(Item)ois.readObject();
               System.out.println(c);
               }
               
               }//uchecked exception 
               catch(ClassNotFoundException y){
                    System.out.println("error");
               }
               catch (FileNotFoundException t){
                   System.out.println("file doesn't exist");
               }
               catch(IOException l){
                    System.out.println("error");
               }
               
              
               System.out.println("Enter customer's name:");
               String customerN = in.next();
               System.out.println("Enter customer's phone number:");
               String pNum = in.next();
               System.out.println("Enter the number of items the customer wants to buy:");
               int numItems = in.nextInt();
               Order o = new Order(customerN, pNum, numItems);
               boolean correctType = true;
               for (int i=0; i<numItems; i++){
                  System.out.println("Enter 'S' for sweets and 'C' for coffee:");
                  char itemType = in.next().charAt(0);
                  String itemName;
                  int loc = 0;
                  double p=0;
                  int q =0;
                  switch (itemType){
                     case 's':
                     case 'S':
                        do{
                           System.out.println("Enter item name:");
                           itemName = in.next();
                           loc = cafe.searchItemList(itemName);
                           in.nextLine();
                           if(cafe.itemList[loc] instanceof Sweets){
                              System.out.println("Enter flavor:");
                              String flav = in.next();
                              in.nextLine();
                              System.out.println("Enter 'true' if with ice cream or 'false if without:");
                              boolean ic = in.nextBoolean();
                              in.nextLine();
                              System.out.println("Enter quantity:");
                              int sQuantity = in.nextInt();
                              p = cafe.itemList[loc].getP();
                              q = cafe.itemList[loc].getQ(); //i
                              Item sweet = new Sweets(itemName, p, flav, ic, sQuantity, cafe.itemList[loc]);
                              if (sQuantity <= q){
                                 o.addItem(sweet);
                                 // updates the quantity of the original item according to the number ordered by the customer
                                 cafe.itemList[loc].updateQuantity(sQuantity);
                                 correctType = true;
                                 break;
                              }
                              else{
                                 System.out.println("Only " + q + " left of this item. Try again.");
                                 correctType = false;
                              }

                           }
                           else
                              System.out.println("This item is not of type Sweet, try again.");
                              correctType = false;
                        } while(!correctType);
                        break;
                        
                     case 'c':
                     case 'C':
                        do {
                           System.out.println("Enter item name:");
                           itemName = in.next();
                           loc = cafe.searchItemList(itemName);
                           in.nextLine();
                           if (cafe.itemList[loc] instanceof Coffee){
                              System.out.println("Enter number of shots:");
                              int shots = in.nextInt();
                              in.nextLine();
                              System.out.println("Enter 'S' for small, 'M' for medium, or 'L' for large:");
                              char s = in.next().charAt(0);
                              in.nextLine();
                              System.out.println("Enter quantity:");
                              int cQuantity = in.nextInt();
                              p = cafe.itemList[loc].getP();
                              q = cafe.itemList[loc].getQ();
                              Item coffee = new Coffee(itemName, p, shots, s, cQuantity, cafe.itemList[loc]);
                              if (cQuantity <= q){
                                 o.addItem(coffee);
                                 // updates the quantity of the original item according to the number ordered by the customer                           }
                                 cafe.itemList[loc].updateQuantity(cQuantity);
                                 correctType = true;
                                 break;
                              }
                              else{
                                 System.out.println("Only " + q + " left of this item. Try again.");
                                 correctType = false;
                              }
                           }
                           else
                              System.out.println("This item is not of type coffee, try again.");
                              correctType = false;
                        } while(!correctType);
                        break;
                  }
               }
               o.displayOrder();
               break;
               
            case 3:
               cafe.displayItemList();
               break;
               
            case 4:
               System.out.println("Enter item name:");
               String iName = in.next();
               int i = cafe.searchItemList(iName);
               System.out.println("Enter the amount of item you want to add:");
               int amount = in.nextInt();
               cafe.itemList[i].restock(amount);
               break;
            case 5:
               option = 5;
               break;
            default:
               System.out.println("Action not found.");
               break; 
         }
      } while(option !=5); 
   }
}
