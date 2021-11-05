package www.pcnutrenggalek.or.pctrenggalek;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.multidex.MultiDex;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

import static java.security.AccessController.getContext;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Data> MainImageUploadInfoList;
    Context context;


    public RecyclerViewAdapter(Context context2, List<Data> list) {
        this.MainImageUploadInfoList = list;
        this.context = context2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Data imageUploadInfo = this.MainImageUploadInfoList.get(i);
        viewHolder.NamaLengkap.setText(imageUploadInfo.getA3_namalengkap());
        viewHolder.TanggalLahir.setText(imageUploadInfo.getA5_tanggallahir());
        viewHolder.TempatLahir.setText(imageUploadInfo.getA4_tempatlahir());
        viewHolder.RTRW.setText(imageUploadInfo.getA6_rtrwdusun());
        Glide.with(this.context).load(imageUploadInfo.getA2_imageurl()).into(viewHolder.imageView);
        // viewHolder.carditem.setCardBackgroundColor(R.drawable.background_login);
        viewHolder.carditem.setOnClickListener(new View.OnClickListener() {
            /* class bpbd.trenggalekkab.go.id.RecyclerViewAdapter.AnonymousClass1 */

            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DatailActivity.class);
                intent.putExtra("Photo", imageUploadInfo.getA2_imageurl());
                intent.putExtra("Nama", imageUploadInfo.getA3_namalengkap());
                intent.putExtra("Tanggal", imageUploadInfo.getA5_tanggallahir());
                intent.putExtra("Tempat", imageUploadInfo.getA4_tempatlahir());
                intent.putExtra("RTRW", imageUploadInfo.getA6_rtrwdusun());
                intent.putExtra("Desa",imageUploadInfo.getA7_desa());
                intent.putExtra("Kecamatan",imageUploadInfo.getA8_kecamatan());
                intent.putExtra("Kabupaten",imageUploadInfo.getA9_kabupaten());
                intent.putExtra("Provinsi",imageUploadInfo.getB10_provinsi());
                intent.putExtra("GolonganDarah",imageUploadInfo.getB11_golongandarah());
                intent.putExtra("KodePos",imageUploadInfo.getB12_kodepos());
                intent.putExtra("NIK",imageUploadInfo.getB13_nik());
                intent.putExtra("NomorHP",imageUploadInfo.getB14_nomerhp());
                intent.putExtra("NamaAyah",imageUploadInfo.getB15_namaayah());
                intent.putExtra("PekerjaanAyah",imageUploadInfo.getB16_pekerjaanayah());
                intent.putExtra("NamaIbu",imageUploadInfo.getB17_namaibu());
                intent.putExtra("PekerjaanIbu",imageUploadInfo.getB18_pekerjaanibu());
                intent.putExtra("SDMI",imageUploadInfo.getB19_sdmi());
                intent.putExtra("SMP",imageUploadInfo.getC20_smpmts());
                intent.putExtra("SMA",imageUploadInfo.getC21_smasmk());
                intent.putExtra("S1",imageUploadInfo.getC22_s1());
                intent.putExtra("S2",imageUploadInfo.getC23_s2());
                intent.putExtra("Keahlian1",imageUploadInfo.getC24_keahlian1());
                intent.putExtra("Keahlian2",imageUploadInfo.getC25_keahlian2());
                intent.putExtra("Prestasi1",imageUploadInfo.getC26_prestasi1());
                intent.putExtra("Prestasi2",imageUploadInfo.getC27_prestasi2());
                intent.putExtra("Prestasi3",imageUploadInfo.getC28_prestasi3());
                intent.putExtra("Penmakesta",imageUploadInfo.getC29_makesta());
                intent.putExtra("Tahunmakesta",imageUploadInfo.getD30_tahunmakesta());
                intent.putExtra("Nosertifikatmakesta",imageUploadInfo.getD31_nomorsertifikatmakesta());
                intent.putExtra("Penlakmud",imageUploadInfo.getD32_lakmud());
                intent.putExtra("Tahunlakmud",imageUploadInfo.getD33_tahunlakmud());
                intent.putExtra("Nosertifikatlakmud",imageUploadInfo.getD34_nomorsertifikatlakmud());
                intent.putExtra("Penlakut",imageUploadInfo.getD35_lakut());
                intent.putExtra("Tahunlakut",imageUploadInfo.getD36_tahunlakut());
                intent.putExtra("Nosertifikatlakut",imageUploadInfo.getD37_nomorsertifikatlakut());
                intent.putExtra("Latin",imageUploadInfo.getD38_latinlatpel());
                intent.putExtra("Tahunlatin",imageUploadInfo.getD39_tahunlatinlatpel());
                intent.putExtra("Nosertifikatlatin",imageUploadInfo.getE40_nomorsertifikatlatinlatpel());
                intent.putExtra("PenDiklatama",imageUploadInfo.getE41_diklatama());
                intent.putExtra("Tahundiklatama",imageUploadInfo.getE42_tahundiklatama());
                intent.putExtra("Nosertifikatdiklatama",imageUploadInfo.getE43_nomorsertifikatdiklatama());
                intent.putExtra("Pendiklatmad",imageUploadInfo.getE44_diklatmad());
                intent.putExtra("Tahundiklatmad",imageUploadInfo.getE45_tahundiklatmad());
                intent.putExtra("Nosertifikatdiklatmad",imageUploadInfo.getE46_nomorsertifikatdiklatmad());
                intent.putExtra("Penpelatihan1",imageUploadInfo.getE47_pelatihan());
                intent.putExtra("Namapelatihan1",imageUploadInfo.getE48_namapelatihan());
                intent.putExtra("Tahunpelatihan1",imageUploadInfo.getE49_tahunpelatihan());
                intent.putExtra("Nosertifikatpelatihan1",imageUploadInfo.getF50_nomorsertifikatpelatihan());
                intent.putExtra("Penpelatihan2",imageUploadInfo.getF51_pelatihan2());
                intent.putExtra("Namapelatihan2",imageUploadInfo.getF52_namapelatihan2());
                intent.putExtra("Tahunpelatihan2",imageUploadInfo.getF53_tahunpelatihan2());
                intent.putExtra("Nosertifikatpelatihan2",imageUploadInfo.getF54_nomorsertifikatpelatihan2());
                intent.putExtra("alamatemail",imageUploadInfo.getF55_alamatemail());
                context.startActivity(intent);

            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.MainImageUploadInfoList.size();
    }

    /* access modifiers changed from: package-private */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView NamaLengkap;
        public TextView TanggalLahir;
        public TextView TempatLahir;
        public TextView RTRW;
        public CardView carditem;
        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imglogo);
            NamaLengkap = (TextView) view.findViewById(R.id.namalengkap);
            TanggalLahir = (TextView) view.findViewById(R.id.tgllahir);
            TempatLahir =  (TextView) view.findViewById(R.id.tempatlahir);
            RTRW = (TextView) view.findViewById(R.id.rtrw);

            carditem = (CardView) view.findViewById(R.id.cardview8);
        }
    }
}