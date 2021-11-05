package www.pcnutrenggalek.or.pctrenggalek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AboutActivity extends AppCompatActivity {
    NavigationView navigasi;
    TextView fbipnu, fbipp, twipnu, twipp, igipnu, igipp, ytipnu, ytipp;
    private FirebaseAuth auth1;
    private FirebaseAuth.AuthStateListener authListener1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        fbipnu = findViewById(R.id.fbipnu);
        fbipp = findViewById(R.id.fbippnu);
        twipnu = findViewById(R.id.twipnu);
        twipp = findViewById(R.id.twippnu);
        igipnu = findViewById(R.id.igipnu);
        igipp = findViewById(R.id.igippnu);
        ytipnu = findViewById(R.id.ytipnu);
        ytipp = findViewById(R.id.ytippnu);

        fbipnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook();
            }
        });
        fbipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebookipp();
            }
        });
        twipnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwitter();
            }
        });
        twipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwitteripp();
            }
        });
        igipnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIG();
            }
        });
        igipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIGipp();
            }
        });
        ytipnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYoutube();
            }
        });
        ytipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYoutubeipp();
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.mainNavigationView);
        this.navigasi = navigationView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.nav_dash) {
                    Intent intent = new Intent(AboutActivity.this, AnakCabangActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_akun) {
                    Intent intent = new Intent(AboutActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_panduan){
                    return false;
                } else if (itemId == R.id.nav_berita){
                    return false;
                } else if(itemId == R.id.nav_logout){
                    signOut();
                    return  false;
                } else if(itemId == R.id.nav_tentang){
                    finish();
                    startActivity(getIntent());
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
        auth1 = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener1 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(AboutActivity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        };
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
    public void openIG() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/pc.ipnu_trenggalek"));
        intent.setPackage("com.instagram.android");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/pc.ipnu_trenggalek")));
        }
    }
    public void openIGipp() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/pcippnutrenggalek"));
        intent.setPackage("com.instagram.android");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/pcippnutrenggalek")));
        }
    }

    public void openTwitter() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/ipnutrenggalek"));
        intent.setPackage("com.twitter.android");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/ipnutrenggalek")));
        }
    }
    public void openTwitteripp() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/ippnutrenggalek"));
        intent.setPackage("com.twitter.android");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/ippnutrenggalek")));
        }
    }

    public void openFacebook() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/IpnuTrenggalek"));
        intent.setPackage("com.facebook.katana");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/IpnuTrenggalek")));
        }
    }
    public void openFacebookipp() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/pcippnutrenggalek"));
        intent.setPackage("com.facebook.katana");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/pcippnutrenggalek")));
        }
    }

    public void openYoutube() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/channel/UCCEuF9bCyzUTFIxBJ7a1OVQ"));
        intent.setPackage("com.google.android.youtube");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/channel/UCCEuF9bCyzUTFIxBJ7a1OVQ")));
        }
    }
    public void openYoutubeipp() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/channel/UCtCYDO35U7vvZI3inEzWOnA"));
        intent.setPackage("com.google.android.youtube");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/channel/UCtCYDO35U7vvZI3inEzWOnA")));
        }
    }

}