package model.Vehicle;

import lombok.*;
import model.Base;
import model.Mission.MissionHistory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"base"})

public abstract class Vehicle {

    private static List<Vehicle> extent = new ArrayList<>();
    private String registration;
    private String name;
    private LocalDate dateOfArrival;
    private String function;
    private String description;
    private Base base;
    protected List<MissionHistory> missionHistory = new ArrayList<>();


    public Vehicle(String registration, String name, LocalDate dateOfArrival, String usage, String description) {
        this.registration = registration;
        this.name = name;
        this.dateOfArrival = dateOfArrival;
        this.function = usage;
        this.description = description;

        extent.add(this);

    }

    public void removeBase() {
        if(base != null) {
            base.removeVehicle(this);
            base = null;
        }
    }

    public void addBase(Base base) {
        if (this.base == null) {
            this.base = base;
            base.addVehicle(this);
        }
    }

    public void addMissionHistory(MissionHistory missionHistory) {}

    public void removeMissionHistory(MissionHistory missionHistory) {}
}
