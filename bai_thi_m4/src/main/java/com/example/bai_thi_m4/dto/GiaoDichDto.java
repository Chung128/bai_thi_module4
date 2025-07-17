package com.example.bai_thi_m4.dto;

import com.example.bai_thi_m4.entity.GiaoDich;
import com.example.bai_thi_m4.entity.KhachHang;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class GiaoDichDto implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return GiaoDich.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GiaoDich giaoDich = (GiaoDich) target;
        KhachHang khachHang = (KhachHang) target;

        if (giaoDich.getMaGiaoDich() == null || !giaoDich.getMaGiaoDich().matches("^MGD-[0-9]{4}$")) {
            errors.rejectValue("maGiaoDich", "giaoDich.maGiaoDich.invalid", "Mã số giaoDich phải theo định dạng MGD-XXXX (4 số)");
        }



        if (giaoDich.getNgayGiaoDich() != null) {
            if (giaoDich.getNgayGiaoDich().isAfter(LocalDate.now())) {
                errors.rejectValue("ngayGiaoDich", "giaoDich.ngayGiaoDich.invalid",
                        "Ngày giao dịch không được là tương lai");
            }
        }
    }
}
