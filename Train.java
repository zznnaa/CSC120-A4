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

    //add car method
    public void addCar(){
        int count = this.carList.size() + 1;
        Car newCar = new Car(this.carList.get(0).getCapacity());
        String newName = "Car" + String.valueOf(count);
        newCar.assignName(newName);
        //need to expand size of array to be able to add new cars
        this.carList.add(newCar);
    }

    //remove car method
    public void removeCar(int i){
        //change i from Car # to Car INDEX #
        i -= 1;
        //check if car in train
        if (i <= this.carList.size()){
            //check if people on car
            if (this.carList.get(i).passengerList.size() > 0){
            //remove passengers from car
            for (Passenger p:this.carList.get(i).passengerList){
                p.getOffCar(this.carList.get(i));
            }
        }
        //remove car
        this.carList.remove(i);
        } else {
            System.out.println("That car is not contained in the train.");
        } 
    }

    //REMOVE METHOD THROWING CONCURRENT MODIFICATION ERROR SO NEED TO USE AN ITERATOR
    //MAKE METHOD TO UPDATE NAMES OF CARS SO THEYRE ACCURATE AFTER REMOVAL

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
        pass1.boardCar(train.carList.get(3));
        train.addCar();
        train.printManifest();
        train.removeCar(4);
        train.printManifest();
        //load 4 passengers on the train
    }
}