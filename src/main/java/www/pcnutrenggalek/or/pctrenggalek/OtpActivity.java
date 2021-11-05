package www.pcnutrenggalek.or.pctrenggalek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

public class OtpActivity extends AppCompatActivity {
    private Button validateButton;
    private OtpView otpView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        SharedPreferences sharedPac = getSharedPreferences("keypac", MODE_PRIVATE);
        String datapac =  sharedPac.getString("PAC","").trim();
        validateButton = findViewById(R.id.validate_button);
        otpView = findViewById(R.id.otp_view);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otpView.getText().toString().equals("350301") && datapac.equals("PAC_Watulimo")){
                    validasiipnu();
                } else if(otpView.getText().toString().equals("624514")&& datapac.equals("PAC_Watulimo")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("568362")&& datapac.equals("PAC_Panggul")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("098621")&& datapac.equals("PAC_Panggul")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("568362")&& datapac.equals("PAC_Durenan")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("765411")&& datapac.equals("PAC_Durenan")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("851439")&& datapac.equals("PAC_Kampak")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("587497")&& datapac.equals("PAC_Kampak")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("900765")&& datapac.equals("PAC_Pule")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("776584")&& datapac.equals("PAC_Pule")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("268964")&& datapac.equals("PAC_Gandusari")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("549083")&& datapac.equals("PAC_Gandusari")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("271690")&& datapac.equals("PAC_Munjungan")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("758962")&& datapac.equals("PAC_Munjungan")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("541239")&& datapac.equals("PAC_Trenggalek")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("815608")&& datapac.equals("PAC_Trenggalek")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("076941")&& datapac.equals("PAC_Bendungan")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("237789")&& datapac.equals("PAC_Bendungan")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("347076")&& datapac.equals("PAC_Dongko")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("568054")&& datapac.equals("PAC_Dongko")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("007156")&& datapac.equals("PAC_Pogalan")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("500876")&& datapac.equals("PAC_Pogalan")){
                    validasiippnu();
                } else if(otpView.getText().toString().equals("102901")&& datapac.equals("PAC_Karangan")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("675075")&& datapac.equals("PAC_Karangan")){
                    validasiippnu();
                } else if(otpView.getText().toString().equals("289018")&& datapac.equals("PAC_Suruh")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("084744")&& datapac.equals("PAC_Suruh")){
                    validasiippnu();
                }else if(otpView.getText().toString().equals("876012")&& datapac.equals("PAC_Tugu")){
                    validasiipnu();
                }else if(otpView.getText().toString().equals("841209")&& datapac.equals("PAC_Tugu")){
                    validasiippnu();
                }
                else {
                    Toast.makeText(OtpActivity.this,"Validasi Gagal, Mohon Periksa Kembali",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    public void validasiipnu(){
        Toast.makeText(OtpActivity.this,"Validasi Sukses",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(OtpActivity.this,ActivityIpnuippnu.class);
        String text1 ="IPNU";
        String text2 ="LAKI-LAKI";
        SharedPreferences sharedPref = getSharedPreferences("ipnukey", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("ipnuippnu", text1);
        editor.putString("LP", text2);
        editor.apply();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void validasiippnu(){
        Toast.makeText(OtpActivity.this,"Validasi Sukses",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(OtpActivity.this,ActivityIpnuippnu.class);
        String text3 ="IPPNU";
        String text4 ="PEREMPUAN";
        SharedPreferences sharedPref = getSharedPreferences("ipnukey", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("ipnuippnu", text3);
        editor.putString("LP",text4);
        editor.apply();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OtpActivity.this,AnakCabangActivity.class);
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
}