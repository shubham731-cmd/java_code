import java.util.Scanner;

abstract class Animal {
    private String name;
    private int health;   
    private boolean isHungry;

    Animal(String name) {
        this.name = name;
        this.health = 100;  
        this.isHungry = true;
    }

    public void eat() {
        if (isHungry) {
            System.out.println(name + " is eating.");
            isHungry = false;
            health += 10;
        } else {
            System.out.println(name + " is not hungry.");
        }
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
        health += 5;
    }

    public abstract void makeSound();

    public String getName() { return name; }
    public int getHealth() { return health; }
    public boolean getHungryStatus() { return isHungry; }
}

class Lion extends Animal {
    Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars: Roarrr!");
    }
}

class Elephant extends Animal {
    Elephant(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " trumpets: Pawoo!");
    }
}

class Monkey extends Animal {
    Monkey(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " chatters: Oooh Aaah!");
    }
}



public class  ZooAnimalManagementSystem {
    public static void main(String[] args) {
        Animal lion = new Lion("Leo");
        Animal elephant = new Elephant("Ella");
        Animal monkey = new Monkey("Momo");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Zoo Management Menu ---");
            System.out.println("1. Feed Lion");
            System.out.println("2. Feed Elephant");
            System.out.println("3. Feed Monkey");
            System.out.println("4. Make Lion Sound");
            System.out.println("5. Make Elephant Sound");
            System.out.println("6. Make Monkey Sound");
            System.out.println("7. Sleep all animals");
            System.out.println("8. Show Health Status");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) lion.eat();
            else if (choice == 2) elephant.eat();
            else if (choice == 3) monkey.eat();
            else if (choice == 4) lion.makeSound();
            else if (choice == 5) elephant.makeSound();
            else if (choice == 6) monkey.makeSound();
            else if (choice == 7) {
                lion.sleep();
                elephant.sleep();
                monkey.sleep();
            }
            else if (choice == 8) {
                System.out.println(lion.getName() + " Health: " + lion.getHealth());
                System.out.println(elephant.getName() + " Health: " + elephant.getHealth());
                System.out.println(monkey.getName() + " Health: " + monkey.getHealth());
            }
            else if (choice == 9) {
                System.out.println("Exiting...");
                break;
            }
            else System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
