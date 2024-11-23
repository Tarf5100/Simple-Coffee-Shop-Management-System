
import java.io.*;
public abstract class Item implements Serializable{
    protected String name; 
   // quantity of item is always initially 10 [inventory]
   protected int quantity = 10;
   protected double price;
   
   // constructor
   Item(String n, double p){
      name = n; 
      price = p;
   }
   
   public abstract double calcPrice(Item it);
   
   
   @Override
   public String toString() {
      return "Item Information:-\nName : " + name + "\nPrice: " + price + "\nQuantity: " + quantity;
   }
   
   // displays the customers item
   public void displayCItem(){
      System.out.println("\nName: " + name + "\nPrice: " + price);
   }
   
   // updates the quantity of the original item 
   public void updateQuantity(int i){
      quantity -= i;
   }
   
   // restock quantity of the original item
   public void restock(int i){
      quantity += i;
   }
   
   public int getQ(){
      return quantity;
   }
   
   public double getP(){
      return price;
   }
   
   public String getN(){
      return name;
   }
}
