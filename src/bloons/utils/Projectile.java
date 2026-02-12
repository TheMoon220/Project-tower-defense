package bloons.utils;

public enum  Projectile{

    DART(1) ,
    POINTEDDART(2),
    VERYSHARPDART(4),
    NEEDLE(1) ,
    BOMB(2),
    EXTRABOMB(2);

    private int niveauDegat;
     
    private Projectile(int niveauDegat){
        this.niveauDegat= niveauDegat;
    }

    public int getNiveauDegat(){
        return this.niveauDegat;
    }
}




