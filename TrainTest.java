import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TrainTest {

    // @BeforeClass
    //     public void newTrain(){
            
    //     }
    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 4, "amtrack valley flier");
        if (amtrak.getEngine().getFuelType() == FuelType.ELECTRIC){
            assertTrue(amtrak.getEngine().getMaxFuel() == 100);
        } else{
            fail();
        }
        
        //does engine initialize correctly with fuel type and capacity?
    }

    @Test
    public void testEngineGo() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 4, "amtrack valley flier");
        amtrak.getEngine().refuel();
        amtrak.getEngine().go();
        assertTrue(amtrak.getEngine().getMaxFuel() >= amtrak.getEngine().getCurrentFuel());
        //does go subtract fuel?
    }

    // Car Tests
    /**
     * Test if add passenger increase passenger count
     * If there are less seats remaining after a passenger is added, the test passes
     */
    @Test
    public void testCarAddPassenger() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 4, "amtrack valley flier");
        Car carone = amtrak.getCar(0);
        int zero_passengers = carone.getseatsRemaining();
        Passenger Maya = new Passenger("Maya");
        carone.addPassenger(Maya);
        assertTrue(carone.getseatsRemaining()<= zero_passengers);

    }
    /**
     * Tests if remove passenger decreases the passenger count
     * If there are more seats remaining after a passenger is removed, the test passes
     * If the car removes a passenger when they are not on the car, the test fails. 
     */
    @Test
    public void testCarRemovePassenger() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 4, "amtrack valley flier");
        Car carone = amtrak.getCar(0);
        Passenger Maya = new Passenger("Maya");
        carone.addPassenger(Maya);
        int one_pass = carone.getseatsRemaining();
        carone.removePassenger(Maya);
        if (one_pass <= carone.getseatsRemaining()){
            assertFalse(carone.removePassenger(Maya));
        } else{
            fail();
        }
    }

    

    // Passenger Tests
    /**
     * Tests if a Passenger can successfully board an empty car
     * If they board the car, it passes the test
     */
    @Test
    public void testPassengerBoardCarWithSpace() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 4, "amtrack valley flier");
        Car carone = amtrak.getCar(0);
        Passenger Maya = new Passenger("Maya");
        Maya.boardCar(carone);
        int Manifest_size = carone.getManifest().size();
        for (int i = 0; i < Manifest_size; i++)
            if (carone.getManifest().get(i)== Maya) {
                assertTrue(true);
            }else {
                fail();
            }
        
        //can passenger board car with room? 
    }

    /**
     * Tests if passenger can board a full car
     * If they are rejected from a full car, the test passes
     */
    @Test
    public void testPassengerBoardCarFull() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 1, "amtrack valley flier");
        Car carone = amtrak.getCar(0);
        Passenger Maya = new Passenger("Maya");
        Maya.boardCar(carone);
        Passenger Kate = new Passenger("Kate");
        assertFalse(carone.addPassenger(Kate));
        
        
    }

    // Train Tests

    /**
     * Tests if a train initializes with the correct number of cars. 
     * if the train has the correct number of cars, the test passes
     */
    @Test
    public void testTrainConstructor() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 1, "amtrack valley flier");
        assertTrue(amtrak.getCarNumber() == 5);
    }

    /**
     * Tests if the train reports the correct number of passengers
     * If the train reports the same number of passengers, it passes
     */
    @Test
    public void testTrainPassengerCount() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 1, "amtrack valley flier");
        Car carone = amtrak.getCar(0);
        Car cartwo = amtrak.getCar(1);

        Passenger Maya = new Passenger("Maya");
        Passenger Kate = new Passenger("Kate");
        Maya.boardCar(carone);
        Kate.boardCar(cartwo);
    
        if (amtrak.getMaxCapacity() - amtrak.seatsRemaining() == 2){
            Kate.getOffCar(cartwo);
            assertTrue(amtrak.getMaxCapacity() - amtrak.seatsRemaining() == 1);
        } else {
            fail();
        }

    }
    /**
     * test that the getCar method retreives the expected car
     * if different inputs for getCar retrieve the same car, then the test fails
     */
    @Test
    public void testTrainGetCar() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 1, "amtrack valley flier");
        assertFalse(amtrak.getCar(1) == amtrak.getCar(0));
        
    }

    /**
     * Tests if the get Manifest correctly interates through the cars
     * printManifest uses print manifest method from the car class to interate
     * if the correct car is acessed, then the test passes
     */
    @Test
    public void testTrainPrintManifest() {
        Train amtrak = new Train(FuelType.ELECTRIC, 100, 5, 1, "amtrack valley flier");
        Car carone = amtrak.getCar(0);
        Car cartwo = amtrak.getCar(1);

        Passenger Maya = new Passenger("Maya");
        Passenger Kate = new Passenger("Kate");
        Maya.boardCar(carone);
        Kate.boardCar(cartwo);

        if (amtrak.getCarsList().get(1) == cartwo){
            assertTrue(true);
        }else{
            fail();
        }
        
    }
    
}

