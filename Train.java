import java.util.ArrayList;
import java.util.Iterator;

public class Train {

    //attributes
    private Engine engine;
    private ArrayList < Car > carList;

    //constructor
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        int count = 0;
        this.engine = new Engine(fuelType, fuelCapacity);
        this.carList = new ArrayList < Car > (nCars);
        //adds new cars to the arraylist carList while the array size is less than the capacity of the train
        while (this.carList.size() <= nCars) {
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

    /**
     * Prints manifest of every car on the train.
     */
    public void printManifest() {
        System.out.println("Manifest:");
        //iterates through carList
        for (Car car: carList) {
            //lists name of car
            System.out.println(car.getName() + ":");
            //calls printManifest function on the car to print passengers as well
            car.printManifest();
        }
        System.out.println();
    }

    /**
     * Adds a car to the train.
     */
    public void addCar() {
        //index number of new car
        int count = this.carList.size() + 1;
        //creates new car using passenger capacity of the 1st car
        Car newCar = new Car(this.carList.get(0).getCapacity());
        //renames car using index number
        String newName = "Car" + String.valueOf(count);
        newCar.assignName(newName);
        //adds car to train
        this.carList.add(newCar);
        System.out.println(newCar.getName() + " was added to the train!");
    }

    /**
     * Removes a car from the train.
     * @param i The number of the car you want to remove.
     */
    public void removeCar(int i) {
        //change i from Car # to Car INDEX #
        i -= 1;
        //check if car in train
        if (i <= this.carList.size()) {
            //remove car
            System.out.println(this.carList.get(i).getName() + " was removed from the train!");
            this.carList.remove(i);
            //calls updateCarNames function
            updateCarNames();
        } else {
            System.out.println("That car is not contained in the train.");
        }
    }

    /**
     * Updates car names (for after removing a car from the train.)
     */
    public void updateCarNames() {
        Iterator < Car > it = this.carList.iterator();
        //iterates through while there is another car in the train
        while (it.hasNext()) {
            //get car position in train
            Car car = it.next();
            int carNum = this.carList.indexOf(car) + 1;
            //assign name equal to index
            car.assignName("Car" + String.valueOf(carNum));
        }
    }

    //getters
    public Engine getEngine() {
        return this.engine;
    }

    public Car getCar(int i) {
        return this.carList.get(i);
    }

    public int getMaxCapacity() {
        //get number of cars in train
        int size = this.carList.size();
        //get capacity of car 1
        int carCap = this.carList.get(0).getCapacity();
        //multiple capacity by size to find total max cap of train
        int maxCap = size * carCap;
        return maxCap;
    }

    public int seatsRemaining() {
        int seatsLeft = 0;
        //iterates through carList
        for (Car car: this.carList) {
            //adds how many seats remain in each car to a variable
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