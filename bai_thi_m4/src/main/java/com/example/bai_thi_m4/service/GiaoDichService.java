package com.example.bai_thi_m4.service;

import com.example.bai_thi_m4.entity.GiaoDich;
import com.example.bai_thi_m4.repository.IGiaoDichRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichService implements IGiaoDichService {
    private IGiaoDichRepository giaoDichRepository;

    public GiaoDichService(IGiaoDichRepository giaoDichRepository) {
        this.giaoDichRepository = giaoDichRepository;
    }

    @Override
    public List<GiaoDich> findAll(String name, Long dichVuId) {
        return giaoDichRepository.findAll(name, dichVuId);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public GiaoDich findById(Long id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        giaoDichRepository.deleteById(id);
    }
}
