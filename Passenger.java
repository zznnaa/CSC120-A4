public class Passenger {

    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    //methods
    public String getName() {
        return this.name;
    }

    /**
     * Tells a passenger to board a car.
     * @param c The car you want the passenger to board.
     */
    public void boardCar(Car c) {
        //calls the addPassenger function on the car for this object
        boolean call = c.addPassenger(this);
        if (call == true) {
            System.out.println("Passenger " + this.name + " was added to " + c.getName() + "!");
        } else {
            System.out.println("The car you selected is full!");
        }
    }

    /**
     * Tells a passenger to get off a car.
     * @param c The car you want the passenger to leave.
     */
    public void getOffCar(Car c) {
        //calls the removePassenger function on the car for this object
        boolean call = c.removePassenger(this);
        if (call == true) {
            System.out.println("Passenger " + this.name + " was removed from " + c.getName() + ".");
        } else {
            System.out.println("The passenger you selected is not on board.");
        }
    }

    public static void main(String[] args) {
        Passenger p = new Passenger("Zoe");
        Car carB = new Car(5);
        p.boardCar(carB);
        carB.printManifest();
        p.getOffCar(carB);
        carB.printManifest();

    }
}