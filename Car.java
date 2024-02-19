import java.util.ArrayList;

public class Car {

    //attributes
    private ArrayList<Passenger> passengerList;
    private int maxCap;

    //constructor
    public Car(int maxCap){
        this.maxCap = maxCap;
        this.passengerList = new ArrayList<Passenger>(maxCap);

    }

    //methods
    public boolean addPassenger(Passenger p){
        if (this.passengerList.size() < maxCap){
            this.passengerList.add(p);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean removePassenger(Passenger p){
        if(this.passengerList.contains(p)){
            this.passengerList.remove(p);
            return true;
        } else {
            return false;
        }
    }

    public void printManifest(){
        int count = 0;
        if (this.passengerList.size() > 0){
            System.out.println("Manifest:");
            for (Passenger passenger: this.passengerList){
                count += 1;
                System.out.println(count + ". " + passenger.getName());
            }
        } else {
            System.out.println("This car is EMPTY.");
        }
    }

    //accessors & manipulators
    public int getCapacity(){
        return this.maxCap;
    }

    public int seatsRemaining(){
        return this.maxCap - this.passengerList.size();
    }

    public static void main(String[] args) {
        Car carA = new Car(5);
        System.out.println(carA.getCapacity());
        System.out.println(carA.seatsRemaining());
        Passenger pass1 = new Passenger("Zoe");
        carA.addPassenger(pass1);
        if (carA.addPassenger(pass1) == true){
            System.out.println("complete");
        }
        carA.printManifest();
        carA.removePassenger(pass1);
        if (carA.removePassenger(pass1) == true){
            System.out.println("complete");
        }
        carA.printManifest();
    }
}

