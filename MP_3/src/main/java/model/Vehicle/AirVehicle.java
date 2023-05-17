package model.Vehicle;

import java.time.LocalDate;

public class AirVehicle extends Vehicle {

    enum Propulsion {
        PROPELLER, JET
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
}
