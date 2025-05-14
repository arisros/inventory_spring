
package com.ubl.uas_jwp_2311510438.controller;

import com.ubl.uas_jwp_2311510438.entity.Buah;
import com.ubl.uas_jwp_2311510438.repository.BuahRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/buah")
public class BuahController {

    @Autowired
    private BuahRepository buahRepository;

    // Halaman Tambah Inventaris Buah
    @GetMapping("/tambah")
    public String showTambahForm(Buah buah) {
        return "tambah-buah";  // Tampilkan halaman form tambah
    }

    // Proses Simpan Data Buah
    @PostMapping("/tambah")
    public String addBuah(@Valid Buah buah, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "tambah-buah";  // Kembali ke form jika ada error
        }

        buahRepository.save(buah);  // Simpan data buah
        redirectAttributes.addFlashAttribute("message", "Tambah Inventaris Berhasil!");
        return "redirect:/buah/list";  // Redirect ke halaman list
    }

    // Halaman Master List Inventaris Buah
    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "") String search, Model model) {
        if (search.isEmpty()) {
            model.addAttribute("buahList", buahRepository.findAll());  // Tampilkan semua buah jika tidak ada pencarian
        } else {
            model.addAttribute("buahList", buahRepository.findByNamaContainingIgnoreCase(search));  // Tampilkan hasil pencarian
        }
        model.addAttribute("search", search);  // Pass search term ke view
        return "list-buah";  // Tampilkan halaman list
    }

    // Halaman Ubah Inventaris Buah
    @GetMapping("/ubah/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Buah buah = buahRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid buah ID"));
        model.addAttribute("buah", buah);
        return "ubah-buah";  // Tampilkan form edit
    }

    // Proses Ubah Data Buah
    @PostMapping("/ubah/{id}")
    public String updateBuah(@PathVariable("id") Long id, @Valid Buah buah, BindingResult result, Model model) {
        if (result.hasErrors()) {
            buah.setId(id);  // Tetap pasang ID supaya form bisa mengupdate
            return "ubah-buah";  // Kembali ke form jika ada error
        }

        buahRepository.save(buah);  // Simpan perubahan ke database
        model.addAttribute("message", "Ubah Inventaris Berhasil!");  // Pesan sukses
        return "redirect:/buah/list";  // Redirect ke halaman list
    }

    // Hapus Data Buah
    @PostMapping("/hapus/{id}")
    public String deleteBuah(@PathVariable("id") Long id, Model model) {
        try {
            buahRepository.deleteById(id);  // Menghapus data berdasarkan ID
            model.addAttribute("message", "Hapus Inventaris Berhasil!");  // Menampilkan pesan sukses
        } catch (Exception e) {
            model.addAttribute("message", "Terjadi kesalahan saat menghapus!");  // Menampilkan pesan gagal
        }
        return "redirect:/buah/list";  // Redirect kembali ke halaman list
    }
}

