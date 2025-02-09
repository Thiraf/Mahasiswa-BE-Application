package com.example.mahasiswa_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nim;
    private String namaDepan;
    private String namaBelakang;
    private LocalDate tanggalLahir;
    @Transient
    public int getUsia() {
        return Period.between(this.tanggalLahir, LocalDate.now()).getYears();
    }
}
