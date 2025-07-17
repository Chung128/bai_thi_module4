package com.example.bai_thi_m4.repository;


import com.example.bai_thi_m4.entity.GiaoDich;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGiaoDichRepository extends JpaRepository<GiaoDich,Long> {
    @Query(value = "SELECT gd FROM GiaoDich gd " +
            "WHERE (:searchName IS NULL OR LOWER(gd.idKhachHang.tenKhachHang) LIKE LOWER(CONCAT('%', :searchName, '%'))) " +
            "AND (:dichVuId IS NULL OR gd.idDichVu.id = :dichVuId)")
    List<GiaoDich> findAll(@Param("searchName") String searchName,
                                @Param("dichVuId") Long dichVuId);
}
