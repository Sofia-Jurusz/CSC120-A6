public class Passenger {
    
    private String name;

    /**
     * constructor for passenger
     * @param name passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * accessor for the passenger's name
     * @return passenger's name
     */ 
    public String getName(){
        return this.name;
    }

    /**
     * Lets a passenger board a Car c
     * calls on the addPassenger method from Car class
     * @param c Car
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            System.out.println(this.name + " has succesfully boarded!");
        }
        return;
    }

   /**
    * Lets passenger leave a Car c
    * calls on removePassenger method from Car class
    * @param c Car
    */
    public void getOffCar(Car c) {
        if (c.removePassenger(this)){
            System.out.println(this.name + " has succesfully left!");
        }
    }

    public static void main(String[] args) {
        Car carOne = new Car(10);
        Passenger Walter = new Passenger("Walter");
        Walter.boardCar(carOne);
        carOne.printManifest();
        Walter.getOffCar(carOne);
        carOne.printManifest();
        Walter.getOffCar(carOne);
    }
}
