// 1. Encapsulation: Class with private fields and getter/setter methods
class Vehicle {
    private String make;
    private String model;

    // Constructor
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Getter and Setter methods for encapsulation
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // A method to display information about the vehicle
    public void displayInfo() {
        System.out.println("Make: " + make + ", Model: " + model);
    }
}

// 2. Inheritance: Car class inherits from Vehicle class
class Car extends Vehicle {
    private int doors;

    // Constructor
    public Car(String make, String model, int doors) {
        super(make, model); // Call the parent constructor
        this.doors = doors;
    }

    // Getter and Setter for doors
    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    // Polymorphism: Overriding the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the parent displayInfo
        System.out.println("Doors: " + doors);
    }
}

// 3. Polymorphism: Bike class overrides displayInfo method
class Bike extends Vehicle {
    private boolean isElectric;

    // Constructor
    public Bike(String make, String model, boolean isElectric) {
        super(make, model);
        this.isElectric = isElectric;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Electric: " + isElectric);
    }
}

// 4. Abstract class (Kelas Abstrak) and Interface (Antarmuka)

abstract class Animal {
    abstract void sound();
}

// Interface
interface Playable {
    void play();
}

class Dog extends Animal implements Playable {
    @Override
    void sound() {
        System.out.println("Dog says: Woof");
    }

    @Override
    public void play() {
        System.out.println("The dog is playing fetch.");
    }
}

// 5. Relasi antar kelas (Dependency, Aggregation, and Composition)

class Engine {
    private String type;

    // Constructor
    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

// Aggregation: Car has an Engine (but Engine can exist independently)
class CarWithEngine extends Vehicle {
    private Engine engine;

    public CarWithEngine(String make, String model, Engine engine) {
        super(make, model);
        this.engine = engine;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine: " + engine.getType());
    }
}

// Composition: House has Room (Room cannot exist without House)
class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Composition: House has a Room, meaning Room is part of House
class House {
    private Room room;

    public House(String roomName) {
        this.room = new Room(roomName);
    }

    public void displayHouseInfo() {
        System.out.println("House has a room: " + room.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        // Encapsulation: Using getter/setter methods
        Vehicle vehicle = new Vehicle("Toyota", "Camry");
        vehicle.displayInfo();

        // Inheritance and Polymorphism
        Car car = new Car("Honda", "Civic", 4);
        car.displayInfo();

        Bike bike = new Bike("Yamaha", "FZ", true);
        bike.displayInfo();

        // Abstract class and Interface
        Dog dog = new Dog();
        dog.sound();
        dog.play();

        // Aggregation: Car with Engine
        Engine engine = new Engine("V8");
        CarWithEngine carWithEngine = new CarWithEngine("Ford", "Mustang", engine);
        carWithEngine.displayInfo();

        // Composition: House with Room
        House house = new House("Living Room");
        house.displayHouseInfo();
    }
}
