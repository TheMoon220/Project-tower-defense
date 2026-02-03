package bloons;

public class Livrable2a {
    
     public static void main(String[] args){

        if(args.length != 3){
            System.out.println("Exactement trois parametres sont recquis en ligne de commande");
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
            System.out.println("Les parametres doivent etre des entiers");
            return;
        }

        System.out.println("=== Livrable 2a: Classical Board ===");
        System.out.println("Board size: " + width + "x" + height);
        System.out.println("Nombre de ballons " + nbBalloons);
        System.out.println();
     }
}
