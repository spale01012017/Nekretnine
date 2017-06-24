package com.example.androiddevelopment.agencija;

import android.app.Dialog;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.List;

import model.Helper;
import model.Nekretnina;

public class MainActivity extends AppCompatActivity {
    private Helper databaseHelper;
    public static String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }



        final ListView listView = (ListView) findViewById(R.id.main);

        try {
            List<Nekretnina> list = getDatabaseHelper().getmNekretninaDao().queryForAll();

            ListAdapter adapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_item, list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Nekretnina n = (Nekretnina) listView.getItemAtPosition(position);

                    Intent intent = new Intent(MainActivity.this, Druga.class);
                    intent.putExtra(KEY, n.getmId());
                    startActivity(intent);
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();

    }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.dodavanje:

                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.nekretnina);

                Button add = (Button) dialog.findViewById(R.id.add);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText ime = (EditText) dialog.findViewById(R.id.name);
                        EditText opis = (EditText) dialog.findViewById(R.id.opis);
                        EditText slika = (EditText) dialog.findViewById(R.id.slika);
                        EditText adresa= (EditText) dialog.findViewById(R.id.adresa);
                        EditText tel= (EditText) dialog.findViewById(R.id.tel);
                        EditText kvadratura= (EditText) dialog.findViewById(R.id.kvad);
                        EditText sobe= (EditText) dialog.findViewById(R.id.sobe);
                        EditText cena= (EditText) dialog.findViewById(R.id.cena);




                        Nekretnina a = new Nekretnina();
                        a.setmNaziv(ime.getText().toString());
                        a.setmOpis(opis.getText().toString());
                        a.setmSlika(slika.getText().toString());
                        a.setmAdresa(adresa.getText().toString());
                        a.setmTelefon(tel.getBottom());
                        a.setmKvadratura(kvadratura.getBottom());
                        a.setmBrojsoba(sobe.getBottom());
                        a.setmCena(cena.getBottom());


                        try {
                            getDatabaseHelper().getmNekretninaDao().create(a);

                            //provera podesenja


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        dialog.dismiss();

                    }
                });

                dialog.show();

                break;
           /* case R.id.priprema_about:

                AlertDialog alertDialog = new AboutDialog(this).prepareDialog();
                alertDialog.show();
                break;
            case R.id.priprema_preferences:
                startActivity(new Intent(PripremaListActivity.this, PripremaPrefererences.class));
                break;*/
        }

        return super.onOptionsItemSelected(item);
    }

    public Helper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, Helper.class);
        }
        return databaseHelper;
    }

}

