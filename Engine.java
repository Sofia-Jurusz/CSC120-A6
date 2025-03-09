public class Engine implements EngineRequirements{

    //Attributes
    private FuelType f;
    private double currentFuellevel;
    private double maxFuellevel;

    /**
     * Constructor for Engine
     * @param f Engine's fuel level
     * @param currentFuellevel Engine's current fuel level
     * @param maxFuellevel Engine's max fuel level
     */
    public Engine(FuelType f, double currentFuellevel, double maxFuellevel){
        this.f = f;
        this.currentFuellevel = currentFuellevel;
        this.maxFuellevel = maxFuellevel;

    }
    /**
     * Accessor for fuel type
     * @return f This engine's fuel type
     */
    public FuelType getFuelType() {
        return this.f;
    }

    /**
     * Accessor for max fuel level
     * @return maxFuellevel This engine's fuel level
     */
    public double getMaxFuel(){
        return this.maxFuellevel;
    }
    
    /**
     * Accessor for current fuel level
     * @return currentFuellevel This engine's current fuel level
     */
    public double getCurrentFuel(){
        return this.currentFuellevel;
    }

    /**
     * Refuels the car by updating it's current fuel to it's max fuel
     */
    public void refuel(){
        this.currentFuellevel = this.maxFuellevel;
        

    }

    /**
     * Subtracts one from the current fuel as
     * long as the tank is not empty
     * @return False if the removal was uncessesful
     * @return True if the removal was successful
     */
    public Boolean go(){
        if (this.currentFuellevel == 0) {
            System.out.println("Tank is empty! We need to refuel!");
            return false;
        }
        else {
            this.currentFuellevel = this.currentFuellevel - 1;
            System.out.println("Choo Choo!!");
            return true;
        }
        
    }

    public String toString(){
        return ("Fuel Type: "+ this.f + "; Current Fuel Level: "+ this.currentFuellevel+"; Max Fuel Level:" + this.maxFuellevel);
    }

    //Main for testing
    public static void main(String[] args) {
        System.out.println("welcome to my train");
        Engine myEngine = new Engine (FuelType.ELECTRIC, 0., 100.);
        // System.out.println(myEngine);
        
        System.out.println("Here is some information");
        System.out.println("Fuel type: " + myEngine.getFuelType());
        System.out.println("Max FUel: " + myEngine.getMaxFuel());
        System.out.println("Current Fuel: " + myEngine.getCurrentFuel());
        System.out.println("lets refuel");
        myEngine.refuel();
        System.out.println(myEngine.getMaxFuel());
        System.out.println(myEngine.getCurrentFuel());
        System.out.println("lets go somewhere");
        System.out.println(myEngine.go());
        System.out.println(myEngine.getCurrentFuel());

    }
}