package OV.Domein;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "OVChipkaart")
public class OVChipkaart {

    @Id
    @Column(name = "kaartnummer")
    private int kaartnummer;

    @Column(name="geldige_tot")
    private Date geldige_tot;

    @Column(name = "klasse")
    private int klasse;

    @Column(name = "saldo")
    private double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reiziger_id", nullable = false)
    private Reiziger reiziger;

    public OVChipkaart() {}

    public OVChipkaart(int kaartnummer, Date geldige_tot, int klasse, double saldo) {
        this.kaartnummer = kaartnummer;
        this.geldige_tot = geldige_tot;
        this.klasse = klasse;
        this.saldo = saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public int getKaartnummer() {
        return kaartnummer;
    }

    public void setKaartnummer(int kaartnummer) {
        this.kaartnummer = kaartnummer;
    }

    public Date getGeldige_tot() {
        return geldige_tot;
    }

    public void setGeldige_tot(Date geldige_tot) {
        this.geldige_tot = geldige_tot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return String.format("OVChipkaart {kaartnummer=%d, geldig tot=%s, klasse=%d, saldo=%.2f}",
                kaartnummer, geldige_tot, klasse, saldo);
    }
}



