public class Order{
   // customer name
   private String name;
   // customer phone number
   private String phone;
   // number of items added to the order
   private int numOfItems;
   // array of items 
   Item cItems[];
   // unique order id 
   private int orderID;
   
   Order(String n, String p, int num){
      name = n; 
      phone = p;
      cItems = new Item[num];
      orderID = (int)(Math.random() * 1000);
   }
   
   // add item to order
   public boolean addItem(Item it) {
      if (numOfItems < cItems.length) {
         if (it.getQ()>0) {
            cItems[numOfItems++] = it;
            return true;
         } else{
            System.out.println("This item is out of stock!");
            return false;
         }
      }
      System.out.println("You have reached the maximum number of the requested orders!");
      return false;
   }
   
   // calculates the total price of the order 
   public double calcTotalPrice(){
      double total = 0;
      for (int i=0; i<numOfItems; i++){
         if (cItems[i] instanceof Sweets){
            total += ((Sweets)cItems[i]).getP();
         }
         else{
            total += ((Coffee)cItems[i]).getP();
         }
      }
      return total;
   }
   
   // prints our receipt
   public void displayOrder(){
      System.out.println("\n***Order " + orderID + " Receipt***");
      for (int i=0; i<cItems.length; i++){
         if( cItems[i] instanceof Sweets){
            ((Sweets)cItems[i]).displaySItem();
         }
         else{
            ((Coffee)cItems[i]).displayCItem();
         }
      }
   }

}
