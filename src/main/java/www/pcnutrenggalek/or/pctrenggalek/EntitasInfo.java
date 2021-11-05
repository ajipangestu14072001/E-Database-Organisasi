package www.pcnutrenggalek.or.pctrenggalek;

public class EntitasInfo {
    public String id;
    public String imageURL;
    public String jenisbencana;
    public String keterangan;
    public String lokasikejadian;
    public String namapelapor;
    public String nomorpelapor;
    public String saatkejadian;
    public String waktu;

    public EntitasInfo() {
    }
    public EntitasInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.jenisbencana = str4;
        this.namapelapor = str;
        this.nomorpelapor = str2;
        this.saatkejadian = str3;
        this.keterangan = str5;
        this.waktu = str6;
        this.imageURL = str9;
        this.id = str7;
        this.lokasikejadian = str8;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getNamapelapor() {
        return this.namapelapor;
    }

    public String getNomorpelapor() {
        return this.nomorpelapor;
    }

    public String getJenisbencana() {
        return this.jenisbencana;
    }

    public String getKeterangan() {
        return this.keterangan;
    }

    public String getSaatkejadian() {
        return this.saatkejadian;
    }

    public String getLokasikejadian() {
        return this.lokasikejadian;
    }

    public String getWaktu() {
        return this.waktu;
    }

    public String getId() {
        return this.id;
    }
}
