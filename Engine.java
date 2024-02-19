import javax.net.ssl.TrustManager;
import javax.swing.plaf.TreeUI;

public class Engine {

    //attributes
    FuelType fuelType;
    double currentFuel;
    double maxFuel;

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
        this.currentFuel = this.currentFuel - 5;
        //print some useful information (remaining fuel level)
        System.out.println("Remaning Fuel Level:" + this.currentFuel);
        //return true if fuel level is above 0 and false otherwise
        if (this.currentFuel>0){
            return true;
        } else {
            return false;
        }
    }

    //accessors and manipulators

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
}



// - appropriate accessors for fuel type, current fuel, max fuel

// Remember, OOP is all about deciding which classes are responsible for which parts of the end solution. As you program, consider which of these attributes/methods should be `public`, and which should be `private`. These questions may be helpful to ask yourself: