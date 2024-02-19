import java.util.ArrayList;

public class Car {

    //attributes
    ArrayList<Passenger> passengerList;
    int maxCap;

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
            // for (i=0, this.passengerList < i, i++){
            //     System.out.println(this.passengerList);
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
        System.out.println(mycar.passengerList);
    }
}


//what attributes need to be private or public