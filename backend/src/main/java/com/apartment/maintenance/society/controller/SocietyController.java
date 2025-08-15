package com.apartment.maintenance.society.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.maintenance.society.dto.AddSocietyRequestDTO;
import com.apartment.maintenance.society.entity.Society;
import com.apartment.maintenance.society.service.SocietyService;

@RestController
@RequestMapping("/api/societies")
@CrossOrigin(origins = "*")
public class SocietyController {

    @Autowired
    private SocietyService societyService;

    @PostMapping("/add")
    public ResponseEntity<?> addSociety(@RequestBody AddSocietyRequestDTO request) {
        System.out.println("Admin ID from request = " + request.getAdminId());

        try {
            Society savedSociety = societyService.addSociety(request);
            return ResponseEntity.ok(savedSociety);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Society>> getAllSocieties() {
        return ResponseEntity.ok(societyService.getAllSocieties());
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Society>> getSocietiesForAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(societyService.getSocietiesByAdminId(adminId));
}

}
