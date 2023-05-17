package init;

import model.*;
import model.Mission.Mission;
import model.Mission.MissionHistory;
import model.Vehicle.AirVehicle;
import model.Vehicle.LandVehicle;
import model.Vehicle.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Init {

    // Rendering the data
    public static void initializeData() throws Exception {

        // Adding vehicles

        Vehicle v1 = new LandVehicle("UB13142", "KTO Rosomak", LocalDate.of(2022,4,25), "Armoured",
                "Armoured infantry transportation.", "diesel", true);

        Vehicle v2 = new LandVehicle("UG 0003", "Leopard 2PL", LocalDate.of(2022, 4,26),
                "Armoured","Heavy armour.", "diesel", true);

        AirVehicle v3 = new AirVehicle("UA3213", "Blackhawk", LocalDate.of(2022, 6, 12),
                "Transportation","Aerial infantry transportation.", "Jet");

        // Adding missions

        Mission m1 = new Mission("Heavy armoured infantry practice.", LocalDate.of(2023, 1, 5));

        Mission m2 = new Mission("Infantry hot drop practice.", LocalDate.of(2023, 2, 13),
                LocalDate.of(2023, 2, 15));

        // Adding mission history

        MissionHistory mH1 = new MissionHistory(v3, m2, LocalDate.now(), LocalDate.now());

        MissionHistory mH2 = new MissionHistory(v2, m1, LocalDate.now(), LocalDate.now());

        MissionHistory mH3 = new MissionHistory(v1, m1, LocalDate.now(), LocalDate.now());

        // Adding units

        MilitaryUnit mU1 = new MilitaryUnit("3rd Regiment for Radioelectronic Jamming", "Poland",
                generateString());

        MilitaryUnit mU2 = new MilitaryUnit("3rd Missile Air Defence Battalion", "Poland",
                generateString());

        MilitaryUnit mU3 = new MilitaryUnit("1st Air Cavalry Unit", "Poland",
                generateString());

        List<MilitaryUnit> units1 = new ArrayList<>(), units2 = new ArrayList<>();

        units1.add(mU1);
        units2.add(mU2);
        units2.add(mU3);

        // Adding bases

        Base base1 = new Base(
                "Warsaw Air Base",
                4.0,
                "Patriot Missle Long-Range Air-Defence System",
                units1,
                LocalDate.of(2010, 5, 21)
        );

        Base base2 = new Base(
                "Lublin Air Base",
                2.4,
                null,
                units2,
                LocalDate.of(2018, 7, 12)
        );


    }

    // Helper methods
    public static String generateString() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
