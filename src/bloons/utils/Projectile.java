package bloons.utils;

public enum  Projectile{
    FLECHETTE(1) ,
    FLECHETTEPOINTUE(2),
    FLECHETTETRESPOINTUE(4),
    AIGUILLE(1) ,
    BOMBE(2),
    EXTRABOMBE(2);

    private int niveauDegat;
     
    private Projectile(int niveauDegat){
        this.niveauDegat= niveauDegat;
    }

    public int getNiveauDegat(){
        return this.niveauDegat;
    }
}




