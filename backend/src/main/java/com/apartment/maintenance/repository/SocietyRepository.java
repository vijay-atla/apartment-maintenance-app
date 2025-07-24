package com.apartment.maintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apartment.maintenance.entity.Society;

public interface SocietyRepository extends JpaRepository<Society, Long> {


    @Query("SELECT s FROM Society s JOIN s.admins a WHERE a.id = :adminId")
    List<Society> findByAdminId(@Param("adminId") Long adminId);



}
