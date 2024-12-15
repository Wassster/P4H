package OV.Domein;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "OVChipkaart")
public class OVChipkaart {

    @Id
    @Column(name = "kaartnummer")
    public int kaartnummer;

    @Column(name="geldige_tot")
    public Date geldige_tot;

    @Column(name = "klasse")
    public int klasse;

    @Column(name = "saldo")
    public double saldo;

    @ManyToOne
    @JoinColumn(name = "reiziger_id", nullable = false)
    private Reiziger reiziger;

    public OVChipkaart() {

    }

    public OVChipkaart(int kaartnummer, Date geldige_tot, int klasse, int saldo) {
        this.kaartnummer = kaartnummer;
        this.geldige_tot = geldige_tot;
        this.klasse = klasse;
        this.saldo = saldo;

    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public Date getGeldige_tot() {
        return geldige_tot;
    }

    public int getKaartnummer() {
        return kaartnummer;
    }

    public int getKlasse() {
        return klasse;
    }

    public double getSaldo() {
        return saldo;
    }


    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public void setGeldige_tot(Date geldige_tot) {
        this.geldige_tot = geldige_tot;
    }

    public void setKaartnummer(int kaartnummer) {
        this.kaartnummer = kaartnummer;
    }
    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
