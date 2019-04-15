package ba.unsa.etf.rs.tutorijal5;

import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    ObservableList<String> korisnici = FXCollections.observableArrayList();
    SimpleObjectProperty<String> trenutni = new SimpleObjectProperty<>();

    public ObservableList<String> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<String> korisnici) {
        this.korisnici = korisnici;
    }

    public String getTrenutni() {
        return trenutni.get();
    }

    public SimpleObjectProperty<String> trenutniProperty() {
        return trenutni;
    }

    public void setTrenutni(String trenutni) {
        this.trenutni.set(trenutni);
    }
}
