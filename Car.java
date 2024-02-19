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
        if (this.passengerList.size() > 0){
            System.out.println(this.passengerList);
            // for (Passenger passenger: this.passengerList){
            //     System.out.println(passenger);
            // }
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
        Car mycar = new Car(5);
        System.out.println(mycar.getCapacity());
        System.out.println(mycar.seatsRemaining());
        Passenger pass1 = new Passenger("Zoe");
        mycar.addPassenger(pass1);
        if (mycar.addPassenger(pass1) == true){
            System.out.println("complete");
        }
        mycar.printManifest();
        mycar.removePassenger(pass1);
        if (mycar.removePassenger(pass1) == true){
            System.out.println("complete");
        }
        mycar.printManifest();
    }
}

