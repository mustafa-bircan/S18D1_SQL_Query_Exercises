package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KitapRepository extends JpaRepository<Kitap, Long> {

    String QUESTION_1 = "SELECT kitap.* FROM kitap WHERE kitap.turno IN (SELECT turno FROM tur WHERE ad = 'Dram') OR kitap.turno IN (SELECT turno FROM tur WHERE ad = 'Hikaye') ORDER BY kitap.ad;";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Kitap> findBooks();

    String QUESTION_10 = "SELECT AVG(puan) FROM kitap;";
    @Query(value = QUESTION_10, nativeQuery = true)
    Double findAvgPointOfBooks();
}
