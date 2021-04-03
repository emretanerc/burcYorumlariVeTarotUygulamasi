package com.etcmobileapps.burcyorumlari2020.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HayModel {

    @SerializedName("Burc")
    @Expose
    private String burc;
    @SerializedName("Zaman")
    @Expose
    private String zaman;
    @SerializedName("Mottosu")
    @Expose
    private String mottosu;
    @SerializedName("Gezegeni")
    @Expose
    private String gezegeni;
    @SerializedName("Elementi")
    @Expose
    private String elementi;
    @SerializedName("Yorum")
    @Expose
    private String yorum;

    public String getBurc() {
        return burc;
    }

    public void setBurc(String burc) {
        this.burc = burc;
    }

    public String getZaman() {
        return zaman;
    }

    public void setZaman(String zaman) {
        this.zaman = zaman;
    }

    public String getMottosu() {
        return mottosu;
    }

    public void setMottosu(String mottosu) {
        this.mottosu = mottosu;
    }

    public String getGezegeni() {
        return gezegeni;
    }

    public void setGezegeni(String gezegeni) {
        this.gezegeni = gezegeni;
    }

    public String getElementi() {
        return elementi;
    }

    public void setElementi(String elementi) {
        this.elementi = elementi;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

}