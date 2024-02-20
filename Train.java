import java.util.ArrayList;

public class Train {

    //attributes
    Engine engine;
    ArrayList<Car> carList;

    //constructor
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        int count = 0;
        this.engine = new Engine(fuelType, fuelCapacity);
        this.carList = new ArrayList<Car>(nCars);
        for (int i = 0; i <= nCars; i++){
            count += 1;
            Car tempCar = new Car(passengerCapacity);
            String newName = "Car" + String.valueOf(count);
            tempCar.assignName(newName);
            this.carList.add(tempCar);
        }
        
    }

    //methods


    //setters and getters


    public static void main(String[] args) {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 3, 5);
        for (Car car:train.carList){
            System.out.println(car.getName());
        }
    }
}

//  -  an `Engine`
//  -  an `ArrayList` to keep track of the `Car`s currently attached
//  -  a constructor `Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity)` which will initialize the `Engine` and `Car`s and store them
//  -  a few accessors: 
//      -  `public Engine getEngine()`
//      -  `public Car getCar(int i)` to return the `i`th car
//      -  `public int getMaxCapacity()` which will return the maximum total capacity across all `Car`s
//      -  `public int seatsRemaining()` which will return the number of remaining open seats across all `Car`s
// - and finally, its own `printManifest()` that prints a roster of all `Passenger`s onboard (_Hint: ask your `Car`s to help!_)