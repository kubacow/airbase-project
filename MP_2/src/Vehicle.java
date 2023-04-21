import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"base"})

public class Vehicle {

    private String registration;
    private String name;
    private LocalDate dateOfArrival;
    private String usage;
    private String description;
    private Base base;
    private List<MissionHistory> missionHistory = new ArrayList<>();

    public Vehicle(String registration, String name, LocalDate dateOfArrival, String usage, String description) {
        this.registration = registration;
        this.name = name;
        this.dateOfArrival = dateOfArrival;
        this.usage = usage;
        this.description = description;
        this.base = base;

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

    public void addMissionHistory(MissionHistory missionHistory) {
        this.missionHistory.add(missionHistory);
        missionHistory.addVehicle(this);
    }

    public void removeMissionHistory(MissionHistory missionHistory) {
        this.missionHistory.remove(missionHistory);
        missionHistory.removeVehicle(this);
    }
}
