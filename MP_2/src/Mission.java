import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

public class Mission {

    private String name;
    private LocalDate beginDate;
    private LocalDate endDate;
    private List<MissionHistory> missionHistory = new ArrayList<>();


    public Mission(String name, LocalDate beginDate) {
        this.name = name;
        this.beginDate = beginDate;
    }
    public Mission(String name, LocalDate beginDate, LocalDate endDate) {
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public void addMissionHistory(MissionHistory missionHistory) {
        this.missionHistory.add(missionHistory);
        missionHistory.addMission(this);
    }

    public void removeMissionHistory(MissionHistory missionHistory) {
        this.missionHistory.remove(missionHistory);
        missionHistory.removeMission(this);
    }
}
