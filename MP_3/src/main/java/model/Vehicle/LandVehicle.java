package model.Vehicle;

import java.time.LocalDate;

public class LandVehicle extends Vehicle{

    enum FuelTypes {
        DIESEL, GASOLINE, LPG
    }

    private boolean armoured;

    public LandVehicle(String registration, String name, LocalDate dateOfArrival, String usage, String description,
                       String vehicleFuelType, boolean armoured) throws Exception {
        super(registration, name, dateOfArrival, usage, description);

        this.armoured = armoured;

        setUpFuelType(vehicleFuelType);
    }

    public void setUpFuelType(String vehicleFuelType) {
        try {
            LandVehicle.FuelTypes.valueOf(vehicleFuelType.toUpperCase());
            setVehicleFuelType(vehicleFuelType);
        }
        catch (IllegalArgumentException e) {
            System.out.println("The fuel type " + vehicleFuelType + " isn't defined by the system.");
        }
    }


}
