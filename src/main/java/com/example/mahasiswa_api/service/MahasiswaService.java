package com.example.mahasiswa_api.service;

import com.example.mahasiswa_api.model.Mahasiswa;
import com.example.mahasiswa_api.repository.MahasiswaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MahasiswaService {
    private final MahasiswaRepository repository;

    public MahasiswaService(MahasiswaRepository repository) {
        this.repository = repository;
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return repository.findAll();
    }

    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        return repository.save(mahasiswa);
    }

    public Mahasiswa updateMahasiswa(Long id, Mahasiswa mahasiswaBaru) {
        return repository.findById(id)
                .map(mahasiswa -> {
                    mahasiswa.setNim(mahasiswaBaru.getNim());
                    mahasiswa.setNamaDepan(mahasiswaBaru.getNamaDepan());
                    mahasiswa.setNamaBelakang(mahasiswaBaru.getNamaBelakang());
                    mahasiswa.setTanggalLahir(mahasiswaBaru.getTanggalLahir());
                    return repository.save(mahasiswa);
                })
                .orElseThrow(() -> new RuntimeException("Mahasiswa dengan ID " + id + " tidak ditemukan"));
    }



    public void deleteMahasiswa(Long id) {
        repository.deleteById(id);
    }
}
