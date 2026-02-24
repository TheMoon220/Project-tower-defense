package bloons.main;

public class Livrable3b {
    
    public static void main(String[] args){
        
        if(args.length != 3){
            System.out.println("Exactly tree arguments are required");
            return;
        }

        try{

            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);
            int numPaths = Integer.parseInt(args[2]);
        } catch(NumberFormatException e){
            System.out.println("Les arguments doivent etre des entiers");
            return;
        }
    }
}
