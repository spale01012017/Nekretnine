package com.example.androiddevelopment.agencija;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.RatingBar;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import model.Helper;
import model.Nekretnina;

/**
 * Created by androiddevelopment on 24.6.17..
 */

public class Druga extends AppCompatActivity {
    private Helper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.druga);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        int key = getIntent().getExtras().getInt(MainActivity.KEY);

        try {
            Nekretnina a = getDatabaseHelper().getmNekretninaDao().queryForId(key);

            EditText naziv = (EditText) findViewById(R.id.naziv);
            EditText opis = (EditText) findViewById(R.id.opis);
            EditText slika = (EditText) findViewById(R.id.slika);
            EditText adresa = (EditText) findViewById(R.id.adresa);
            EditText tel = (EditText) findViewById(R.id.tel);
            EditText kvad = (EditText) findViewById(R.id.kvadratura);
            EditText bs = (EditText) findViewById(R.id.bs);
            EditText cena = (EditText) findViewById(R.id.cena);

            naziv.setText(a.getmNaziv());
            opis.setText(a.getmOpis());
            slika.setText(a.getmSlika());
            adresa.setText(a.getmSlika());
            tel.setText(a.getmTelefon());
            kvad.setText(a.getmKvadratura());
            bs.setText(a.getmBrojsoba());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Helper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, Helper.class);
        }
        return databaseHelper;
    }
}
