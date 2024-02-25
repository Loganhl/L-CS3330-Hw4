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
                String model = parts[1];
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
                        vehicleList.add(new SUV(type, model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity));
                        break;
                    case "Truck":
                    	vehicleList.add(new Truck(type, model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity));
                        break;
                    case "Car":
                    	vehicleList.add(new Car(type, model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity));
                        break;
                    case "MotorBike":
                    	vehicleList.add(new MotorBike(type, model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, startType, gasTankCapacity));
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
            
            
}
