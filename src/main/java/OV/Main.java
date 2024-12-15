// Main.java
package OV;

import OV.DAO.ReizigerDAO;
import OV.DAO.OVChipkaartDAO;
import OV.DAO.ReizigerDAOHibernate;
import OV.DAO.OVChipkaartDAOHibernate;
import OV.Domein.Reiziger;
import OV.Domein.OVChipkaart;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ReizigerDAO reizigerDAO = new ReizigerDAOHibernate();
        OVChipkaartDAO ovChipkaartDAO = new OVChipkaartDAOHibernate();


        System.out.println("Test 1: Save");
        Reiziger reiziger1 = new Reiziger(0, "A", "de", "Boer", Date.valueOf("1985-03-15"));
        OVChipkaart chipkaart1 = new OVChipkaart(12345, Date.valueOf("2025-12-31"), 2, 50.0);
        reiziger1.addOVChipkaart(chipkaart1);
        reizigerDAO.save(reiziger1);
        int generatedId = reiziger1.getId();

        System.out.println("Test 2: Retrieve and Display");
        Reiziger retrievedReiziger = reizigerDAO.findById(generatedId);
        if (retrievedReiziger != null) {
            System.out.println(retrievedReiziger);


            if (retrievedReiziger.getOvChipkaarts().isEmpty()) {
                System.out.println("Geen OVChipkaarten gevonden.");
            } else {
                System.out.println("OVChipkaarten:");
                retrievedReiziger.getOvChipkaarts().forEach(System.out::println);
            }


            System.out.println("Test 3: Update");
            retrievedReiziger.setAchternaam("Jansen");
            if (!retrievedReiziger.getOvChipkaarts().isEmpty()) {
                retrievedReiziger.getOvChipkaarts().get(0).setSaldo(75.0);
            }
            reizigerDAO.update(retrievedReiziger);
        } else {
            System.out.println("Reiziger met ID " + generatedId + " niet gevonden.");
        }


        System.out.println("Test 4: Ophalen");
        List<Reiziger> allReizigers = reizigerDAO.findAll();
        allReizigers.forEach(System.out::println);


        System.out.println("Test 5: Delete");
        if (retrievedReiziger != null) {
            reizigerDAO.delete(retrievedReiziger);
        }


        System.out.println("Verwijderd");
        List<Reiziger> remainingReizigers = reizigerDAO.findAll();
        System.out.println(" Reizigers: " + remainingReizigers.size());
    }
}
