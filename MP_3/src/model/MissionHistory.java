package model;

import lombok.*;

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

        addVehicle(vehicle);
        addMission(mission);
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicle == null) {
            this.vehicle = vehicle;
            vehicle.addMissionHistory(this);
        }
    }

    public void addMission(Mission mission) {
        if (this.mission == null) {
            this.mission = mission;
            mission.addMissionHistory(this);
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            vehicle.removeMissionHistory(this);
            vehicle = null;
        }
    }

    public void removeMission(Mission mission) {
        if (mission != null) {
            mission.removeMissionHistory(this);
            mission = null;
        }
    }
}
