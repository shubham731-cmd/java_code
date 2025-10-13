
class Car {
    int speed;          // in km/h
    double fuel;        // in liters
    double distance;    // in km

    Car(int speed, double fuel) {
        this.speed = speed;
        this.fuel = fuel;
        this.distance = 0;
    }

   
    void drive(int hours) {
        double possibleDistance = speed * hours;
        double fuelNeeded = possibleDistance / 10; 

        if (fuelNeeded <= fuel) {
            distance += possibleDistance;
            fuel -= fuelNeeded;
            System.out.println("Car drove " + possibleDistance + " km.");
        } else {
            double possible = fuel * 10; 
            distance += possible;
            fuel = 0;
            System.out.println("Car ran out of fuel after " + possible + " km!");
        }
    }

    void displayStatus() {
        System.out.println("Speed: " + speed + " km/h | Fuel: " + fuel + " L | Distance: " + distance + " km");
    }
}

class ElectricCar extends Car {

    ElectricCar(int speed, double batteryPercentage) {
        super(speed, batteryPercentage); 
    }

    @Override
    void drive(int hours) {
        double possibleDistance = speed * hours;
        double batteryNeeded = possibleDistance / 5; 

        if (batteryNeeded <= fuel) {
            distance += possibleDistance;
            fuel -= batteryNeeded;
            System.out.println("Electric car drove " + possibleDistance + " km.");
        } else {
            double possible = fuel * 5; 
            distance += possible;
            fuel = 0;
            System.out.println("Battery drained after " + possible + " km!");
        }
    }

    @Override
    void displayStatus() {
        System.out.println("Speed: " + speed + " km/h | Battery: " + fuel + "% | Distance: " + distance + " km");
    }
}


public class CarSimulation {
    public static void main(String[] args) {
        Car petrolCar = new Car(80, 10);          
        ElectricCar tesla = new ElectricCar(100, 80); 

        System.out.println("=== Petrol Car ===");
        petrolCar.drive(2);
        petrolCar.displayStatus();

        System.out.println("\n=== Electric Car ===");
        tesla.drive(2);
        tesla.displayStatus();


        System.out.println("\n=== Polymorphism Example ===");
        Car ref;          
        ref = tesla;      
        ref.drive(1);     
        ref.displayStatus();
    }
}
