package com.example.bai_thi_m4.service;

import com.example.bai_thi_m4.entity.KhachHang;
import com.example.bai_thi_m4.repository.IKhachHangRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService{
    private IKhachHangRepository khachHangRepository;

    public KhachHangService(IKhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }
}
