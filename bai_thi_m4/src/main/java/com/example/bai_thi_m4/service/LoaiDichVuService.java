package com.example.bai_thi_m4.service;

import com.example.bai_thi_m4.entity.GiaoDich;
import com.example.bai_thi_m4.entity.LoaiDichVu;
import com.example.bai_thi_m4.repository.IDichVuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiDichVuService implements ILoaiDichVuService{
    private IDichVuRepository dichVuRepository;

    public LoaiDichVuService(IDichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }

    @Override
    public List<LoaiDichVu> findAll() {
        return dichVuRepository.findAll();
    }
}
