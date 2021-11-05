package www.pcnutrenggalek.or.pctrenggalek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class AnakCabangActivity extends AppCompatActivity {
    ImageView greetImg;
    TextView greetText;
    NavigationView navigasi;
    private FirebaseAuth auth1;
    private FirebaseAuth.AuthStateListener authListener1;
    RelativeLayout relativeLayout1, relativeLayout2, relativeLayout3;
    CardView cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9, cardView10, cardView11, cardView12, cardView13, cardView14, cardView15,cardView16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anak_cabang);
        greetImg = findViewById(R.id.greeting_img);
        greetText = findViewById(R.id.greeting_text);
        relativeLayout3 =findViewById(R.id.r3);
        cardView2 = findViewById(R.id.car2);
        cardView3 =findViewById(R.id.car3);
        cardView4 = findViewById(R.id.car4);
        cardView5 = findViewById(R.id.car5);
        cardView6 = findViewById(R.id.car6);
        cardView7 = findViewById(R.id.car7);
        cardView8 = findViewById(R.id.car8);
        cardView9 = findViewById(R.id.car9);
        cardView10 = findViewById(R.id.car10);
        cardView11 = findViewById(R.id.car11);
        cardView12 = findViewById(R.id.car12);
        cardView13 = findViewById(R.id.car13);
        cardView14 = findViewById(R.id.car14);
        cardView15 = findViewById(R.id.car15);
        cardView16 = findViewById(R.id.car16);
        relativeLayout1 = findViewById(R.id.r1);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, GuideActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.mainNavigationView);
        this.navigasi = navigationView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            /* class bpbd.trenggalekkab.go.id.MainActivity.AnonymousClass1 */

            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.nav_dash) {
                    finish();
                    startActivity(getIntent());
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_akun) {
                    Intent intent = new Intent(AnakCabangActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_panduan){
                    Intent intent = new Intent(AnakCabangActivity.this, GuideActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_berita){
                    return false;
                } else if(itemId == R.id.nav_logout){
                    signOut();
                    return  false;
                } else if(itemId == R.id.nav_tentang){
                    Intent intent = new Intent(AnakCabangActivity.this, AboutActivity.class);
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

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac1 ="PAC_Watulimo";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac1);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac2 ="PAC_Panggul";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac2);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac3 = "PAC_Durenan";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac3);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac4 = "PAC_Kampak";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac4);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac5 = "PAC_Pule";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac5);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac6 = "PAC_Gandusari";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac6);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac7 = "PAC_Munjungan";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac7);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac8 = "PAC_Trenggalek";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac8);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac9 = "PAC_Bendungan";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac9);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac10 = "PAC_Dongko";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac10);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac11 = "PAC_Pogalan";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac11);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac12 = "PAC_Karangan";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac12);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac13 = "PAC_Suruh";
                SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac13);
                editor.apply();
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, OtpActivity.class);
                String pac14 = "PAC_Tugu"; SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPac.edit();
                editor.putString("PAC", pac14);
                editor.apply();intent.putExtra("PAC",pac14);
                startActivity(intent);
            }
        });
        cardView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnakCabangActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        greeting();
        auth1 = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener1 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(AnakCabangActivity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        };
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
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
    @SuppressLint("SetTextI18n")
    private void greeting() {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12){
            greetText.setText("Selamat Pagi\nRekan & Rekanita");
            greetImg.setImageResource(R.drawable.img_default_half_morning);
        } else if (timeOfDay >= 12 && timeOfDay < 15) {
            greetText.setText("Selamat Siang\nRekan & Rekanita");
            greetImg.setImageResource(R.drawable.img_default_half_afternoon);
        } else if (timeOfDay >= 15 && timeOfDay < 18) {
            greetText.setText("Selamat Sore\nRekan & Rekanita");
            greetImg.setImageResource(R.drawable.img_default_half_without_sun);
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            greetText.setText("Selamat Malam\nRekan & Rekanita");
            greetText.setTextColor(Color.WHITE);
            greetImg.setImageResource(R.drawable.img_default_half_night);
        }
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

}