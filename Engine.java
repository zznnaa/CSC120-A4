import javax.net.ssl.TrustManager;
import javax.swing.plaf.TreeUI;

public class Engine {

    //attributes
    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;

    //constructor
    public Engine(FuelType fuelType, double maxFuel){
        this.fuelType = fuelType;
        this.maxFuel = maxFuel;
        this.currentFuel = maxFuel;

    }

    //methods
    public void refuel(){
        //reset current fuel level to maximum
        this.currentFuel = this.maxFuel;
    }

    public boolean go(){
        //decrease current fuel level
        this.currentFuel = this.currentFuel - 25;
        //print some useful information (remaining fuel level)
        System.out.println("Remaning Fuel Level:" + this.currentFuel);
        //return true if fuel level is above 0 and false otherwise
        if (this.currentFuel>0){
            return true;
        } else {
            return false;
        }
    }

    //accessors
    public FuelType getFuelType(){
        return this.fuelType;
    }

    public double getMaxFuel(){
        return this.maxFuel;
    }

    public double getCurrentFuel(){
        return this.currentFuel;
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
}
