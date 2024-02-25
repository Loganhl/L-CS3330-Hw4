package pkg;

//Inherits from Vehicle.
public class Car extends Vehicle {
    public Car(String brand, String type, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, StartMechanism startType, double gasTankCapacity) {
    	super(type, brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity);
    }
    
    public Car(Car vehicle) {
        super(vehicle);
    }

    public double calculateMaintenanceCost(double distance) {
        return distance * mass * (2024 - getModelYear()) * cylinders * 0.005;
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelPrice) {
        return cylinders * gasTankCapacity * fuelPrice / (distance * 0.003);
    }

    @Override
    public void startEngine() {
        System.out.println("Start engine: PUSHSTART");
    }
}