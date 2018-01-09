package com.muhamadarief.pasarmalamsmd.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.nio.DoubleBuffer;

/**
 * Created by Muhamad Arief on 14/06/2017.
 */

public class Pasar implements Serializable {

    @SerializedName("id_pasar")
    private String id_pasar;
    @SerializedName("nama_lokasi")
    private String nama_lokasi;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("foto_lokasi")
    private String foto_lokasi;
    @SerializedName("hari")
    private String hari;
    @SerializedName("jam")
    private String jam;
    @SerializedName("lattitude")
    private Double lattitude;
    @SerializedName("longitude")
    private Double longitude;

    public Pasar() {
    }

    public Pasar(String id_pasar, String nama_lokasi, String deskripsi, String foto_lokasi, String hari, String jam, Double lattitude, Double longitude) {
        this.id_pasar = id_pasar;
        this.nama_lokasi = nama_lokasi;
        this.deskripsi = deskripsi;
        this.foto_lokasi = foto_lokasi;
        this.hari = hari;
        this.jam = jam;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public String getId_pasar() {
        return id_pasar;
    }

    public void setId_pasar(String id_pasar) {
        this.id_pasar = id_pasar;
    }

    public String getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFoto_lokasi() {
        return foto_lokasi;
    }

    public void setFoto_lokasi(String foto_lokasi) {
        this.foto_lokasi = foto_lokasi;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
