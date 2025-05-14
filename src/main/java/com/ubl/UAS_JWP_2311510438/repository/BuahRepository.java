
package com.ubl.uas_jwp_2311510438.repository;

import com.ubl.uas_jwp_2311510438.entity.Buah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuahRepository extends JpaRepository<Buah, Long> {
    List<Buah> findByNamaContainingIgnoreCase(String nama);
}

