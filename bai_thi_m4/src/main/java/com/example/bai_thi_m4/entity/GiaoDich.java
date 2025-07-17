package com.example.bai_thi_m4.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "giao_dich")
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maGiaoDich;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang idKhachHang;

    private LocalDate ngayGiaoDich;
    private Double gia;
    private Double dienTich;

    @ManyToOne
    @JoinColumn(name = "id_dich_vu")
    private LoaiDichVu idDichVu;
}
