import java.util.ArrayList;
public class Car {
    //Attributes
    private int capacity;
    private int seatsRemaining;
    private ArrayList<Passenger> Manifest;  
    
    /**
     * Constructor for Car
     * @param capacity Car's total seats 
     */
    public Car(int capacity){ //, ArrayList<String> Manifest
        this.capacity = capacity;
        this.Manifest = new ArrayList<Passenger>(capacity);
        this.seatsRemaining = capacity;
        

    }
    /**
     * Accessor for a given Car's capacity
     * @return capacity how many Passengers the car can hold
     */
    public int getCapacity(){
        return this.capacity;

    }
    /**
     * Accessor for the passengers on a singular car
     * @return arraylist of the passengers on the car
     */
    public ArrayList<Passenger> getManifest(){
        return this.Manifest;
    }
    /**
     * Accessor for the Car's seats remaining
     * @return seatsRemaining The spaces a Passenger could still occupy
     */
    public int getseatsRemaining(){
        return this.seatsRemaining;
    }
    /**
     * Adds a passenger to the car if there is room
     * and they are not already on the car
     * @param p the Passenger that wants to be added
     * @return True if the addition was succesful
     * @return False if the addition was unsuccesful
     */
    public Boolean addPassenger(Passenger p){
        int Manifest_size = this.Manifest.size();
        if (Manifest_size == this.capacity) {
            System.out.println("This car is full!");
            return false;
        }
        else {
            for (int i = 0; i < Manifest_size; i++) {
                if (p == this.Manifest.get(i)){
                    System.out.println(p.getName() + " is already on this car!");
                    return false;
                }   

            }
            this.Manifest.add(p);
            this.seatsRemaining = this.seatsRemaining - 1;
            return true;
         }
    }

    /**
     * Removes a Passenger from a car
     * if they are already on the car
     * @param p the Passenger that wants to be removed
     * @return True if the removing was succesful
     * @return False if the removing was unsuccesful
     */
    public Boolean removePassenger(Passenger p){
        int Manifest_size = this.Manifest.size();
        if (Manifest_size == 0) {
            System.out.println("This car is empty! There is no one to remove!");
            return false;
        }
        else {
            for (int i = 0; i < Manifest_size; i++) {
                if (p == this.Manifest.get(i)){
                    this.Manifest.remove(p);
                    this.seatsRemaining = this.seatsRemaining + 1;
                    return true;
                }   

            }
            System.out.println(p.getName()+ " is not on this car!");
            return false;
            
         }
    

    }
    /**
     * prints the manifest of the car, 
     * which contains a list of Passengers on board
     */
    public void printManifest(){
        if (this.Manifest.size() == 0){
            System.out.println("This car is empty!");
            return;
        }
        System.out.println("****");
        for (int i = 0; i < this.Manifest.size(); i++){
            Passenger passenger = this.Manifest.get(i);
            String name = passenger.getName();
            System.out.println(name);
        }
        System.out.println("****");
    }

    public static void main(String[] args) {
        Car myCar = new Car(10);
        Passenger Sofia = new Passenger("Sofia");
        System.out.println("This is an empty car");
        System.out.println("Capacity: "+ myCar.getCapacity());
        System.out.println("Seats Remaining: " + myCar.getseatsRemaining());
        myCar.printManifest();

        System.out.println("Now we are adding a passenger: "+ Sofia.getName());
        myCar.addPassenger(Sofia);
        System.out.println("Capacity: "+ myCar.getCapacity());
        System.out.println("Seats Remaining: " + myCar.getseatsRemaining());
        myCar.printManifest();

        Passenger Cleo = new Passenger("Cleo");
        System.out.println("Now we are adding a passenger: "+ Cleo.getName());
        myCar.addPassenger(Cleo);
        System.out.println("Capacity: "+ myCar.getCapacity());
        System.out.println("Seats Remaining: " + myCar.getseatsRemaining());
        myCar.printManifest();

        System.out.println("Sofia is going to leave the train");
        myCar.removePassenger(Sofia);
        System.out.println("Capacity: "+ myCar.getCapacity());
        System.out.println("Seats Remaining: " + myCar.getseatsRemaining());
        myCar.printManifest();

        Passenger Maya = new Passenger("Maya");
        System.out.println("Maya is going to leave the train");
        System.out.println(myCar.removePassenger(Maya));

        System.out.println("Cleo is getting on the train");
        System.out.println(myCar.addPassenger(Cleo));

        
    }

}