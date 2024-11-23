import java.util.*;
import java.io.*;

public class CoffeeShopManagementSystem{
//  public static void main (String [] args)throws IOException{
//      CoffeeShopGUI gui = new CoffeeShopGUI();
//      Scanner in = new Scanner(System.in);
//            
//      // cafe name:
//      String cafeName = "Java cafe";
//      // the maximum number of items in the shop :
//      int itemList = 50;
//      // the maximum expected number of order:
//      int numO = 100;
//      
//      CoffeeShop cafe = new CoffeeShop(cafeName, itemList, numO);
//      
//      Item sw1 = new Sweets("Cookie", 7);
//      Item sw2 = new Sweets("Pancake", 20);
//      Item sw3 = new Sweets("Brownie", 10);
//      
//      cafe.addToItemList(sw1);
//      cafe.addToItemList(sw2);
//      cafe.addToItemList(sw3);
//      
//      Item c1 = new Coffee("Latte", 5);
//      Item c2 = new Coffee("Cappuccino", 7);
//      Item c3 = new Coffee("Cortado", 8);
//      
//      cafe.addToItemList(c1);
//      cafe.addToItemList(c2);
//      cafe.addToItemList(c3);
//   
//      int option;
//      //file
//      File f=new File("Menu.ser");
//      FileOutputStream fos=new FileOutputStream(f);
//      ObjectOutputStream oos=new ObjectOutputStream(fos);
//
//
//     Item [] menu=cafe.itemL();
//     
//      for(int i=0;i<menu.length;i++){
//               oos.writeObject(menu[i]);
//           
//               }
//
//;
//      do {
//         
//         System.out.println("*** Actions ***");
//         System.out.println("    1- Add Item to the menu");
//         // System.out.println("    2- Remove Item from the menu");
//         System.out.println("    2- Take Customer Order");
//         System.out.println("    3- Display Inventory");
//         System.out.println("    4- Update Inventory");
//         System.out.println("    5- Exit System");
//         System.out.println("Enter the number of your action: ");
//         option = in.nextInt();
//         
//         switch (option){
//            case 1:
//            
//               System.out.println("Enter 'Sweet' or 'Coffee' :");
//               char type = in.next().charAt(0);
//            
//               switch (type){
//                  case 'S':
//                  case 's':
//                     in.nextLine();
//                     System.out.println("Enter item name:");
//                     String sName = in.nextLine();
//                     int sExist = cafe.searchItemList(sName);
//                     double sPrice = 0;
//                     if (sExist == -1){
//                     
//                     boolean enter=true;
//                      Item s;
//                      
//                      while(enter){
//                      try{
//                        System.out.println("Enter item's base price:");
//                        sPrice = in.nextDouble();
//                        if(sPrice<=0){
//                        throw new NegativePriceEx();
//                        }
//                        enter=false;
//                        s = new Sweets(sName, sPrice);
//                      
//                        if (cafe.addToItemList(s)){
//                           System.out.println("Item successfully added.");
//                           oos.writeObject(s);
//                         
//
//                        }
//                        else{
//                           System.out.println("Item cannot be added.");
//                           
//                        }
//
//                        }//unchecked exceptin 
//                        catch (InputMismatchException m){
//                        String str=in.next();
//                        System.out.println("invalid input try again");
//                       }//user define exceptin 
//                       catch(NegativePriceEx N){
//                       System.out.println(N.getMessage());
//                       }
//                        }
//                                             }
//                     else{
//                        System.out.println("The item already exists.");
//                     }
//                     break;
//                  case 'C':
//                  case 'c':
//                     in.nextLine();
//                     System.out.println("Enter item name:");
//                     String cName = in.nextLine();
//                     int cExist = cafe.searchItemList(cName);
//                     double cPrice = 0;
//                     if (cExist == -1){
//                        System.out.println("Enter item's base price:");
//                        cPrice = in.nextDouble();
//                        Item c = new Coffee(cName, cPrice);
//                        if (cafe.addToItemList(c)){
//                           System.out.println("Item successfully added.");
//                           oos.writeObject(c);
//                        
//                        }
//                        else{
//                           System.out.println("Item cannot be added.");
//                        }
//                     }
//                     else{
//                        System.out.println("The item already exists.");
//                     }
//                     break;
//               }
//                           
//          
//                             
//               break;
//            /*case 2:
//               in.nextLine();
//               System.out.println("Enter the name of the item you want to remove:");
//               String remove = in.nextLine();
//               if(cafe.removeFromItemList(remove))
//                  System.out.println("Item removed successfully.");
//               
//     
//      
//               else
//                  System.out.println("Item does not exist, try again.");
//               break;*/
//               
//            case 2:
//            
//               System.out.println("***MENU***");
//      
//               try{ 
//               ObjectInputStream ois= new ObjectInputStream(new FileInputStream(new File("Menu.ser")));
//               Item c;
//               for(int i=0;i<menu.length;i++){
//               c=(Item)ois.readObject();
//               System.out.println(c);
//               }
//               
//               }//uchecked exceptin 
//               catch(ClassNotFoundException y){
//               System.out.println("error");
//               }
//               catch(IOException l){
//               
//               }
//               
//              
//               System.out.println("Enter customer's name:");
//               String customerN = in.next();
//               System.out.println("Enter customer's phone number:");
//               String pNum = in.next();
//               System.out.println("Enter the number of items the customer wants to buy:");
//               int numItems = in.nextInt();
//               Order o = new Order(customerN, pNum, numItems);
//               boolean correctType = true;
//               for (int i=0; i<numItems; i++){
//                  System.out.println("Enter 'S' for sweets and 'C' for coffee:");
//                  char itemType = in.next().charAt(0);
//                  String itemName;
//                  int loc = 0;
//                  double p=0;
//                  int q =0;
//                  switch (itemType){
//                     case 's':
//                     case 'S':
//                        do{
//                           System.out.println("Enter item name:");
//                           itemName = in.next();
//                           loc = cafe.searchItemList(itemName);
//                           in.nextLine();
//                           if(cafe.itemList[loc] instanceof Sweets){
//                              System.out.println("Enter flavor:");
//                              String flav = in.next();
//                              in.nextLine();
//                              System.out.println("Enter 'true' if with ice cream or 'false if without:");
//                              boolean ic = in.nextBoolean();
//                              in.nextLine();
//                              System.out.println("Enter quantity:");
//                              int sQuantity = in.nextInt();
//                              p = cafe.itemList[loc].getP();
//                              q = cafe.itemList[loc].getQ(); //i
//                              Item sweet = new Sweets(itemName, p, flav, ic, sQuantity, cafe.itemList[loc]);
//                              if (sQuantity <= q){
//                                 o.addItem(sweet);
//                                 // updates the quantity of the original item according to the number ordered by the customer
//                                 cafe.itemList[loc].updateQuantity(sQuantity);
//                                 correctType = true;
//                                 break;
//                              }
//                              else{
//                                 System.out.println("Only " + q + " left of this item. Try again.");
//                                 correctType = false;
//                              }
//
//                           }
//                           else
//                              System.out.println("This item is not of type Sweet, try again.");
//                              correctType = false;
//                        } while(!correctType);
//                        break;
//                        
//                     case 'c':
//                     case 'C':
//                        do {
//                           System.out.println("Enter item name:");
//                           itemName = in.next();
//                           loc = cafe.searchItemList(itemName);
//                           in.nextLine();
//                           if (cafe.itemList[loc] instanceof Coffee){
//                              System.out.println("Enter number of shots:");
//                              int shots = in.nextInt();
//                              in.nextLine();
//                              System.out.println("Enter 'S' for small, 'M' for medium, or 'L' for large:");
//                              char s = in.next().charAt(0);
//                              in.nextLine();
//                              System.out.println("Enter quantity:");
//                              int cQuantity = in.nextInt();
//                              p = cafe.itemList[loc].getP();
//                              q = cafe.itemList[loc].getQ();
//                              Item coffee = new Coffee(itemName, p, shots, s, cQuantity, cafe.itemList[loc]);
//                              if (cQuantity <= q){
//                                 o.addItem(coffee);
//                                 // updates the quantity of the original item according to the number ordered by the customer                           }
//                                 cafe.itemList[loc].updateQuantity(cQuantity);
//                                 correctType = true;
//                                 break;
//                              }
//                              else{
//                                 System.out.println("Only " + q + " left of this item. Try again.");
//                                 correctType = false;
//                              }
//                           }
//                           else
//                              System.out.println("This item is not of type coffee, try again.");
//                              correctType = false;
//                        } while(!correctType);
//                        break;
//                  }
//               }
//               o.displayOrder();
//               break;
//               
//            case 3:
//               cafe.displayItemList();
//               break;
//               
//            case 4:
//               System.out.println("Enter item name:");
//               String iName = in.next();
//               int i = cafe.searchItemList(iName);
//               System.out.println("Enter the amount of item you want to add:");
//               int amount = in.nextInt();
//               cafe.itemList[i].restock(amount);
//               break;
//            case 5:
//               option = 5;
//               break;
//            default:
//               System.out.println("Action not found.");
//               break; 
//         }
//      } while(option !=5); //!=6
//   }
}
