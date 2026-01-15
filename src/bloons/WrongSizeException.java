package bloons;

/** the WrongSizeException object is triggered when the height or width is negative. */
public class WrongSizeException extends Exception{
   /** the constructor of the class WrongSizeException */
   public WrongSizeException(String msg){
      super(msg);
   }   
}