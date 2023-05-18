package model.Buildings;

import lombok.*;
import model.Base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Getter
@Setter

public class Building {

    enum Type {
        BUILDING, COMMAND, UTILITY, HOUSING
    }

    private String name;
    private double size;
    private String condition;
    private LocalDate dateOfBuilding;
    private Base base;
    private EnumSet<Type> types = EnumSet.of(Type.BUILDING);

    // Command Building
    private String role;
    private String securityMeasures;
    private String accessRank;
    private int staffCapacity;

    // Utility Building
    private List<String> equipment = new ArrayList<>();
    private String function;

    // Housing Building
    private int occupancy;
    private String housingType;
    private List<String> amenities = new ArrayList<>();

    public Building(String name, double size, String condition, LocalDate dateOfBuilding, boolean isCommand,
                    boolean isUtility, boolean isHousing) {
        this.name = name;
        this.size = size;
        this.condition = condition;
        this.dateOfBuilding = dateOfBuilding;

        if(isCommand)
            types.add(Type.COMMAND);
        if(isUtility)
            types.add(Type.UTILITY);
        if(isHousing)
            types.add(Type.HOUSING);
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
    public static Building createBuilding(Base base, String name, double size, String condition, LocalDate dateOfBuilding,
                                          boolean isCommand, boolean isUtility, boolean isHousing) throws Exception {
        if (base == null) {
            throw new Exception("The building must be assigned to a base.");
        }

        Building building = new Building(name, size, condition, dateOfBuilding, isCommand, isUtility, isHousing);
        base.addBuilding(building);
        building.addBase(base);

        return building;
    }

    public String getRole() throws Exception {
        if(types.contains(Type.COMMAND))
            return role;
        throw new Exception("The building is not a command building!");
    }

    public void setRole(String role) throws Exception {
        if(types.contains(Type.COMMAND))
            this.role = role;
        throw new Exception("This building is not a command building!");
    }

    public String getSecurityMeasures() throws Exception {
        if(types.contains(Type.COMMAND))
            return securityMeasures;
        throw new Exception("The building is not a command building!");
    }

    public void setSecurityMeasures(String securityMeasures) throws Exception {
        if(types.contains(Type.COMMAND))
            this.securityMeasures = securityMeasures;
        throw new Exception("This building is not a command building!");
    }

    public String getAccessRank() throws Exception {
        if(types.contains(Type.COMMAND))
            return accessRank;
        throw new Exception("The building is not a command building!");
    }

    public void setAccessRank(String accessRank) throws Exception {
        if(types.contains(Type.COMMAND))
            this.accessRank = accessRank;
        throw new Exception("This building is not a command building!");
    }

    public int getStaffCapacity() throws Exception {
        if(types.contains(Type.COMMAND))
            return staffCapacity;
        throw new Exception("The building is not a command building!");
    }

    public void setStaffCapacity(int staffCapacity) throws Exception {
        if(types.contains(Type.COMMAND))
            this.staffCapacity = staffCapacity;
        throw new Exception("This building is not a command building!");
    }

    public List<String> getEquipment() throws Exception {
        if(types.contains(Type.UTILITY))
            return equipment;
        throw new Exception("The building is not a utility building!");
    }

    public void setEquipment(List<String> equipment) throws Exception {
        if(types.contains(Type.UTILITY))
            this.equipment = equipment;
        throw new Exception("This building is not a utility building!");
    }

    public String getFunction() throws Exception {
        if(types.contains(Type.UTILITY))
            return function;
        throw new Exception("The building is not a utility building!");
    }

    public void setFunction(String function) throws Exception {
        if(types.contains(Type.UTILITY))
            this.function = function;
        throw new Exception("This building is not a utility building!");
    }

    public int getOccupancy() throws Exception {
        if(types.contains(Type.HOUSING))
            return occupancy;
        throw new Exception("The building is not a housing building!");
    }

    public void setOccupancy(int occupancy) throws Exception {
        if(types.contains(Type.HOUSING))
            this.occupancy = occupancy;
        throw new Exception("This building is not a housing building!");
    }

    public String getHousingType() throws Exception {
        if(types.contains(Type.HOUSING))
            return housingType;
        throw new Exception("The building is not a housing building!");
    }

    public void setHousingType(String housingType) throws Exception {
        if(types.contains(Type.HOUSING))
            this.housingType = housingType;
        throw new Exception("This building is not a housing building!");
    }

    public List<String> getAmenities() throws Exception {
        if(types.contains(Type.HOUSING))
            return amenities;
        throw new Exception("The building is not a housing building!");
    }

    public void setAmenities(List<String> amenities) throws Exception {
        if(types.contains(Type.HOUSING))
            this.amenities = amenities;
        throw new Exception("This building is not a housing building!");
    }
}
