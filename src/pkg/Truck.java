package pkg;

public class Truck extends Vehicle {
    public Truck(String brand, String type, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, StartMechanism startType, double gasTankCapacity) {
    	super(type, brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity);
    }
    
    public Truck(Truck vehicle) {
        super(vehicle);
    }

    @Override
    public double calculateMaintenanceCost(double distance) {
        return distance * mass * (2024 - getModelYear()) * cylinders * 0.002;
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelPrice) {
        return cylinders * gasTankCapacity * fuelPrice / (distance * 0.01);
    }

    @Override
    public void startEngine() {
        System.out.println("Start engine: KEYSTART");
    }
	
	
}