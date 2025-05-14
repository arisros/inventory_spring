
package com.ubl.uas_jwp_2311510438.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Buah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nama Buah harus diisi")
    @NotEmpty(message = "Nama Buah tidak boleh kosong")
    private String nama;

    @NotNull(message = "Harga per Kg harus diisi")
    @DecimalMin(value = "0.01", message = "Harga per Kg harus lebih besar dari 0")
    private Double hargaPerKg;

    @NotNull(message = "Jumlah Stok harus diisi")
    @Min(value = 1, message = "Jumlah Stok harus lebih besar dari 0")
    private Integer stok;

    @NotNull(message = "Kategori harus dipilih")
    @Enumerated(EnumType.STRING)
    private KategoriBuah kategori;  // Using enum

    private String deskripsi;

    @NotNull(message = "Tanggal Masuk harus diisi")
    @PastOrPresent(message = "Tanggal Masuk harus <= hari ini")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalMasuk;

    @FutureOrPresent(message = "Tanggal Kadaluarsa harus >= tanggal masuk")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalKadaluarsa;

    @NotNull(message = "Nama Supplier harus diisi")
    @NotEmpty(message = "Nama Supplier tidak boleh kosong")
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

    public LocalDate getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(LocalDate tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }

    public LocalDate getTanggalKadaluarsa() { return tanggalKadaluarsa; }
    public void setTanggalKadaluarsa(LocalDate tanggalKadaluarsa) { this.tanggalKadaluarsa = tanggalKadaluarsa; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
}

