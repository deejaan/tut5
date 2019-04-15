package ba.unsa.etf.rs.tutorijal5;

import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutni = new SimpleObjectProperty<>();

    public void napuni() {
        korisnici.add(new Korisnik("Dejan", "Popovic", "dpopovic1@etf.unsa.ba", "username", "lozinka"));
        korisnici.add(new Korisnik("Djjn", "Pppp", "dpopovic2@etf.unsa.ba", "username2", "lozinka"));
        trenutni.set(korisnici.get(0));
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutni() {
        return trenutni.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniProperty() {
        return trenutni;
    }

    public void setTrenutni(Korisnik trenutni) {
        this.trenutni.set(trenutni);
    }
}
