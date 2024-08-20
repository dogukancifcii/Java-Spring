package com.dogukan.repository;

import com.dogukan.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository //opsiyoneldir sebebi JpaRepository oldugu icin
//generics yaptisi ilk kisim entity aliyor ikinci kisim id tipini aliyor.
//JpaRepositorydeki motodlar Spring tarafindan otomatik olarak implemente edilir.
//JpaRepository sayesind otomatik dbyle iletisime gecegimiz methodlar vardir.
public interface StudentRepository extends JpaRepository<Student, Long> {
    //JpaRepositorydeki hazir methodlarin isimlerini tureterek method olusturabiliyoruz.Dikkat etmemiz gereken nokta istedigimiz methoda benzer method olmadi ve olusturacagimiz methodun field kismi bizde olmalidir.Normalde methodu olusturup implement etmemiz gerekir ama JpaRepository sayesinde kok dizine gore implement etmeden method olusturabiliyoruz.
    boolean existsByEmail(String email);

    //14-a
    List<Student> findAllByGrade(Integer grade);

    //14-b
    //JPQL (JACARTA PERSIST QUERY LANGUAGE) HQL ve SQL ile ayni mantikta
    //Query kisminda sorgu yazmamiza yariyor.
    //Bunu yapamamizin sebebi eger JPA repositoryde benzemeyen bir method olusturuyorsak Query tanimlayarak JPA repositorye boyle tanimliyoruz
    @Query("FROM Student WHERE grade=:pGrade")
    List<Student> filterStudentsByGrade(@Param("pGrade") Integer grade);


    //14-c
    //SQL
    //Query kisminda sorgu yazmamiza yariyor.
    //Bunu yapamamizin sebebi eger JPA repositoryde benzemeyen bir method olusturuyorsak Query tanimlayarak JPA repositorye boyle tanimliyoruz
    @Query(value = "SELECT * FROM Student WHERE grade=:pGrade", nativeQuery = true)
    List<Student> filterStudentsByGradeSQL(@Param("pGrade") Integer grade);



}
