package com.mas.airbase;

import init.Init;
import model.MilitaryUnit;
import org.junit.Test;

import java.util.List;

public class Tests {

    public void setUp() {
        try {
            Init.initializeData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void superUnits() {

        setUp();

        List<MilitaryUnit> units = MilitaryUnit.getExtent();

        MilitaryUnit superUnit = units.get(0);

        for(MilitaryUnit unit : units) {
            System.out.println(unit);
        }

        for(MilitaryUnit unit : units) {
            if(unit != superUnit) {
                superUnit.makeSuperUnitOf(unit);
            }
        }

        MilitaryUnit.printSuperUnits();
    }
}
