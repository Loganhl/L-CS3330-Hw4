package pkg;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

public class VehicleManager {

	private String vehicleFilePath;
	private ArrayList<Vehicle> vehicleList;

	
	public boolean initializeVehicle() {

		try {
			//Sets the file and count variable.
            File file = new File(vehicleFilePath);
            Scanner scanner = new Scanner(file);
            int count = 0;
            
            // Error testing to ensure information is being passed.
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                System.out.println("Inventory file is empty.");
                scanner.close();
                return false;
            }

            //Adds to the count integer to create an array the sized of the file being read.
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }

            scanner.close();
            
            scanner = new Scanner(file);
            
            //Skipping first line.
            if (scanner.hasNextLine()) {
                scanner.nextLine(); 
            }
            
            vehicleList = new ArrayList<Vehicle>();
            
            //Adding values to the object.
            for (int i = 0; i < count; i++) {
                String[] parts = scanner.nextLine().split(",");
                
         
                
                String type = parts[0];
                String brand = parts[1];
                String make = parts[2];
                long modelYear = Long.parseLong(parts[3]);
                double price = Double.parseDouble(parts[4]);
                VehicleColor color = VehicleColor.valueOf(parts[5].toUpperCase());
                FuelType fuelType = FuelType.valueOf(parts[6].toUpperCase());
                double mileage = Double.parseDouble(parts[7]);
                double mass = Double.parseDouble(parts[8]);
                int cylinders = Integer.parseInt(parts[9]);
                StartMechanism startType = StartMechanism.valueOf(parts[10].toUpperCase());
                double gasTankCapacity = Double.parseDouble(parts[11]); // Assuming it's part of input

                //Enum needs to go here
                //Genre genre = Genre.valueOf(parts[4].toUpperCase());

                switch (type) {
                    case "SUV":
                        vehicleList.add(new SUV(type, brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity));
                        break;
                    case "Truck":
                    	vehicleList.add(new Truck(type, brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity));
                        break;
                    case "Car":
                    	vehicleList.add(new Car(type, brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity));
                        break;
                    case "MotorBike":
                    	vehicleList.add(new MotorBike(type, brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity));
                        break;
                }

            }

            scanner.close();
            
