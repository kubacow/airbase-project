import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    static String fileName = "data.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        while (true) {
            try {
                System.out.println("1) Load");
                System.out.println("2) Create Bases");
                System.out.println("3) Save");
                System.out.println("4) Print Bases");

                System.out.println("0) Exit");
                System.out.println("====================");

                Scanner in = new Scanner(System.in);
                String s = in.nextLine();

                switch (s) {
                    case "1" -> loadExtents();
                    case "2" -> createBases();
                    case "3" -> saveExtents();
                    case "4" -> printBases();
                    case "0" -> System.exit(0);
                    default -> System.out.println("Unkown option " + s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void createBases() throws Exception {

        Set<String> branches1 = new HashSet<String>();
        branches1.add("3rd Regiment for Radioelectronic Jamming");
        branches1.add("3rd Missile Air Defence Battalion");
        branches1.add("1st Air Cavalry Unit");
        new Base(
                "Warsaw Air Base",
                4.0,
                new Localization(
                        "Mazowsze",
                        32,
                        50
                ),
                "Patriot Missle Long-Range Air-Defence System",
                branches1,
                LocalDate.now()
        );

        Set<String> branches2 = new HashSet<String>();
        branches2.add("4th Regiment for Radar Detection");
        branches2.add("13th Helicopter Air Regiment");
        new Base(
                "Zbożów Air Base",
                1.5,
                new Localization(
                        "Lubuskie",
                        5513,
                        3213
                ),
                null,
                branches2,
                LocalDate.now()
        );
    }

    private static void saveExtents() throws FileNotFoundException, IOException {
        var stream = new ObjectOutputStream(new FileOutputStream(fileName));

        Base.saveExtent(stream);
    }

    private static void loadExtents() throws FileNotFoundException, IOException, ClassNotFoundException {
        var stream = new ObjectInputStream(new FileInputStream(fileName));

        Base.loadExtent(stream);
    }

    private static void printBases() throws ClassNotFoundException {
        for (var base: Base.getExtent()) {
            System.out.println(base);
            System.out.println("==========================");
        }
    }
}