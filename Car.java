import java.util.ArrayList;

public class Car {

    //attributes
    ArrayList < Passenger > passengerList;
    private int maxCap;
    private String name;

    //constructor
    public Car(int maxCap) {
        this.maxCap = maxCap;
        this.passengerList = new ArrayList < Passenger > (maxCap);
        this.name = "UnassignedCar";

    }

    //methods

    /**
     * Adds a passenger to the car.
     * @param p The passenger you want to add.
     * @return T/F if the passenger was successfully added to the car.
     */
    public boolean addPassenger(Passenger p) {
        //check whether enough seats left on board
        if (this.passengerList.size() < maxCap) {
            //add passenger
            this.passengerList.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a passenger from the car.
     * @param p The passenger you want to remove.
     * @return T/F whether the passenger was successfully removed.
     */
    public boolean removePassenger(Passenger p) {
        //check if passenger list of car contains p
        if (this.passengerList.contains(p)) {
            //remove p
            this.passengerList.remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints the manifest of everyone on board the car.
     */
    public void printManifest() {
        int count = 0;
        //checks if car any passengers on board
        if (this.passengerList.size() > 0) {
            System.out.println("\tPassengers:");
            //iterates through passenger list
            for (Passenger passenger: this.passengerList) {
                //lists names of passengers in numbered list
                count += 1;
                System.out.println("\t" + count + ". " + passenger.getName());
            }
        } else {
            System.out.println("\t" + "This car is EMPTY.");
        }
    }

    //accessors & manipulators
    public int getCapacity() {
        return this.maxCap;
    }

    public int seatsRemaining() {
        return this.maxCap - this.passengerList.size();
    }

    public String getName() {
        return this.name;
    }

    public void assignName(String newName) {
        this.name = newName;
    }

    public static void main(String[] args) {
        Car carA = new Car(5);
        System.out.println(carA.getCapacity());
        System.out.println(carA.seatsRemaining());
        Passenger pass1 = new Passenger("Zoe");
        carA.addPassenger(pass1);
        if (carA.addPassenger(pass1) == true) {
            System.out.println("complete");
        }
        carA.printManifest();
        carA.removePassenger(pass1);
        if (carA.removePassenger(pass1) == true) {
            System.out.println("complete");
        }
        carA.printManifest();
    }
}

