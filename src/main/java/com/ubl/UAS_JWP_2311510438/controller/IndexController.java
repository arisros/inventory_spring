
package com.ubl.uas_jwp_2311510438.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // Halaman utama yang akan mengarahkan ke halaman daftar buah
    @GetMapping("/")
    public String redirectToBuahList() {
        // Redirect ke halaman /buah/list
        return "redirect:/buah/list";
    }
}
