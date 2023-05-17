package model;

import lombok.Getter;
import lombok.Setter;
import model.Buildings.Building;
import model.Vehicle.Vehicle;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Getter
@Setter
public class Base implements Serializable {

    private static List<Base> extent = new ArrayList<>();
    private String name;
    private double perimeter; // square kilometers
    private Map<Double, Localization> localizations = new HashMap<>();
    private static final String regionalCertification = "PLMAB"; // Poland Military Aerial Base
    private String airDefenceUnit;
    private List<MilitaryUnit> militaryUnits;
    private LocalDate openingDate;
    private LocalDate closedDate;
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Building> buildings = new ArrayList<>();

    public Base(String name, double perimeter, String airDefenceUnit, List<MilitaryUnit> stationedBranches, LocalDate openingDate) {
        this.name = name;
        this.perimeter = perimeter;
        this.airDefenceUnit = airDefenceUnit;
        this.militaryUnits = stationedBranches;
        this.openingDate = openingDate;

        extent.add(this);
    }

    public Base(String name, double perimeter, String airDefenceUnit, List<MilitaryUnit> stationedBranches, LocalDate openingDate, LocalDate closedDate) {
        this.name = name;
        this.perimeter = perimeter;
        this.airDefenceUnit = airDefenceUnit;
        this.militaryUnits = stationedBranches;
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
    public void addLocalization(Localization localization) {
        if (!localizations.containsKey(localization.getLocaleCode())) {
            localizations.put(localization.getLocaleCode(), localization);
            localization.setBase(this);
        }
    }

    public void removeLocalization(Localization localization) {
        if (localizations.containsKey(localization.getLocaleCode())) {
            localizations.remove(localization.getLocaleCode());
            localization.removeBase();
        }
    }

    public void addBuilding(Building building) throws Exception {

        if (buildings.contains(building)) {
            throw new Exception("You already have this building.");
        }

        for (Base base : extent) {
            if (base.getBuildings().contains(building)) {
                throw new Exception("model.Buildings.Building is in another base.");
            }
        }
        buildings.add(building);
    }

    public void removeBuilding(Building building) {
        if (buildings.contains(building)) {
            buildings.remove(building);
            building.removeBase();
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.addBase(this);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
        vehicle.removeBase();
    }
    @Override
    public String toString() {
        String str =  regionalCertification + "-" + getName() + " data:\n" +
                "Perimeter: " + getPerimeter() +
                "\nmodel.Localization: \n\t" + getLocalizations() +
                "\nAir Defence model.Unit: " + getAirDefenceUnit() +
                "\nStationed Branches: " + getMilitaryUnits() +
                "\nOpening Date: " + getOpeningDate() +
                "\nTime Since Opening Date: " + getLengthOfTimeSince();

        if (closedDate != null) {
            str += "\nLife Span: " + getLengthOfTimeSince(closedDate);
            str = "xxxxxxx[CLOSED]xxxxxxx\n" + str;
        }

        return str;
    }
}
