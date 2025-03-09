import java.util.ArrayList;
public class Train {

    //Attributes
    private ArrayList<Car> cars;
    private Engine engine;
    private int passengerCapacity;
    private String trainsName;
    private int nCars;


    /**
     * Constructor for Train Class
     * @param fuelType Train's engine's fuel type
     * @param fuelCapacity Train's engine's fuel capacity
     * @param nCars Train's number of cars
     * @param passengerCapacity the amount of passengers each car can hold
     * @param trainsName the name of the train
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity, String trainsName){
        this.engine = new Engine(fuelType,0,fuelCapacity); 
        this.cars = new ArrayList<Car>();
        this.trainsName = trainsName;
        this.passengerCapacity = passengerCapacity;
        this.nCars = nCars;
        for (int i = 0; i <nCars; i++){
            Car newCar = new Car(passengerCapacity);
            cars.add(newCar);

        }


    }

    /**
     * Accessor for information about the Train's engine
     * @return engine information about the engine's fuel type, current fuel level, and max fuel level
     */
    public Engine getEngine(){
        return this.engine;
    }

   /**
    * Accessor for a Train car at a specific index
    * @param i index of the Car that wants to be accessed
    * @return the car located at index i
    */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /**
     * Accessor for the total amount of passengers a train can hold
     * multiplies the amount of cars by the capacity of each
     * @return Maximum capacity
     */
    public int getMaxCapacity(){
        return cars.size() * passengerCapacity;

    }
    /**
     * Accessor for the total seats left
     * adds the empty seats from each car in the Train
     * @return seatsRemaining how many open seats
     */
    public int seatsRemaining(){
        int seatsRemaining = 0;
        for (int i = 0; i < cars.size();i++){
            seatsRemaining = seatsRemaining+ cars.get(i).getseatsRemaining();
        }
        return seatsRemaining;
    }

    /**
     * Prints the Manifest of the entire train by printing out the manifest for each car
     */
    public void printManifest(){
        System.out.println(this.trainsName +"'s Manifest");
        System.out.println("----------------------------");
        for (int i = 0; i < cars.size();i++){
            System.out.println("Car " + (i+1) +":");
            cars.get(i).printManifest();
        }
    }

    public int getCarNumber(){
        return this.nCars;
    }

    public ArrayList<Car> getCarsList(){
        return this.cars;
    }

    public static void main(String[] args) {
        Train amtrak = new Train(FuelType.ELECTRIC,200,5,4,"Amtrak Valley Flier");
        System.out.println(amtrak.getEngine());
        Car cartwo = amtrak.getCar(1);
            Passenger Sofia = new Passenger("Sofia");
            cartwo.addPassenger(Sofia);
            Passenger Maya = new Passenger("Maya");
            cartwo.addPassenger(Maya);

            Passenger Walter = new Passenger("Walter");
            cartwo.addPassenger(Walter);

            Passenger Susan = new Passenger("Susan");
            cartwo.addPassenger(Susan);

        Car carOne = amtrak.getCar(0);

            Passenger Kate = new Passenger("Kate");
            carOne.addPassenger(Kate);

            Passenger Cleo = new Passenger("Cleo");
            carOne.addPassenger(Cleo);

        Car carFive = amtrak.getCar(4);

            Passenger Lucy = new Passenger("Lucy");
            carFive.addPassenger(Lucy);

            Passenger Annika = new Passenger("Annika");
            carFive.addPassenger(Annika);

            Passenger Catherine = new Passenger("Catherine");
            carFive.addPassenger(Catherine);


        System.out.println("seats remaining: "+amtrak.seatsRemaining());
        System.out.println("max capacity: "+amtrak.getMaxCapacity());
        amtrak.printManifest();
    }


}
