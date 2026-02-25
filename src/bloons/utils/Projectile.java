package bloons.utils;

/** an object Projectile an enumeration */
public enum  Projectile{
    /**  the dart */
    DART(1) ,
    /** thepointDart */
    POINTEDDART(2),
    /** thesharpDart */
    VERYSHARPDART(4),
    /** the needle */
    NEEDLE(1) ,
    /** the bomb */
    BOMB(2),
    /** //extrabomb */
    EXTRABOMB(2);
    /** the level of degat */
    private int niveauDegat;
    
    /**
     * the consturctor
     * @param niveauDegat
     */
    private Projectile(int niveauDegat){
        this.niveauDegat= niveauDegat;
    }
    /**
     * return the levelofdegat of the projectile
     * @return th level of degat
     */
    public int getNiveauDegat(){
        return this.niveauDegat;
    }
    /**
     * change the level of degat 
     * @param newNiveauDegat the new level of degat
     */
    public void setNiveauDegat(int newNiveauDegat){
        this.niveauDegat= newNiveauDegat;
    }
}




