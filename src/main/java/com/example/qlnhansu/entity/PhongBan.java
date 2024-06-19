package com.example.qlnhansu.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
    @Column(name = "Ma_Phong")
    private String maPhong;

    @Column(name = "Ten_Phong")
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
    private List<NhanVien> nhanviens;
}
