package com.example.bai_thi_m4.controller;


import com.example.bai_thi_m4.dto.GiaoDichDto;
import com.example.bai_thi_m4.entity.GiaoDich;
import com.example.bai_thi_m4.service.IGiaoDichService;
import com.example.bai_thi_m4.service.IKhachHangService;
import com.example.bai_thi_m4.service.ILoaiDichVuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("giao_dich")
public class GiaoDichController {
    private IGiaoDichService giaoDichService;
    private IKhachHangService khachHangService;
    private ILoaiDichVuService dichVuService;
    private GiaoDichDto giaoDichDto;

    public GiaoDichController(IGiaoDichService giaoDichService, IKhachHangService khachHangService, ILoaiDichVuService dichVuService, GiaoDichDto giaoDichDto) {
        this.giaoDichService = giaoDichService;
        this.khachHangService = khachHangService;
        this.dichVuService = dichVuService;
        this.giaoDichDto = giaoDichDto;
    }

    @GetMapping("")
    private String show(@RequestParam(required = false, defaultValue = "") String name,
                        @RequestParam(required = false, defaultValue = "") Long dichVuId,
                        Model model) {
        List<GiaoDich> giaoDich = giaoDichService.findAll(name,dichVuId);
        model.addAttribute("name", name);
        model.addAttribute("dichVuId", dichVuService.findAll());
        model.addAttribute("giaoDich", giaoDich);
        return "list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("dichVu", dichVuService.findAll());
        model.addAttribute("khachHang", khachHangService.findAll());
        model.addAttribute("giaoDichs", new GiaoDich());
        return "create";
    }

//    @PostMapping("save")
//    public String create(@ModelAttribute("giaoDichs") GiaoDich giaoDich,
//                         BindingResult bindingResult,
//                         Model model,
//                         RedirectAttributes redirect) {
//
//        giaoDichDto.validate(giaoDich, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("dichVu", dichVuService.findAll());
//            return "create";
//        }
//
//        giaoDichService.save(giaoDich);
//        redirect.addFlashAttribute("success", "Create success!");
//        return "redirect:/giao_dich";
//    }

        @PostMapping("save")
    public String create(GiaoDich giaoDich, RedirectAttributes redirect) {
        giaoDichService.save(giaoDich);
        redirect.addFlashAttribute("success", "Thêm mới thành công!");
        return "redirect:/giao_dich";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("dichVu",giaoDichService.findById(id).getIdDichVu());
        model.addAttribute("giaoDich", giaoDichService.findById(id));
        return "detail";
    }

    @PostMapping("delete")
    public String delete(GiaoDich giaoDich, RedirectAttributes redirectAttributes) {
        giaoDichService.remove(giaoDich.getId());
        redirectAttributes.addFlashAttribute("success", "Đã xóa thành công");
        return "redirect:/giao_dich";
    }
}
