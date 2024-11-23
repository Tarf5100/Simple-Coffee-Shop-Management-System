public class NegativePriceEx extends Exception{
 
 public NegativePriceEx()
 {
 super("cannot have a price less than 0");
 }

}
