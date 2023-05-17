package model.Vehicle;

import java.time.LocalDate;

public class LandVehicle extends Vehicle{

    enum FuelTypes {
        DIESEL, GASOLINE, LPG
    }
    private String vehicleFuelType;
    private boolean armoured;

    public LandVehicle(String registration, String name, LocalDate dateOfArrival, String usage, String description,
                       String vehicleFuelType, boolean armoured) throws Exception {
        super(registration, name, dateOfArrival, usage, description);

        this.armoured = armoured;

        setUpFuelType(vehicleFuelType);
    }

    private void setUpFuelType(String vehicleFuelType) throws Exception{

        try {
            FuelTypes fuelTypes = FuelTypes.valueOf(vehicleFuelType.toUpperCase());
            this.vehicleFuelType = vehicleFuelType;
        }
        catch (IllegalArgumentException e) {
            System.out.println("The fuel type " + vehicleFuelType + " isn't defined by the system.");
        }
    }
}
