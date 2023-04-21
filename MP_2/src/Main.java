import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {

        Set<String> branches1 = new HashSet<String>();
        branches1.add("3rd Regiment for Radioelectronic Jamming");
        branches1.add("3rd Missile Air Defence Battalion");
        branches1.add("1st Air Cavalry Unit");
        Base base1 = new Base(
                "Warsaw Air Base",
                4.0,
                "Patriot Missle Long-Range Air-Defence System",
                branches1,
                LocalDate.now()
        );


//        Building b1 = Building.createBuilding(base1, "Housing", "Barracks", LocalDate.now());
//
//        System.out.println(base1.getBuildings());
//
//        System.out.println(b1.getBase());
//
//        Localization localization1 = new Localization("Mazowsze", 52.386586, 20.796222);
//        Localization localization2 = new Localization("Mazowsze", 51.903201, 19.842806);
//
//        System.out.println(localization1);
//
//        base1.addLocalization(localization1);
//
//        System.out.println(base1);
//
//        System.out.println(localization2.getBase());
//
//        localization2.setBase(base1);
//
//        System.out.println(localization2.getBase());

        Mission m1 = new Mission("Reconnaissance",
                LocalDate.of(2022, 10, 30),
                LocalDate.of(2022, 11, 5));

        Vehicle v1 = new Vehicle("WD 4142A", "Mitsubishi ASX", LocalDate.now(), "Civilian",
                "Small civilian SUV");

        MissionHistory mH1 = new MissionHistory(v1, m1,
                LocalDate.of(2022, 11, 2),
                LocalDate.of(2022, 11, 4));

    }
}