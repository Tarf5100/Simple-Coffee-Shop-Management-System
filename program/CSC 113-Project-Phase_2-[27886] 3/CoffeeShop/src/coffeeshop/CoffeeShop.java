
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CoffeeShop{
   private String name;
   // list of all the items in the coffee shop [menu]
   Item itemList[];
   // acts as a counter for the number of items available 
   private int numOfItems;
      
   //constructor 
   CoffeeShop(String n, int itemSize, int ordersSize) {
      name = n;
      itemList = new Item[itemSize];
      numOfItems = 0;
   }
   
   // adds item to itemList
   public boolean addToItemList(Item it) {
      if (numOfItems < itemList.length) {
         itemList[numOfItems++] = it;
         return true;
      }
      return false;
   }
   
   
   // searches for an item and returns its index in itemList 
   public int searchItemList(String name) {
      for (int i = 0; i < itemList.length; i++){
         if (itemList[i] != null && itemList[i].getN().equalsIgnoreCase(name))
            return i;
      }
      return -1;
   }
  
   
   // displays inventory
   public void displayItemList() {
      if (numOfItems > 0) {
         System.out.println("Items available in the shop :\n");
         for (int i = 0; i < numOfItems; i++) {
            if (itemList[i] != null)
               System.out.println(" " + (i + 1) + ") " + itemList[i] + "\n");
         }
      }
   }
   
   public void displayItemsInGUI(JPanel panel) {
       String htmlContent = "<html>";
       if (numOfItems > 0) {
         for (int i = 0; i < numOfItems; i++) {
            if (itemList[i] != null) {
                htmlContent += itemList[i].getN()+ "  -  " + "$" + itemList[i].getP() + "  -  " + itemList[i].getQ() + " left"+ "<br />";
            }
         }
      }
      htmlContent += "</html>";
      JLabel label = new JLabel(htmlContent);
      panel.add(label);
   }
   
   public Item[] itemL(){
   Item []array=new Item[numOfItems];
   int j=0;
   for(int i=0;i<itemList.length;i++){ 
   if(itemList[i]!=null)
   array[j++]=itemList[i];
   }
   return array;
   }
}
