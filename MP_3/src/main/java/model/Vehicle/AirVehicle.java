package model.Vehicle;

import java.time.LocalDate;

public class AirVehicle extends Vehicle {

    enum Propulsion {
        PROPELLER, JET
    }

    enum FuelTypes {
        AVGAS, JETFUEL, DIESEL
    }
    private String name;
    private String propulsion;

    public AirVehicle(String registration, String name, LocalDate dateOfArrival, String usage, String description,
                      String propulsion) {
        super(registration, name, dateOfArrival, usage, description);

        setPropulsion(propulsion);
    }

    public void setPropulsion(String propulsion) {

        try {
            AirVehicle.Propulsion.valueOf(propulsion.toUpperCase());
            this.propulsion = propulsion;
        }
        catch (IllegalArgumentException e) {
            System.out.println("The propulsion type " + propulsion + " isn't defined by the system.");
        }
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
