
public class Sweets extends Item{ 
  private String flavor; 
   private boolean withIceCream;
   // amount of sweet ordered by the customer 
   private int cSweetsQ;
   
   // constructor for general sweet
   Sweets(String name, double price) {
      super(name,price);
   }
   
   // constructor to initialize the item specific to the customer 
   // price from original item added as parameter
   Sweets(String n, double p, String flavor, boolean withIC, int sQuantity, Item s){
      super(n,p);
      this.flavor = flavor;
      withIceCream = withIC;
      cSweetsQ = sQuantity;
      price = calcPrice(s);
   }
   
   // item that checks for the availability of the item in the inventory
   // the parameter Item c is the original item found in the inventory
   public boolean checkQ(Item s) {
      if (s.quantity >= cSweetsQ) {
         return true;
      } else
         System.out.println("We are out of Stock!");
      return false;
   }
   
   // check availability of the item then calculates the price
   public double calcPrice(Item s){
      if (checkQ(s)){
         if (withIceCream){
            price += 10*cSweetsQ;
            return price;
         }
         else{
            return price*cSweetsQ;
         }
      }
      return 0;  
   }
   
   // displays the specific information of the customer's item 
   public void displaySItem(){
      super.displayCItem();
      System.out.println("Flavor: " + flavor + "\nWith Ice Cream: " + withIceCream + "\nAmount: " + cSweetsQ);
   }

}
