package ba.unsa.etf.rs.tutorijal5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldEmail;
    public TextField fldKorisnickoIme;
    public PasswordField fldLozinka;
    public Button btnDodaj;
    public Button btnKraj;
    public ListView<Korisnik> korisniciLista;

    private KorisniciModel model;

    public Controller(KorisniciModel model) {
        this.model = model;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        korisniciLista.setItems(model.getKorisnici());

        korisniciLista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnik, Korisnik t1) {
                model.setTrenutni(t1);
                korisniciLista.refresh();
            }
        });

        model.trenutniProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if(oldKorisnik != null) {
                fldIme.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                fldPrezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                fldEmail.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                fldKorisnickoIme.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());
                fldLozinka.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());
            }

            if(newKorisnik == null) {
                fldIme.textProperty().set("");
                fldPrezime.textProperty().set("");
                fldEmail.textProperty().set("");
                fldKorisnickoIme.textProperty().set("");
                fldLozinka.textProperty().set("");

            }else {
                fldIme.textProperty().bindBidirectional(newKorisnik.imeProperty());
                fldPrezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                fldEmail.textProperty().bindBidirectional(newKorisnik.emailProperty());
                fldKorisnickoIme.textProperty().bindBidirectional(newKorisnik.korisnickoImeProperty());
                fldLozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
            }
        });



    }

    public void actDodaj() {
        model.getKorisnici().add(new Korisnik("", "", "", "", ""));
        korisniciLista.getSelectionModel().selectLast();

    }
    public  void actKraj() {
        System.exit(0);
    }
}
