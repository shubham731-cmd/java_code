// Abstract base class (Abstraction)
abstract class Vehicle {
    String plateNumber;   // Vehicle number
    int tollAmount;       // Toll charge

    // Constructor
    Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    // Abstract method (must be defined by each child class)
    abstract int getTollAmount();
}

// Bike class (Inheritance)
class Bike extends Vehicle {
    Bike(String plateNumber) {
        super(plateNumber);
         tollAmount = 30;
         
    }
    int getTollAmount(){
        return tollAmount;
    }

    
}

// Car class (Inheritance)
class Car extends Vehicle {
    Car(String plateNumber) {
        super(plateNumber);
        tollAmount = 50;
    }
    int getTollAmount(){
        return tollAmount;
    }
    
}

// Truck class (Inheritance)
class Truck extends Vehicle {
    Truck(String plateNumber) {
        super(plateNumber);
        tollAmount = 200;
    }
    int getTollAmount(){
        return tollAmount;
    }
    
}

// Toll Booth class
class TollBooth {
    int totalRevenue = 0;  // Total money collected

    // Polymorphism: same method works for Bike, Car, or Truck
    void processVehicle(Vehicle v) {
        System.out.println("Vehicle Plate: " + v.plateNumber + " | Toll Collected:" + v.getTollAmount());
        totalRevenue += v.getTollAmount();
    }
    // int getTotalRevenue() {
    //     return totalRevenue;
    // }
    void showTotalRevenue(){
        System.out.println("Total Revenue: "+ totalRevenue);
    }

}
// class tot{
//     void out(TollBooth a){
//         System.out.println("Total Revenue: "+a.getTotalRevenue());
//     }
// }
// Main class
public class VehicleTollManagementSystem {
    public static void main(String[] args) {
        

        // Different vehicles
        Vehicle v1 = new Bike("KA01AB1234");
        Vehicle v2 = new Car("KA02CD5678");
        Vehicle v3 = new Truck("KA03EF9012");
        
        TollBooth booth = new TollBooth();
        // Process vehicles (Polymorphism in action)
        booth.processVehicle(v1);
        booth.processVehicle(v2);
        booth.processVehicle(v3);
        
        // tot myTotal=new tot();
        // myTotal.out(booth);
        // Show total revenue
        booth.showTotalRevenue();
    }
}
