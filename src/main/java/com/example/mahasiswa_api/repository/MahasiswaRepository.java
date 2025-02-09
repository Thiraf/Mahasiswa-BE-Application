package com.example.mahasiswa_api.repository;

import com.example.mahasiswa_api.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
}
