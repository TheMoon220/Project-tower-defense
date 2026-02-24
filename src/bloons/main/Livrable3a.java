package bloons.main;

public class Livrable3a {
    public static void main(String[] args){

        if(args.length != 3){
            System.out.println("Exactly tree arguments are required");
            return;
        }

        int width;
        int height;
        int nbBalloons;
        try{
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
            nbBalloons = Integer.parseInt(args[2]);
        } catch(NumberFormatException e){
            System.out.println("Les arguments doivent etre des entiers");
            return;
        }
    }
}
