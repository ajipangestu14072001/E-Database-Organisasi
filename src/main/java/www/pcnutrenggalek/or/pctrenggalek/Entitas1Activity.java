package www.pcnutrenggalek.or.pctrenggalek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Entitas1Activity extends AppCompatActivity {
    Button next;
    TextInputEditText text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12,text13;
    TextInputLayout tl1,tl2,tl3,tl4,tl5,tl6,tl7,tl8,tl9,tl10,tl11,tl12,tl13;
    NavigationView navigasi;
    private FirebaseAuth auth1;
    private FirebaseAuth.AuthStateListener authListener1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entitas1);
        tl1 = findViewById(R.id.tl1);
        tl2 = findViewById(R.id.tl2);
        tl3 = findViewById(R.id.tl3);
        tl4 = findViewById(R.id.tl4);
        tl5 = findViewById(R.id.tl5);
        tl6 = findViewById(R.id.tl6);
        tl7 = findViewById(R.id.tl7);
        tl8 = findViewById(R.id.tl8);
        tl9 = findViewById(R.id.tl9);
        tl10 = findViewById(R.id.tl10);
        tl11 = findViewById(R.id.tl11);
        tl12 = findViewById(R.id.tl12);
        tl13 = findViewById(R.id.tl13);
        text1 = findViewById(R.id.namalengkap);
        text2 = findViewById(R.id.tempatlahir);
        text3 = findViewById(R.id.tanggallahir);
        text4 = findViewById(R.id.rtrwdusun);
        text5 = findViewById(R.id.desa);
        text6 = findViewById(R.id.kecamatan);
        text7 = findViewById(R.id.kabupaten);
        text8 = findViewById(R.id.provinsi);
        text9 = findViewById(R.id.golongandarah);
        text10 = findViewById(R.id.kodepos);
        text11 = findViewById(R.id.nik);
        text12 = findViewById(R.id.nomorhp);
        text13 = findViewById(R.id.alamatemail);
        next = findViewById(R.id.next1);
        NavigationView navigationView = (NavigationView) findViewById(R.id.mainNavigationView);
        this.navigasi = navigationView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.nav_dash) {
                    Intent intent = new Intent(Entitas1Activity.this, AnakCabangActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_akun) {
                    Intent intent = new Intent(Entitas1Activity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_panduan){
                    Intent intent = new Intent(Entitas1Activity.this, GuideActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_berita){
                    return false;
                } else if(itemId == R.id.nav_logout){
                    signOut();
                    return  false;
                } else if(itemId == R.id.nav_tentang){
                    Intent intent = new Intent(Entitas1Activity.this, AboutActivity.class);
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
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
                String data1 = text1.getText().toString();
                String data2 = text2.getText().toString();
                String data3 = text3.getText().toString();
                String data4 = text4.getText().toString();
                String data5 = text5.getText().toString();
                String data6 = text6.getText().toString();
                String data7 = text7.getText().toString();
                String data8 = text8.getText().toString();
                String data9 = text9.getText().toString();
                String data10 = text10.getText().toString();
                String data11 = text11.getText().toString();
                String data12 = text12.getText().toString();
                String data13 = text13.getText().toString();
                SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("data1", data1);
                editor.putString("data2", data2);
                editor.putString("data3", data3);
                editor.putString("data4", data4);
                editor.putString("data5", data5);
                editor.putString("data6", data6);
                editor.putString("data7", data7);
                editor.putString("data8", data8);
                editor.putString("data9", data9);
                editor.putString("data10", data10);
                editor.putString("data11", data11);
                editor.putString("data12", data12);
                editor.putString("data53",data13);
                editor.apply();

            }
        });
        auth1 = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener1 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(Entitas1Activity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        };
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Setelah Login Tidak Dapat Kembali", Toast.LENGTH_LONG).show();
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
    private void submitForm() {
        if (!validateName()) {
            return;
        }
        if (!validatetempat()) {
            return;
        }
        if (!validatetgl()) {
            return;
        }
        if (!validatertrw()) {
            return;
        }
        if (!validatedes()) {
            return;
        }
        if (!validatekec()) {
            return;
        }
        if (!validatekab()) {
            return;
        }
        if (!validateprov()) {
            return;
        }
        if (!validatedarah()) {
            return;
        }
        if (!validatepos()) {
            return;
        }
        if (!validatenik()) {
            return;
        }
        if (!validatehp()) {
            return;
        }
        if (!validatemail()){
            return;
        }
        Intent intent = new Intent(Entitas1Activity.this, Entitas2Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    private boolean validateName() {
        if (text1.getText().toString().trim().isEmpty()) {
            tl1.setError("Data Harus Lengkap");
            return false;
        } else {
            tl1.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatetempat() {
        if (text2.getText().toString().trim().isEmpty()) {
            tl2.setError("Data Harus Lengkap");
            return false;
        } else {
            tl2.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatetgl() {
        if (text3.getText().toString().trim().isEmpty()) {
            tl3.setError("Data Harus Lengkap");
            return false;
        } else {
            tl3.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatertrw() {
        if (text4.getText().toString().trim().isEmpty()) {
            tl4.setError("Data Harus Lengkap");
            return false;
        } else {
            tl4.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatedes() {
        if (text5.getText().toString().trim().isEmpty()) {
            tl5.setError("Data Harus Lengkap");
            return false;
        } else {
            tl5.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatekec() {
        if (text6.getText().toString().trim().isEmpty()) {
            tl6.setError("Data Harus Lengkap");
            return false;
        } else {
            tl6.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatekab() {
        if (text7.getText().toString().trim().isEmpty()) {
            tl7.setError("Data Harus Lengkap");
            return false;
        } else {
            tl7.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateprov() {
        if (text8.getText().toString().trim().isEmpty()) {
            tl8.setError("Data Harus Lengkap");
            return false;
        } else {
            tl8.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatedarah() {
        if (text9.getText().toString().trim().isEmpty()) {
            tl9.setError("Data Harus Lengkap");
            return false;
        } else {
            tl9.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatepos() {
        if (text10.getText().toString().trim().isEmpty()) {
            tl10.setError("Data Harus Lengkap");
            return false;
        } else {
            tl10.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatenik() {
        if (text11.getText().toString().trim().isEmpty()) {
            tl11.setError("Data Harus Lengkap");
            return false;
        } else {
            tl11.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatehp() {
        if (text12.getText().toString().trim().isEmpty()) {
            tl12.setError("Data Harus Lengkap");
            return false;
        } else {
            tl12.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatemail() {
        if (text13.getText().toString().trim().isEmpty()) {
            tl13.setError("Data Harus Lengkap");
            return false;
        } else {
            tl13.setErrorEnabled(false);
        }

        return true;
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