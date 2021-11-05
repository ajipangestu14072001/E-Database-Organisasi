package www.pcnutrenggalek.or.pctrenggalek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.Objects;

public class Entitas9Activity extends AppCompatActivity {
    String Database_Path;
    Button galery,uploaddata,show;
    int Image_Request_Code = 7;
    Uri FilePathUri;
    ImageView imageView;
    ProgressDialog progressDialog;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    NavigationView navigasi;
    private FirebaseAuth auth1;
    private FirebaseAuth.AuthStateListener authListener1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entitas9);
        SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
        String datapac =  sharedPac.getString("PAC","").trim();
        Toast.makeText(getApplicationContext(),datapac,Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref3 = getSharedPreferences("ipnukey", MODE_PRIVATE);
        String LP =  sharedPref3.getString("LP","").trim();
        Database_Path = datapac;
        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path).child(LP);
        storageReference = FirebaseStorage.getInstance().getReference();
        galery = findViewById(R.id.pilih);
        imageView = findViewById(R.id.imgview);
        uploaddata = findViewById(R.id.upload);
        progressDialog = new ProgressDialog(this);
        show = findViewById(R.id.show);
        NavigationView navigationView = (NavigationView) findViewById(R.id.mainNavigationView);
        this.navigasi = navigationView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.nav_dash) {
                    Intent intent = new Intent(Entitas9Activity.this, AnakCabangActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_akun) {
                    Intent intent = new Intent(Entitas9Activity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_panduan){
                    Intent intent = new Intent(Entitas9Activity.this, GuideActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return false;
                } else if (itemId == R.id.nav_berita){
                    return false;
                } else if(itemId == R.id.nav_logout){
                    Intent intent = new Intent(Entitas9Activity.this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return  false;
                } else if(itemId == R.id.nav_tentang){
                    Intent intent = new Intent(Entitas9Activity.this, AboutActivity.class);
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
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entitas9Activity.this, ShowActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        galery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, Image_Request_Code);
                // Toast.makeText(getApplicationContext(),data1+data2+data3+data4,Toast.LENGTH_SHORT).show();
            }
        });

        uploaddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadImageFileToFirebaseStorage();
            }
        });
    }
    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == Image_Request_Code && i2 == Activity.RESULT_OK && intent != null && intent.getData() != null) {
            FilePathUri = intent.getData();
            try {
                imageView.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

    }
    public String GetFileExtension(Uri uri) {
        ContentResolver c = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(c.getType(uri));
    }
    public void UploadImageFileToFirebaseStorage() {
        if (FilePathUri == null){
            Toast.makeText(getApplicationContext(),"Photo Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setTitle(" Data is Uploading...");
        progressDialog.setMessage(" Transfer Data Ke Server");
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        SharedPreferences sharedPref = getSharedPreferences("ipnukey", MODE_PRIVATE);
        String ipnuipp =  sharedPref.getString("ipnuippnu","").trim();
        String Storage_Path = "Poto_KTA_"+ipnuipp+"/";
        StorageReference storageReference2 = this.storageReference;
        storageReference2.child(Storage_Path + System.currentTimeMillis() + "." + GetFileExtension(FilePathUri)).putFile(FilePathUri).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<UploadTask.TaskSnapshot>() {
            /* class bpbd.trenggalekkab.go.id.LaporActivity.AnonymousClass8 */

            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                String data1 = sharedPreferences.getString("data1","").trim();
                String data2 = sharedPreferences.getString("data2","").trim();
                String data3 = sharedPreferences.getString("data3","").trim();
                String data4 = sharedPreferences.getString("data4","").trim();
                String data5 = sharedPreferences.getString("data5","").trim();
                String data6 = sharedPreferences.getString("data6","").trim();
                String data7 = sharedPreferences.getString("data7","").trim();
                String data8 = sharedPreferences.getString("data8","").trim();
                String data9 = sharedPreferences.getString("data9","").trim();
                String data10 = sharedPreferences.getString("data10","").trim();
                String data11 = sharedPreferences.getString("data11","").trim();
                String data12 = sharedPreferences.getString("data12","").trim();
                String data13 = sharedPreferences.getString("data13","").trim();
                String data14 = sharedPreferences.getString("data14","").trim();
                String data15 = sharedPreferences.getString("data15","").trim();
                String data16 = sharedPreferences.getString("data16","").trim();
                String data17 = sharedPreferences.getString("data17","").trim();
                String data18 = sharedPreferences.getString("data18","").trim();
                String data19 = sharedPreferences.getString("data19","").trim();
                String data20 = sharedPreferences.getString("data20","").trim();
                String data21 = sharedPreferences.getString("data21","").trim();
                String data22 = sharedPreferences.getString("data22","").trim();
                String data23 = sharedPreferences.getString("data23","").trim();
                String data24 = sharedPreferences.getString("data24","").trim();
                String data25 = sharedPreferences.getString("data25","").trim();
                String data26 = sharedPreferences.getString("data26","").trim();
                String data27 = sharedPreferences.getString("data27","").trim();
                String data28 = sharedPreferences.getString("data28","").trim();
                String data29 = sharedPreferences.getString("data29","").trim();
                String data30 = sharedPreferences.getString("data30","").trim();
                String data31 = sharedPreferences.getString("data31","").trim();
                String data32 = sharedPreferences.getString("data32","").trim();
                String data33 = sharedPreferences.getString("data33","").trim();
                String data34 = sharedPreferences.getString("data34","").trim();
                String data35 = sharedPreferences.getString("data35","").trim();
                String data36 = sharedPreferences.getString("data36","").trim();
                String data37 = sharedPreferences.getString("data37","").trim();
                String data38 = sharedPreferences.getString("data38","").trim();
                String data39 = sharedPreferences.getString("data39","").trim();
                String data40 = sharedPreferences.getString("data40","").trim();
                String data41 = sharedPreferences.getString("data41","").trim();
                String data42 = sharedPreferences.getString("data42","").trim();
                String data43 = sharedPreferences.getString("data43","").trim();
                String data44 = sharedPreferences.getString("data44","").trim();
                String data45 = sharedPreferences.getString("data45","").trim();
                String data46 = sharedPreferences.getString("data46","").trim();
                String data47 = sharedPreferences.getString("data47","").trim();
                String data48 = sharedPreferences.getString("data48","").trim();
                String data49 = sharedPreferences.getString("data49","").trim();
                String data50 = sharedPreferences.getString("data50","").trim();
                String data51 = sharedPreferences.getString("data51","").trim();
                String data52 = sharedPreferences.getString("data52","").trim();
                String data53 = sharedPreferences.getString("data53","").trim();
                String key = databaseReference.push().getKey();
                SharedPreferences sharedPref = getSharedPreferences("uid", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("key", key);
                editor.apply();
                progressDialog.dismiss();
                Toast.makeText(Entitas9Activity.this.getApplicationContext(), "Data Berhasil di Upload", Toast.LENGTH_SHORT).show();
                Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl();
                do {
                } while (!downloadUrl.isSuccessful());
                Data imageUploadInfo = new Data(data1,data2,data3,data4,data5,data6,data7,data8,data9,data10,data11,data12,data13,data14,data15,data16,data17,data18,data19,data20,data21,data22,data23,data24,data25,data26,data27,data28,data29,data30,data31,data32,data33,data34,data35,data36,data37,data38,data39,data40,data41,data42,data43,data44,data45,data46,data47,data48,data49,data50,data51,data52,Objects.requireNonNull(String.valueOf(downloadUrl.getResult())),key,data53);
                DatabaseReference databaseReference = Entitas9Activity.this.databaseReference;
                databaseReference.child(ipnuipp+key).setValue(imageUploadInfo);
            }
        }).addOnFailureListener((OnFailureListener) new OnFailureListener() {
            @Override
            public void onFailure(Exception exc) {
                progressDialog.dismiss();
                Toast.makeText(Entitas9Activity.this, exc.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener((OnProgressListener) new OnProgressListener<UploadTask.TaskSnapshot>() {

            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                progressDialog.setTitle("Data is Uploading...");
            }
        });
        auth1 = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener1 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(Entitas9Activity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        };
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Entitas9Activity.this, Entitas1Activity.class);
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
}