package model.Mission;

import lombok.*;
import model.Vehicle.LandVehicle;
import model.Vehicle.Vehicle;

import java.time.LocalDate;

@Getter
@Setter
@ToString(exclude = {"vehicle", "mission"})

public class MissionHistory {

    private Vehicle vehicle;
    private Mission mission;
    private LocalDate dateFrom;
    private LocalDate dateUntil;


    public MissionHistory(LocalDate dateFrom, LocalDate dateUntil) {
        this.dateFrom = dateFrom;
        this.dateUntil = dateUntil;
    }
    public MissionHistory(Vehicle vehicle, Mission mission, LocalDate dateFrom, LocalDate dateUntil) {
        this.vehicle = vehicle;
        this.mission = mission;
        this.dateFrom = dateFrom;
        this.dateUntil = dateUntil;

        if(vehicle instanceof LandVehicle) {
            this.mission.setLandInvolvement(true);
        } else this.mission.setAirInvolvement(true);

        this.vehicle.getMissionHistory().add(this);
        this.mission.getMissionHistory().add(this);
    }
}
