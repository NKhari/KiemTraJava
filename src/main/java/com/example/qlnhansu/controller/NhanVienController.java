package com.example.qlnhansu.controller;

import com.example.qlnhansu.entity.NhanVien;
import com.example.qlnhansu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String viewHomePage(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<NhanVien> nhanVienPage = nhanVienService.getAllNhanVienPaginated(page, 5);
        model.addAttribute("nhanVienPage", nhanVienPage);
        return "index";
    }

    @GetMapping("/them")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        return "add";
    }

    @PostMapping("/them")
    public String addNhanVien(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/capnhat/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        model.addAttribute("nhanVien", nhanVien);
        return "update";
    }

    @PostMapping("/capnhat/{id}")
    public String updateNhanVien(@PathVariable("id") String id, @ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/xoa/{id}")
    public String deleteNhanVien(@PathVariable("id") String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanvien";
    }
}
