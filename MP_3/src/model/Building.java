package model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public class Building {

    private String designation;
    private String name;
    private LocalDate dateOfBuilding;
    private Base base;

    private Building(String designation, String name, LocalDate dateOfBuilding) {
        this.designation = designation;
        this.name = name;
        this.dateOfBuilding = dateOfBuilding;

    }
    public void addBase(Base base) {
        if(this.base == null) {
            this.base = base;
        }
    }

    public void removeBase() {
        if(base != null) {
            base.removeBuilding(this);
            base = null;
        }
    }
    public static Building createBuilding(Base base, String designation, String name, LocalDate dateOfBuilding) throws Exception {
        if (base == null) {
            throw new Exception("The building must be assigned to a base.");
        }

        Building building = new Building(designation, name, dateOfBuilding);
        base.addBuilding(building);
        building.addBase(base);

        return building;
    }
}
