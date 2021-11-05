package www.pcnutrenggalek.or.pctrenggalek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.client.ChildEventListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class DatailActivity extends AppCompatActivity {
    TextView Namalengkap, Tempatlahir, Tanggallahir, RTRWdusun, Desa, Kecamatan, Kabupaten, Provinsi, Goldarah, Kodepos, Nik, Nomerhp, alamatemaill;
    TextView Namaayah, Pekerjaanayah, Namaibu, Pekerjaanibu, SDMI, SMP, SMA, S1, S2;
    TextView Keahlian1, Keahlian2, Prestasi1, Prestasi2, Prestasi3;
    TextView Penmakesta, Tahunmakesta, Nosermakesta, Penlakmud, Tahunlakmud, Noserlakmud, Penlakut, Tahunlakut, Noserlakut, Penlatin, Tahunlatin, Noserlatin;
    TextView Pendiklatama, Tahundiklatama, Noserdiklatama, Pendikladmad,Tahundiklatmad, Noserdiklatmad;
    TextView Penpelatihan1, Namapelatihan1, Tahunpelatihan1, Noserpelatihan1, Penpelatihan2, Namapelatihan2, Tahunpelatihan2, Noserprelatihan2;
    ImageView imageView;
    Button editdata, hapusdata;
    NavigationView navigasi;
    private FirebaseAuth auth1;
    private FirebaseAuth.AuthStateListener authListener1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datail);
        Namalengkap = findViewById(R.id.detailnamalengkap);
        Tempatlahir = findViewById(R.id.detailtempatlahirr);
        Tanggallahir = findViewById(R.id.detailtanggallahir);
        RTRWdusun = findViewById(R.id.detailkrtrw);
        Desa = findViewById(R.id.detaildesa);
        Kecamatan = findViewById(R.id.detailkecamatan);
        Kabupaten = findViewById(R.id.detailkabupaten);
        Provinsi = findViewById(R.id.detailpropinsi);
        Goldarah = findViewById(R.id.detailgolongandarah);
        Kodepos = findViewById(R.id.detailkodepos);
        Nik = findViewById(R.id.detailnik);
        Nomerhp = findViewById(R.id.detailnohp);
        alamatemaill = findViewById(R.id.detailemail);
        Namaayah = findViewById(R.id.detailnamaayah);
        Pekerjaanayah = findViewById(R.id.detailpekerjaanayah);
        Namaibu = findViewById(R.id.detailnamaibu);
        Pekerjaanibu = findViewById(R.id.detailpekerjaanibu);
        SDMI = findViewById(R.id.detailsdmi);
        SMP = findViewById(R.id.detailsmpmts);
        SMA = findViewById(R.id.detailsmasmk);
        S1 = findViewById(R.id.details1);
        S2 = findViewById(R.id.details2);;
        Keahlian1 = findViewById(R.id.detailkeahlian1);
        Keahlian2 = findViewById(R.id.detailkeahlian2);
        Prestasi1 = findViewById(R.id.detailprestasi);
        Prestasi2 = findViewById(R.id.detailprestasi2);
        Prestasi3 = findViewById(R.id.detailprestasi3);
        Penmakesta = findViewById(R.id.detailmakesta);
        Tahunmakesta = findViewById(R.id.detailtahunmakesta);
        Nosermakesta = findViewById(R.id.detailsertifikatmakesta);
        Penlakmud = findViewById(R.id.detaillakmud);
        Tahunlakmud = findViewById(R.id.detailtahunlakmud);
        Noserlakmud = findViewById(R.id.detailnosertifikatlakmud);
        Penlakut = findViewById(R.id.detaillakut);
        Tahunlakut = findViewById(R.id.detailtahunlakut);
        Noserlakut = findViewById(R.id.detailnosertifikatlakut);
        Penlatin = findViewById(R.id.detaillatinlatpel);
        Tahunlatin = findViewById(R.id.detailtahunlatinlatpel);
        Noserlatin = findViewById(R.id.detailnosertifikatlatinlatpel);
        Pendiklatama = findViewById(R.id.detaildiklatama);
        Tahundiklatama = findViewById(R.id.detailtahundiklatama);
        Noserdiklatama = findViewById(R.id.detailnosertifikatdiklatama);
        Pendikladmad = findViewById(R.id.detaildiklatmad);
        Tahundiklatmad = findViewById(R.id.detailtahundikatmad);
        Noserdiklatmad = findViewById(R.id.detailnosertifikatdiklatmad);
        Penpelatihan1 = findViewById(R.id.detailpelatihan1);
        Namapelatihan1 = findViewById(R.id.detailnamapelatihan);
        Tahunpelatihan1 = findViewById(R.id.detailtahunpelatihan1);
        Noserpelatihan1 = findViewById(R.id.detailnosertifikatpelatihan1);
        Penpelatihan2 = findViewById(R.id.detailpelatihan2);
        Namapelatihan2 = findViewById(R.id.detailnamapelatihan2);
        Tahunpelatihan2 = findViewById(R.id.detailtahunpelatihan2);
        Noserprelatihan2 = findViewById(R.id.detailnosertifikatpelatihan2);

        imageView = findViewById(R.id.imgview);
        hapusdata = findViewById(R.id.hapus);
        loadata();
        NavigationView navigationView = (NavigationView) findViewById(R.id.mainNavigationView);
        this.navigasi = navigationView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.nav_dash) {
                    Intent intent = new Intent(DatailActivity.this, AnakCabangActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_akun) {
                    Intent intent = new Intent(DatailActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_panduan){
                    Intent intent = new Intent(DatailActivity.this, GuideActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_berita){
                    return false;
                } else if(itemId == R.id.nav_logout){
                    signOut();
                    return  false;
                } else if(itemId == R.id.nav_tentang){
                    Intent intent = new Intent(DatailActivity.this, AboutActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return  false;
                } else if(itemId == R.id.nav_share){
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBodyText = "Link";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
                    return false;
                } else if(itemId == R.id.nav_bug){
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + "+6281345602416" + "&text=" + "Hi Developer "));
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return false;
                }
                else {
                    return false;
                }
            }
        });
        hapusdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                String datapac =  sharedPac.getString("PAC","").trim();
                SharedPreferences sharedPref3 = getSharedPreferences("ipnukey", MODE_PRIVATE);
                String LP =  sharedPref3.getString("LP","").trim();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.child(datapac).child(LP).orderByChild("a3_namalengkap").equalTo(Namalengkap.getText().toString());
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                            Toast.makeText(getApplicationContext(),"Data Berhasil di Hapus",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(DatailActivity.this, ShowActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled", databaseError.toException());
                    }
                });
            }
        });
        auth1 = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener1 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(DatailActivity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        };
    }
    public  void loadata(){
        String string = getIntent().getExtras().getString("Photo");
        Namalengkap.setText(getIntent().getStringExtra("Nama"));
        Tempatlahir.setText(getIntent().getStringExtra("Tanggal"));
        Tanggallahir.setText(getIntent().getStringExtra("Tempat"));
        RTRWdusun.setText(getIntent().getStringExtra("RTRW"));
        Desa.setText(getIntent().getStringExtra("Desa"));
        Kecamatan.setText(getIntent().getStringExtra("Kecamatan"));
        Kabupaten.setText(getIntent().getStringExtra("Kabupaten"));
        Provinsi.setText(getIntent().getStringExtra("Provinsi"));
        Goldarah.setText(getIntent().getStringExtra("GolonganDarah"));
        Kodepos.setText(getIntent().getStringExtra("KodePos"));
        Nik.setText(getIntent().getStringExtra("NIK"));
        Nomerhp.setText(getIntent().getStringExtra("NomorHP"));
        alamatemaill.setText(getIntent().getStringExtra("alamatemail"));
        Namaayah.setText(getIntent().getStringExtra("NamaAyah"));
        Pekerjaanayah.setText(getIntent().getStringExtra("PekerjaanAyah"));
        Namaibu.setText(getIntent().getStringExtra("NamaIbu"));
        Pekerjaanibu.setText(getIntent().getStringExtra("PekerjaanIbu"));
        SDMI.setText(getIntent().getStringExtra("SDMI"));
        SMP.setText(getIntent().getStringExtra("SMP"));
        SMA.setText(getIntent().getStringExtra("SMA"));
        S1.setText(getIntent().getStringExtra("S1"));
        S2.setText(getIntent().getStringExtra("S2"));
        Keahlian1.setText(getIntent().getStringExtra("Keahlian1"));
        Keahlian2.setText(getIntent().getStringExtra("Keahlian2"));
        Prestasi1.setText(getIntent().getStringExtra("Prestasi1"));
        Prestasi2.setText(getIntent().getStringExtra("Prestasi2"));
        Prestasi3.setText(getIntent().getStringExtra("Prestasi3"));
        Penmakesta.setText(getIntent().getStringExtra("Penmakesta"));
        Tahunmakesta.setText(getIntent().getStringExtra("Tahunmakesta"));
        Nosermakesta.setText(getIntent().getStringExtra("Nosertifikatmakesta"));
        Penlakmud.setText(getIntent().getStringExtra("Penlakmud"));
        Tahunlakmud.setText(getIntent().getStringExtra("Tahunlakmud"));
        Noserlakmud.setText(getIntent().getStringExtra("Nosertifikatlakmud"));
        Penlakut.setText(getIntent().getStringExtra("Penlakut"));
        Tahunlakut.setText(getIntent().getStringExtra("Tahunlakut"));
        Noserlakut.setText(getIntent().getStringExtra("Nosertifikatlakut"));
        Penlatin.setText(getIntent().getStringExtra("Latin"));
        Tahunlatin.setText(getIntent().getStringExtra("Tahunlatin"));
        Noserlatin.setText(getIntent().getStringExtra("Nosertifikatlatin"));
        Pendiklatama.setText(getIntent().getStringExtra("PenDiklatama"));
        Tahundiklatama.setText(getIntent().getStringExtra("Tahundiklatama"));
        Noserdiklatama.setText(getIntent().getStringExtra("Nosertifikatdiklatama"));
        Pendikladmad.setText(getIntent().getStringExtra("Pendiklatmad"));
        Tahundiklatmad.setText(getIntent().getStringExtra("Tahundiklatmad"));
        Noserdiklatmad.setText(getIntent().getStringExtra("Nosertifikatdiklatmad"));
        Penpelatihan1.setText(getIntent().getStringExtra("Penpelatihan1"));
        Namapelatihan1.setText(getIntent().getStringExtra("Namapelatihan1"));
        Tahunpelatihan1.setText(getIntent().getStringExtra("Tahunpelatihan1"));
        Noserpelatihan1.setText(getIntent().getStringExtra("Nosertifikatpelatihan1"));
        Penpelatihan2.setText(getIntent().getStringExtra("Penpelatihan2"));
        Namapelatihan2.setText(getIntent().getStringExtra("Namapelatihan2"));
        Tahunpelatihan2.setText(getIntent().getStringExtra("Tahunpelatihan2"));
        Noserprelatihan2.setText(getIntent().getStringExtra("Nosertifikatpelatihan2"));



        Glide.with(getApplicationContext()).load(string).into(this.imageView);

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideSystemUI(getWindow());
    }

    public static void hideSystemUI(Window window) {
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        );
    }
    public void signOut() {
        auth1.signOut();
    }
    @Override
    public void onStart() {
        super.onStart();
        auth1.addAuthStateListener(authListener1);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener1 != null) {
            auth1.removeAuthStateListener(authListener1);
        }
    }
}