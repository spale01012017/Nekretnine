package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 24.6.17..
 */
@DatabaseTable(tableName = Nekretnina.TABLE_NAME_USERS)
public class Nekretnina {
    public static final String TABLE_NAME_USERS = "nekretnina";
    public static final String FIELD_NAME_ID     = "id";
    public static final String TABLE_NAZIV = "naziv";
    public static final String TABLE_OPIS= "opis";
    public static final String TABLE_SLIKA= "slika";
    public static final String TABLE_ADRESA= "adresa";
    public static final String TABLE_TEL= "telefon";
    public static final String TABLE_KVADRATURA= "kvadratura";
    public static final String TABLE_BROJ_SOBA= "broj soba";
    public static final String TABLE_CENA= "cena";



    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = TABLE_NAZIV)
    private String mNaziv;

    @DatabaseField(columnName = TABLE_OPIS)
    private String mOpis;

    @DatabaseField(columnName = TABLE_SLIKA)
    private String mSlika;

    @DatabaseField(columnName = TABLE_ADRESA)
    private String mAdresa;

    @DatabaseField(columnName = TABLE_TEL)
    private int mTelefon;

    @DatabaseField(columnName = TABLE_KVADRATURA)
    private int mKvadratura;

    @DatabaseField(columnName = TABLE_BROJ_SOBA)
    private int mBrojsoba;

    @DatabaseField(columnName = TABLE_CENA)
    private float mCena;


    public Nekretnina() {
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmNaziv() {
        return mNaziv;
    }

    public void setmNaziv(String mNaziv) {
        this.mNaziv = mNaziv;
    }

    public String getmOpis() {
        return mOpis;
    }

    public void setmOpis(String mOpis) {
        this.mOpis = mOpis;
    }

    public String getmSlika() {
        return mSlika;
    }

    public void setmSlika(String mSlika) {
        this.mSlika = mSlika;
    }

    public String getmAdresa() {
        return mAdresa;
    }

    public void setmAdresa(String mAdresa) {
        this.mAdresa = mAdresa;
    }

    public int getmTelefon() {
        return mTelefon;
    }

    public void setmTelefon(int mTelefon) {
        this.mTelefon = mTelefon;
    }

    public int getmKvadratura() {
        return mKvadratura;
    }

    public void setmKvadratura(int mKvadratura) {
        this.mKvadratura = mKvadratura;
    }

    public int getmBrojsoba() {
        return mBrojsoba;
    }

    public void setmBrojsoba(int mBrojsoba) {
        this.mBrojsoba = mBrojsoba;
    }

    public float getmCena() {
        return mCena;
    }

    public void setmCena(float mCena) {
        this.mCena = mCena;
    }

    @Override
    public String toString() {
        return "Nekretnina{" +
                "mId=" + mId +
                ", mNaziv='" + mNaziv + '\'' +
                ", mOpis='" + mOpis + '\'' +
                ", mSlika='" + mSlika + '\'' +
                ", mAdresa='" + mAdresa + '\'' +
                ", mTelefon=" + mTelefon +
                ", mKvadratura=" + mKvadratura +
                ", mBrojsoba=" + mBrojsoba +
                ", mCena=" + mCena +
                '}';
    }
}




