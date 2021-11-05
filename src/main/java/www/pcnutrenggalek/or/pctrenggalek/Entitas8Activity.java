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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Entitas8Activity extends AppCompatActivity {
    Button next, back;
    TextInputEditText text1, text2, text3, text4, text5, text6, text7, text8;
    NavigationView navigasi;
    private FirebaseAuth auth1;
    private FirebaseAuth.AuthStateListener authListener1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entitas8);
        text1 = findViewById(R.id.penyelenggarapelatihan);
        text2 = findViewById(R.id.namapelatihan);
        text3 = findViewById(R.id.tahunpelatihan);
        text4 = findViewById(R.id.nomorsertiikatpelatihan);
        text5 = findViewById(R.id.penyelenggarapelatihan2);
        text6 = findViewById(R.id.namapelatihan2);
        text7 = findViewById(R.id.tahunpelatihan2);
        text8 = findViewById(R.id.nomorsertiikatpelatihan2);
        next = findViewById(R.id.next8);
        back = findViewById(R.id.back8);
        NavigationView navigationView = (NavigationView) findViewById(R.id.mainNavigationView);
        this.navigasi = navigationView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.nav_dash) {
                    Intent intent = new Intent(Entitas8Activity.this, AnakCabangActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_akun) {
                    Intent intent = new Intent(Entitas8Activity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_panduan){
                    Intent intent = new Intent(Entitas8Activity.this, GuideActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_berita){
                    return false;
                } else if(itemId == R.id.nav_logout){
                    signOut();
                    return  false;
                } else if(itemId == R.id.nav_tentang){
                    Intent intent = new Intent(Entitas8Activity.this, AboutActivity.class);
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
                Intent intent = new Intent(Entitas8Activity.this, Entitas7Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data45 = text1.getText().toString();
                String data46 = text2.getText().toString();
                String data47 = text3.getText().toString();
                String data48 = text4.getText().toString();
                String data49 = text5.getText().toString();
                String data50 = text6.getText().toString();
                String data51 = text7.getText().toString();
                String data52 = text8.getText().toString();
                SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("data45", data45);
                editor.putString("data46", data46);
                editor.putString("data47", data47);
                editor.putString("data48", data48);
                editor.putString("data49", data49);
                editor.putString("data50", data50);
                editor.putString("data51",data51);
                editor.putString("data52",data52);
                editor.apply();
                Intent intent = new Intent(Entitas8Activity.this, Entitas9Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        auth1 = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener1 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(Entitas8Activity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        };
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Entitas8Activity.this, Entitas1Activity.class);
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