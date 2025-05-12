public class Car {
    // Instance variables
    private String carName;
    private double fuelTankCapacity; // in gallons
    private double mileage; // in miles per gallon
    private double gasLevel; // in gallons

    // Overloaded constructor
    public Car(String carName, double fuelTankCapacity, double mileage) {
        this.carName = carName;
        this.fuelTankCapacity = fuelTankCapacity;
        this.mileage = mileage;
        this.gasLevel = 0.0; // Initially, the gas level is 0
    }

    // Setters
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }
    public void setGasLevel(double gasLevel) {
        this.gasLevel = gasLevel;
    }



    // Getters
    public String getCarName() {
        return carName;
    }

    public double getMileage() {
        return mileage;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public double getGasLevel() {
        return gasLevel;
    }

    // toString method
    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", mileage=" + mileage +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", gasLevel=" + gasLevel +
                '}';
    }

    // Method to drive the car a specified distance
    public void drive(double distance) {
        double gasNeeded = distance / mileage; // Calculate gas needed for the distance
        if (gasNeeded <= gasLevel) {
            gasLevel -= gasNeeded; // Reduce gas level
        } else {
            // If not enough gas, drive as far as possible
            double possibleDistance = gasLevel * mileage;
            gasLevel = 0; // All gas is used
            System.out.println("Car drove " + possibleDistance + " miles before running out of gas.");
        }
    }

    // Method to check if the car can drive a specified distance
    public boolean canDrive(double distance) {
        double gasNeeded = distance / mileage; // Calculate gas needed for the distance
        return gasNeeded <= gasLevel; // Return true if enough gas is available
    }

    // Method to fill the gas tank
    public void fillGas(double x) {
        if (gasLevel + x <= fuelTankCapacity) {
            gasLevel += x;
            System.out.println("Filled " + x + " gallons of gas into the car " + carName + ".");
        } else {
            System.out.println("Cannot fill more gas. Tank capacity exceeded.");
        }
    }
}
