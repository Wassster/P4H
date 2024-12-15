package OV;

import OV.DAO.ReizigerDAO;
import OV.DAO.ReizigerDAOHibernate;
import OV.Domein.OVChipkaart;
import OV.Domein.Reiziger;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        ReizigerDAO reizigerDAO = new ReizigerDAOHibernate();


        Reiziger reiziger = new Reiziger(0, "J", "van", "Dijk", Date.valueOf("1990-01-01"));
        OVChipkaart ovChipkaart = new OVChipkaart(12345, Date.valueOf("2025-12-31"), 2, 50);
        reiziger.addOVChipkaart(ovChipkaart);
        ovChipkaart.setReiziger(reiziger);


        reizigerDAO.save(reiziger);


        Reiziger retrievedReiziger = reizigerDAO.findById(1);
        System.out.println(retrievedReiziger);
    }
}

