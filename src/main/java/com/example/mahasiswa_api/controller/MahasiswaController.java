package com.example.mahasiswa_api.controller;

import com.example.mahasiswa_api.model.Mahasiswa;
import com.example.mahasiswa_api.service.MahasiswaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class MahasiswaController {
    private final MahasiswaService service;

    public MahasiswaController(MahasiswaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mahasiswa> getAllStudents() {
        return service.getAllMahasiswa();
    }

    @PostMapping
    public Mahasiswa addStudent(@RequestBody Mahasiswa mahasiswa) {
        mahasiswa.setId(null);
        return service.saveMahasiswa(mahasiswa);
    }


    @PutMapping("/{id}")
    public Mahasiswa updateStudent(@PathVariable Long id, @RequestBody Mahasiswa mahasiswaBaru) {
        return service.updateMahasiswa(id, mahasiswaBaru);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteMahasiswa(id);
    }
}
