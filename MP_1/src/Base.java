import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter

public class Base implements Serializable {

    private static List<Base> extent = new ArrayList<>();
    private String name;
    private double perimeter; // square kilometers
    private Localization localization;
    private static final String regionalCertification = "PLMAB"; // Poland Military Aerial Base
    private String airDefenceUnit;
    private Set<String> stationedBranches;
    private LocalDate openingDate;
    private LocalDate closedDate;

    public Base(String name, double perimeter, Localization localization, String airDefenceUnit, Set<String> stationedBranches, LocalDate openingDate) {
        this.name = name;
        this.perimeter = perimeter;
        this.localization = localization;
        this.airDefenceUnit = airDefenceUnit;
        this.stationedBranches = stationedBranches;
        this.openingDate = openingDate;

        extent.add(this);
    }

    public Base(String name, double perimeter, Localization localization, String airDefenceUnit, Set<String> stationedBranches, LocalDate openingDate, LocalDate closedDate) {
        this.name = name;
        this.perimeter = perimeter;
        this.localization = localization;
        this.airDefenceUnit = airDefenceUnit;
        this.stationedBranches = stationedBranches;
        this.openingDate = openingDate;
        this.closedDate = closedDate;

        extent.add(this);
    }

    public static void saveExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }
    public static void loadExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (List<Base>) stream.readObject();
    }

    public static List<Base> getExtent() {
        return extent;
    }

    public Period getLengthOfTimeSince() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(openingDate, currentDate);
    }

    public Period getLengthOfTimeSince(LocalDate date) {
        return Period.between(openingDate, date);
    }

    public static int getBaseCount() {
        return extent.size();
    }

    @Override
    public String toString() {
        String str =  regionalCertification + "-" + getName() + " data:\n" +
                "Perimeter: " + getPerimeter() +
                "\nLocalization: \n" + getLocalization() +
                "\nAir Defence Unit: " + getAirDefenceUnit() +
                "\nStationed Branches: " + getStationedBranches() +
                "\nOpening Date: " + getOpeningDate() +
                "\nTime Since Opening Date: " + getLengthOfTimeSince();

        if (closedDate != null) {
            str += "\nLife Span: " + getLengthOfTimeSince(closedDate);
            str = "xxxxxxx[CLOSED]xxxxxxx\n" + str;
        }

        return str;
    }
}
