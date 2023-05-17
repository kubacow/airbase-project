package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString

public class MilitaryUnit {

    private static List<MilitaryUnit> extent = new ArrayList<>();
    private String name;
    private String countryOfOrigin;
    private String unitIdentification;
    private static Map<String, List<MilitaryUnit>> units = new HashMap<>();

    public MilitaryUnit(String name, String countryOfOrigin, String unitIdentification) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.unitIdentification = unitIdentification;

        units.put(unitIdentification, new ArrayList<>());

        extent.add(this);
    }

    public void makeSuperUnitOf(MilitaryUnit subUnit) {
        for(Map.Entry<String, List<MilitaryUnit>> entry : units.entrySet()) {
            if(entry.getValue() != null) {
                if(entry.getKey().equals(getUnitIdentification()))
                    entry.getValue().add(subUnit);
            }

        }
    }

    public void removeSuperUnit(MilitaryUnit superUnit) {
        units.remove(superUnit.getUnitIdentification(), this);
    }

    public static void printSuperUnits() {
        for(Map.Entry<String, List<MilitaryUnit>> entry : units.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static List<MilitaryUnit> getExtent() {
        return extent;
    }
}
