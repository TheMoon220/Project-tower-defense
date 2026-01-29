package bloons.utils;

public enum Level {
    NIV1(1), 
    NIV2(2), 
    NIV4(3);
    

    private final int resistance ;

    private Level(int resistance){
        this.resistance= resistance;
    }
    public int getResistance(){
        return resistance;
    }
}
