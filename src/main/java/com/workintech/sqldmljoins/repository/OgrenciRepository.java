package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    String QUESTION_2 = "SELECT ogrenci.*, islem.islemno FROM ogrenci INNER JOIN islem ON ogrenci.ogrno = islem.ogrno;";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findStudentsWithBook();

    String QUESTION_3 = "SELECT ogrenci.* FROM ogrenci LEFT JOIN islem ON ogrenci.ogrno = islem.ogrno GROUP BY ogrenci.ogrno HAVING COUNT(islem.islemno) = 0;";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<Ogrenci> findStudentsWithNoBook();

    String QUESTION_4 = "SELECT o.sinif, COUNT(i.kitapno) FROM ogrenci AS o JOIN islem AS i ON o.ogrno = i.ogrno WHERE o.sinif IN ('10A', '10B') GROUP BY o.sinif ORDER BY o.sinif;";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<KitapCount> findClassesWithBookCount();

    String QUESTION_5 = "SELECT COUNT(*) AS ogrenci_sayisi FROM ogrenci;";
    @Query(value = QUESTION_5, nativeQuery = true)
    Integer findStudentCount();

    String QUESTION_6 = "SELECT COUNT(DISTINCT ad) AS isim_sayisi FROM ogrenci;";
    @Query(value = QUESTION_6, nativeQuery = true)
    Integer findUniqueStudentNameCount();

    String QUESTION_7 = "SELECT ad, COUNT(ad) FROM ogrenci GROUP BY ad;";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<StudentNameCount> findStudentNameCount();

    String QUESTION_8 = "SELECT sinif, COUNT(ogrenci) FROM ogrenci GROUP BY sinif;";
    @Query(value = QUESTION_8, nativeQuery = true)
    List<StudentClassCount> findStudentClassCount();

    String QUESTION_9 = "SELECT ogrenci.ad, ogrenci.soyad, COUNT(islem.islemno) AS kitap_sayisi FROM ogrenci INNER JOIN islem ON ogrenci.ogrno = islem.ogrno GROUP BY ogrenci.ogrno ORDER BY ogrenci.ad;";
    @Query(value = QUESTION_9, nativeQuery = true)
    List<StudentNameSurnameCount> findStudentNameSurnameCount();
}
