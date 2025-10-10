 abstract class FoodItem{
    int cost;
    int cookingTime;
    String FoodID;
    String name;
    FoodItem(String FoodID, String name){
        this.FoodID=FoodID;
        this.name=name;
    }
}
class Pizza extends FoodItem{
    Pizza(String FoodID,String name){
        super(FoodID,name);
        cost=30;
        cookingTime=10;
    }
}
class Burger extends FoodItem{
    Burger(String FoodID, String name){
        super(FoodID,name);
        cost=50;
        cookingTime=20;
    }
}
class Pasta extends FoodItem{
    Pasta(String FoodID,String name){
        super(FoodID,name);
        cost=100;
        cookingTime=50;
    }
}

class Out{
    void out(FoodItem f){
        System.out.println("Food name :"+f.name+", Food ID: "+ f.FoodID+", Cost: " + f.cost+ ", Cooking Time: "+f.cookingTime);
    }
}

public class RestaurantMenuSimulation
{
	public static void main(String[] args) {
		
		FoodItem f1= new Pizza("pz12","Pizza");
		FoodItem f2 =new Burger("br43","Burger");
		FoodItem f3=new Pasta("ps66","Pasta");
		
		Out myOut= new Out();
		
		myOut.out(f1);
		myOut.out(f2);
		myOut.out(f3);
	}
}
