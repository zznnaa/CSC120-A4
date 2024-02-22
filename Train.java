import java.util.ArrayList;
import java.util.Iterator;

public class Train {

    //attributes
    private Engine engine;
    private ArrayList<Car> carList;

    //constructor
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        int count = 0;
        this.engine = new Engine(fuelType, fuelCapacity);
        this.carList = new ArrayList<Car>(nCars);
        //adds new cars to the arraylist carList while the array size is less than the capacity of the train
        while (this.carList.size() <= nCars){
            //creates a new temporary car
            Car tempCar = new Car(passengerCapacity);
            String newName = "Car" + String.valueOf(count);
            //assigns name to new car
            tempCar.assignName(newName);
            //adds car to carList
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

    //add car method
    public void addCar(){
        int count = this.carList.size() + 1;
        Car newCar = new Car(this.carList.get(0).getCapacity());
        String newName = "Car" + String.valueOf(count);
        newCar.assignName(newName);
        //need to expand size of array to be able to add new cars
        this.carList.add(newCar);
        System.out.println(newCar.getName() + " was added to the train!");
    }

    //remove car method
    public void removeCar(int i){
        //change i from Car # to Car INDEX #
        i -= 1;
        //check if car in train
        if (i <= this.carList.size()){
            //remove car
            System.out.println(this.carList.get(i).getName() + " was removed from the train!");
            this.carList.remove(i);
            updateCarNames();
        } else {
            System.out.println("That car is not contained in the train.");
            }
        }

    public void updateCarNames(){
        Iterator<Car> it = this.carList.iterator();
        while (it.hasNext()){
            //get car position in train
            Car car = it.next();
            int carNum = this.carList.indexOf(car) + 1;
            //assign name equal to index
            car.assignName("Car" + String.valueOf(carNum));
        }
    }

    //getters
    public Engine getEngine(){
        return this.engine;
    }

    public Car getCar(int i){
        return this.carList.get(i);
    }

    public int getMaxCapacity(){
        int size = this.carList.size();
        int carCap = this.carList.get(0).getCapacity();
        int maxCap = size * carCap;
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
        Passenger pass1 = new Passenger("Zoe");
        Passenger pass2 = new Passenger("Marianna");
        pass1.boardCar(train.carList.get(1));
        train.addCar();
        pass2.boardCar(train.carList.get(4));
        pass2.getOffCar(train.carList.get(4));
        train.removeCar(2);
        train.printManifest();
    }
}