
package com.ubl.uas_jwp_2311510438.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Buah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;

    private Double hargaPerKg;

    private Integer stok;

    @Enumerated(EnumType.STRING)
    private KategoriBuah kategori;  // Using enum

    private String deskripsi;

    private Date tanggalMasuk;

    private Date tanggalKadaluarsa;

    private String supplier;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public Double getHargaPerKg() { return hargaPerKg; }
    public void setHargaPerKg(Double hargaPerKg) { this.hargaPerKg = hargaPerKg; }

    public Integer getStok() { return stok; }
    public void setStok(Integer stok) { this.stok = stok; }

    public KategoriBuah getKategori() { return kategori; }
    public void setKategori(KategoriBuah kategori) { this.kategori = kategori; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public Date getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(Date tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }

    public Date getTanggalKadaluarsa() { return tanggalKadaluarsa; }
    public void setTanggalKadaluarsa(Date tanggalKadaluarsa) { this.tanggalKadaluarsa = tanggalKadaluarsa; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
}

