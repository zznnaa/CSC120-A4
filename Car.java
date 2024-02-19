import java.util.ArrayList;

public class Car {

    //attributes
    ArrayList<String> arrayList;
    int maxCap;

    //constructor
    public Car(int maxCap){
        this.maxCap = maxCap;
        this.arrayList = new ArrayList<String>(maxCap);

    }

    //methods

    

    //accessors & manipulators


    public static void main(String[] args) {
        Car mycar = new Car(5);
        System.out.println(mycar.arrayList);
    }
}

// - accessor-like methods `public int getCapacity()` and `public int seatsRemaining()` that return the maximum capacity and remaining seats, respectively
// - `addPassenger(Passenger p)` and `removePassenger(Passenger p)` methods to add or remove a `Passenger` from the `Car` and return `True` if the operation was successful, and `False` otherwise. (_Hint: don't forget to check that there are seats available if someone wants to board, and to confirm that the `Passenger` is actually onboard before trying to remove them! If you encounter a problem, you should `return False`._)
// - and a final method `printManifest()` that prints out a list of all `Passenger`s aboard the car (or "This car is EMPTY." if there is no one on board).