            return true;
	        
		} catch (Exception e){
			System.out.println(e);
			return false;
		}
		
	}
	
	public void displayAllCarInformation() {
		boolean carFound = false;
		
		System.out.println("Car information: ");
		for (Vehicle vehicle : vehicleList) {
			if(vehicle instanceof Car) {
				Car car = (Car) vehicle;
				System.out.println(car.toString());
                System.out.println("Maintenance Cost: " + car.calculateMaintenaceCost(distance));
                System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency(distance, fuelPrice));
                System.out.println("Engine Start: " + car.startEngine());
                System.out.println("-----------------------------");
                carFound = true;
			}
		}
		
		if (!carFound) {
			System.out.println("No cars found in inventory.");
		}
	}
	
	public void displayAllTruckInformation() {
		boolean truckFound = false;
		
		System.out.println("Truck information: ");
		for (Vehicle vehicle : vehicleList) {
			if(vehicle instanceof Truck) {
				Truck truck = (Truck) vehicle;
				System.out.println(truck.toString());
                System.out.println("Maintenance Cost: " + truck.calculateMaintenaceCost(distance));
                System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency(distance, fuelPrice));
                System.out.println("Engine Start: " + truck.startEngine());
                System.out.println("-----------------------------");
                truckFound = true;
			}
		}
		
		if (!truckFound) {
			System.out.println("No trucks found in inventory.");
		}
	}
	
	public void displayAllSUVInformation() {
		boolean SUVFound = false;
		
		System.out.println("SUV information: ");
		for (Vehicle vehicle : vehicleList) {
			if(vehicle instanceof SUV) {
				SUV suv = (SUV) vehicle;
				System.out.println(suv.toString());
                System.out.println("Maintenance Cost: " + suv.calculateMaintenaceCost(distance));
                System.out.println("Fuel Efficiency: " + suv.calculateFuelEfficiency(distance, fuelPrice));
                System.out.println("Engine Start: " + suv.startEngine());
                System.out.println("-----------------------------");
                SUVFound = true;
			}
		}
		
		if (!SUVFound) {
			System.out.println("No SUVs found in inventory.");
		}
	}
	
	public void displayAllMotorBikeInformation() {
		boolean motorBikeFound = false;
		
		System.out.println("Motor Bike information: ");
		for (Vehicle vehicle : vehicleList) {
			if(vehicle instanceof MotorBike) {
				MotorBike motorBike = (MotorBike) vehicle;
				System.out.println(motorBike.toString());
                System.out.println("Maintenance Cost: " + motorBike.calculateMaintenaceCost(distance));
                System.out.println("Fuel Efficiency: " + motorBike.calculateFuelEfficiency(distance, fuelPrice));
                System.out.println("Engine Start: " + motorBike.startEngine());
                System.out.println("-----------------------------");
                motorBikeFound = true;
			}
		}
		
		if (!motorBikeFound) {
			System.out.println("No motor bikes found in inventory.");
		}
	}
	
	public void displayVehicleInformation(Vehicle v) {
		if (v != null) {
            System.out.println("Vehicle Information:");
            System.out.println(v.toString());
            System.out.println("Maintenance Cost: " + v.calculateMaintenaceCost(distance));
            System.out.println("Fuel Efficiency: " + v.calculateFuelEfficiency(distance, fuelPrice));
            System.out.println("Engine Start: " + v.startEngine());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Vehicle not found.");
        }
	}
	
	public void displayAllVehicleInformation(ArrayList<? extends Vehicle> vehicleList) {
		if(vehicleList.isEmpty()) {
			System.out.println("No vehicles to display");
			
		} else {
			for (Vehicle vehicle : vehicleList) {
				System.out.println(vehicle.toString());
			}
		}
	}
            
    public boolean removeVehicle(Vehicle vehicle) {
    	if (vehicleList.contains(vehicle)) {
    		vehicleList.remove(vehicle);
    		System.out.println("\nVehicle removed from the inventory: " );
    		return true;
    	} else {
    		System.out.println("\nVehicle not found. Removal failed. ");
    		return false;
    	}
    	
    }
    
    public boolean addVehicle(Vehicle vehicle) {
    	if (vehicleList.contains(vehicle)) {
    		System.out.println("\nVehicle arleady exists in inventory. Addition failed.");
    		return false;
    	}
    	
    	vehicleList.add(vehicle);
    	
    	System.out.println("\nVehicle added to the inventory: ");
    	return true;
    }
    
    public boolean saveVehicleList() {
    	try {
    		FileWriter writer = new FileWriter(vehicleFilePath);
    		
    		writer.write("Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType\n");
    		
    		for (Vehicle vehicle : vehicleList) {
    			String vehicleLine = String.format("%s,%s,%s,%d,%d,%s,%s,%d,%.1f,%d,%d,%s",
    					vehicle.getClass().getSimpleName(),
    					vehicle.getModel(),
    					vehicle.getMake(),
    					vehicle.getModelYear(),
    					vehicle.getPrice(),
    					vehicle.getColor().toString(),
    					vehicle.getFuelType().toString(),
    					vehicle.getMileage(),
    					vehicle.getMass(),
    					vehicle.getCylinders(),
    					vehicle.getGasTankCapacity(),
    					vehicle.getStartType().toString());
    			
    					
        				writer.write(vehicleLine);
    		}
        	writer.close();
        	return true;
        	
    	} catch (IOException e) {
    		System.out.println("Error saving inventory to file: "+ e.getMessage());
    		return false;
    	}
    }
    
    private boolean isVehicleType(Vehicle v, Class clazz) {
    	return clazz.isInstance(v);
    }
	
    public int getNumberOfVehichlesByType(Class clazz) {
    	int count = 0;
    	for (Vehicle vehicle : vehicleList) {
    		if(clazz.isInstance(vehicle)) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
    	Vehicle vehicleWithHighestCost = null;
        double highestCost = Double.MIN_VALUE;

        for (Vehicle vehicle : vehicleList) {
            double maintenanceCost = vehicle.calculateMaintenaceCost(distance);
            if (maintenanceCost > highestCost) {
                highestCost = maintenanceCost;
                vehicleWithHighestCost = vehicle;
            }
        }

        return vehicleWithHighestCost;
    }
    
    public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
    	Vehicle vehicleWithLowestCost = null;
        double lowestCost = Double.MAX_VALUE;

        for (Vehicle vehicle : vehicleList) {
            double maintenanceCost = vehicle.calculateMaintenaceCost(distance);
            if (maintenanceCost < lowestCost) {
                lowestCost = maintenanceCost;
                vehicleWithLowestCost = vehicle;
            }
        }

        return vehicleWithLowestCost;
    }
    
    public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
    	ArrayList<Vehicle> vehiclesWithHighestEfficiency = new ArrayList<>();
        double highestEfficiency = Double.MIN_VALUE;

        for (Vehicle vehicle : vehicleList) {
            double efficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
            if (efficiency > highestEfficiency) {
                highestEfficiency = efficiency;
                vehiclesWithHighestEfficiency.clear();
                vehiclesWithHighestEfficiency.add(vehicle);
            } else if (efficiency == highestEfficiency) {
                vehiclesWithHighestEfficiency.add(vehicle);
            }
        }

        return vehiclesWithHighestEfficiency;
    }
    
    public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
    	ArrayList<Vehicle> vehiclesWithLowestEfficiency = new ArrayList<>();
        double lowestEfficiency = Double.MAX_VALUE;

        for (Vehicle vehicle : vehicleList) {
            double efficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
            if (efficiency < lowestEfficiency) {
                lowestEfficiency = efficiency;
                vehiclesWithLowestEfficiency.clear();
                vehiclesWithLowestEfficiency.add(vehicle);
            } else if (efficiency == lowestEfficiency) {
                vehiclesWithLowestEfficiency.add(vehicle);
            }
        }

        return vehiclesWithLowestEfficiency;
    }
    
    public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
    	int suvCount = 0;
        double totalFuelEfficiency = 0.0;

        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof SUV) {
                suvCount++;
                totalFuelEfficiency += vehicle.calculateFuelEfficiency(distance, fuelPrice);
            }
        }

        if (suvCount == 0) {
            return -1.0;
        }

        return totalFuelEfficiency / suvCount;
    }
}
