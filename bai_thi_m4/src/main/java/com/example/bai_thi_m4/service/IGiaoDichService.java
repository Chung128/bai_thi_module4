package com.example.bai_thi_m4.service;

import com.example.bai_thi_m4.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGiaoDichService {

    List<GiaoDich> findAll(String name, Long dichVuId);

    void save(GiaoDich giaoDich);

    GiaoDich findById(Long id);

    void remove(Long id);
}
