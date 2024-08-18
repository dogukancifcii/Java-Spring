package com.dogukan.repository;

import com.dogukan.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //opsiyoneldir sebebi JpaRepository oldugu icin
//generics yaptisi ilk kisim entity aliyor ikinci kisim id tipini aliyor.
//JpaRepositorydeki motodlar Spring tarafindan otomatik olarak implemente edilir.
//JpaRepository sayesind otomatik dbyle iletisime gecegimiz methodlar vardir.
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
}
