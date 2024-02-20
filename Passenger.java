public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    //methods
    public String getName(){
        return this.name;
    }
    
    //board car - check return to see if car already full
    public void boardCar(Car c){
        boolean hold = c.addPassenger(this);
        if (hold == true){
            System.out.println("Passenger " + this.name + " was added to " + c.getName() + "!");
        } else {
            System.out.println("The car you selected is full!");
        }
    }

    //getoff car - check return to see if passenger wasn't on board
    public void getOffCar(Car c){
        boolean hold = c.removePassenger(this);
        if (hold == true){
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