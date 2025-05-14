
package com.ubl.uas_jwp_2311510438.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
public class Buah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nama buah harus diisi")
    private String nama;

    @DecimalMin(value = "0.01", message = "Harga per kg harus lebih besar dari 0")
    private Double hargaPerKg;

    @Min(value = 1, message = "Jumlah stok harus lebih besar dari 0")
    private Integer stok;

    @NotEmpty(message = "Kategori harus dipilih")
    private String kategori;

    private String deskripsi;

    @NotNull(message = "Tanggal masuk harus diisi")
    @PastOrPresent(message = "Tanggal masuk tidak bisa di masa depan")
    private Date tanggalMasuk;

    @FutureOrPresent(message = "Tanggal kadaluarsa harus di masa depan atau hari ini")
    private Date tanggalKadaluarsa;

    @NotEmpty(message = "Nama supplier harus diisi")
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

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public Date getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(Date tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }

    public Date getTanggalKadaluarsa() { return tanggalKadaluarsa; }
    public void setTanggalKadaluarsa(Date tanggalKadaluarsa) { this.tanggalKadaluarsa = tanggalKadaluarsa; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
}

