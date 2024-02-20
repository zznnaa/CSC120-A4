import java.util.ArrayList;

public class Train {

    //attributes
    private Engine engine;
    private ArrayList<Car> carList;

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
    public void printManifest(){
        System.out.println("Manifest:");
        for (Car car:carList){
            System.out.println(car.getName() + ":");
            car.printManifest();
        }
        System.out.println();
    }

    //getters
    public Engine getEngine(){
        return this.engine;
    }

    public Car getCar(int i){
        return this.carList.get(i);
    }

    public int getMaxCapacity(){
        int maxCap = 0;
        for (Car car:this.carList){
            maxCap += car.getCapacity();
        }
        return maxCap;
    }
    
    public int seatsRemaining(){
        int seatsLeft = 0;
        for (Car car:this.carList){
            seatsLeft += car.seatsRemaining();
        }
    return seatsLeft;
    }

    public static void main(String[] args) {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 3, 5);
        
        train.printManifest();
    }
}


//  -  a few accessors: 
//      -  `public Engine getEngine()`
//      -  `public Car getCar(int i)` to return the `i`th car
//      -  `public int getMaxCapacity()` which will return the maximum total capacity across all `Car`s
//      -  `public int seatsRemaining()` which will return the number of remaining open seats across all `Car`s
// - and finally, its own `printManifest()` that prints a roster of all `Passenger`s onboard (_Hint: ask your `Car`s to help!_)