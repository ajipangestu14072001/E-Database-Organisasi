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

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Entitas4Activity extends AppCompatActivity {
    Button next, back;
    TextInputEditText text1, text2, text3, text4, text5;
    TextInputLayout tl21, tl22;
    NavigationView navigasi;
    private FirebaseAuth auth1;
    private FirebaseAuth.AuthStateListener authListener1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entitas4);
        tl21 = findViewById(R.id.tl21);
        tl22 = findViewById(R.id.tl22);
        text1 = findViewById(R.id.keahlian1);
        text2 = findViewById(R.id.keahlian2);
        text3 = findViewById(R.id.prestasi1);
        text4 = findViewById(R.id.prestasi2);
        text5 = findViewById(R.id.prestasi3);
        next =findViewById(R.id.next4);
        back = findViewById(R.id.back4);
        NavigationView navigationView = (NavigationView) findViewById(R.id.mainNavigationView);
        this.navigasi = navigationView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.nav_dash) {
                    Intent intent = new Intent(Entitas4Activity.this, AnakCabangActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_akun) {
                    Intent intent = new Intent(Entitas4Activity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_panduan){
                    Intent intent = new Intent(Entitas4Activity.this, GuideActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_berita){
                    return false;
                } else if(itemId == R.id.nav_logout){
                    signOut();
                    return  false;
                } else if(itemId == R.id.nav_tentang){
                    Intent intent = new Intent(Entitas4Activity.this, AboutActivity.class);
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entitas4Activity.this, Entitas3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
                String data22 = text1.getText().toString();
                String data23 = text2.getText().toString();
                String data24 = text3.getText().toString();
                String data25 = text4.getText().toString();
                String data26 = text5.getText().toString();
                SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("data22", data22);
                editor.putString("data23", data23);
                editor.putString("data24", data24);
                editor.putString("data25", data25);
                editor.putString("data26",data26);
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
                    startActivity(new Intent(Entitas4Activity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        };
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Entitas4Activity.this, Entitas1Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
        if (!validatekeahlian1()) {
            return;
        }
        if (!validatekeahlian2()) {
            return;
        }
        Intent intent = new Intent(Entitas4Activity.this, Entitas5Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    private boolean validatekeahlian1() {
        if (text1.getText().toString().trim().isEmpty()) {
            tl21.setError("Data Harus Lengkap");
            return false;
        } else {
            tl21.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatekeahlian2() {
        if (text2.getText().toString().trim().isEmpty()) {
            tl22.setError("Data Harus Lengkap");
            return false;
        } else {
            tl22.setErrorEnabled(false);
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