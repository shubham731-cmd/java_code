abstract class Vehicle {
    String plateNumber;  
    int tollAmount;       

    Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    abstract int getTollAmount();
}

class Bike extends Vehicle {
    Bike(String plateNumber) {
        super(plateNumber);
         tollAmount = 30;
         
    }
    int getTollAmount(){
        return tollAmount;
    }

    
}

class Car extends Vehicle {
    Car(String plateNumber) {
        super(plateNumber);
        tollAmount = 50;
    }
    int getTollAmount(){
        return tollAmount;
    }
    
}


class Truck extends Vehicle {
    Truck(String plateNumber) {
        super(plateNumber);
        tollAmount = 200;
    }
    int getTollAmount(){
        return tollAmount;
    }
    
}

class TollBooth {
    int totalRevenue = 0; 

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

public class VehicleTollManagementSystem {
    public static void main(String[] args) {
        

      
        Vehicle v1 = new Bike("KA01AB1234");
        Vehicle v2 = new Car("KA02CD5678");
        Vehicle v3 = new Truck("KA03EF9012");
        
        TollBooth booth = new TollBooth();

        booth.processVehicle(v1);
        booth.processVehicle(v2);
        booth.processVehicle(v3);
        
        // tot myTotal=new tot();
        // myTotal.out(booth);
        
        booth.showTotalRevenue();
    }
}
