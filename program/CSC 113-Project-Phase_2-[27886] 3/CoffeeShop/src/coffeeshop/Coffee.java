
public class Coffee extends Item{
   private int numOfShots; 
   private char size;
   // amount ordered by the customer 
   private int cCoffeeQ;
   
   // constructor to initialize the item in inventory
  Coffee(String name, double price) {
      super(name, price);
  }
  
  // constructor to initialize the item specific to the customer 
  // price from original item added as parameter 
  Coffee (String name, double price, int numberOfShots, char size, int cQuantity, Item c){
      super(name,price);
      this.numOfShots = numberOfShots;
      this.size = size;
      cCoffeeQ = cQuantity;
      price = calcPrice(c);
  }
  
  // item that checks for the availability of the item in the inventory
  // the parameter Item c is the original item found in the inventory 
   public boolean checkQ(Item c) {
      if (c.quantity >= cCoffeeQ) {
         return true;
      } else
         System.out.println("We are out of stock!");
      return false;
   }
   
   // check availability of the item then calculates the price 
   public double calcPrice(Item c){
      if (checkQ(c)){
        switch (size){
            case 's':
            case 'S':
               price += 10*cCoffeeQ;
               break;
            case 'm':
            case 'M':
               price += 12*cCoffeeQ;
               break;
            case 'l':
            case 'L':
               price += 15*cCoffeeQ;
               break;
        }
      }
      else{
         return 0;
      }
      if (numOfShots>1){
        // extra 5 for every shot
            price += numOfShots*5;
      }
      return price; 
   }
   
   // displays the specific information of the customer's item 
   public void displayCItem(){
      super.displayCItem();
      System.out.println("Size: " + size + "\nShots: " + numOfShots + "\nAmount: " + cCoffeeQ);
   }

}

