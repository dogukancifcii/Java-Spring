package com.dogukan.service;

import com.dogukan.domain.Student;
import com.dogukan.dto.UpdateStudentDTO;
import com.dogukan.exception.ConflictException;
import com.dogukan.exception.ResourceNotFoundException;
import com.dogukan.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //constructor injection 1 tane constructor oldugu icin Autorwired yazmamiza gerek kalmadi.

/*public StudentService(StudentRepository repository) {
        this.repository = repository;
 }*/
public class StudentService {

    //burada yukaridaki RequiredArgsConstructor sayesinde const injection yapmis olduk.
    private final StudentRepository repository;

    //2-tum kayitlari listeleme
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    //4-ogrenciyi kaydetme
    public void saveStudent(Student student) {

        //student daha once tabloya eklenmis mi : tabloda ayni emaile sahip baska student var mi ?
        //SELECT * FROM student WHERE email = student.getEmail()-->t/f

        if (repository.existsByEmail(student.getEmail())) {
            //bu email daha once kullanilmis -- >hata firlatalim
            throw new ConflictException("Email already exists!");
        }
        repository.save(student); //insert into...
    }

    //6- id si verilen ogrenciyi bulma
    public Student getStudentById(Long id) {
        Student student = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Student is not found by id" + id));
        //optional deger donduruyor.optional null deger dondurebilir demek
        //eger null olursa exception firlat demis olduk bu sayede id olmazsa bilgimiz oluyor.
        return student;
    }

    //8-id si verilen ogrenciyi silme
    public void deleteStudentById(Long id) {

        //repository.deleteById(id);//delete from student where id =9999;
        //bu idye sahip bir ogrenci (satir) yoksa???
        //ozel bir mesaj ile ozel bir exception firlatmak istiyoruz

        Student student = getStudentById(id); //yukaridaki method ile id si verilen ogrenciyi bulur eger yoksa hata exception firlaticak sekilde method yazmistik
        repository.delete(student);
    }

    //10- id si verilen ogrencinin isim,soyisim,emailini degistirme
    public void updateStudent(Long id, UpdateStudentDTO studentDTO) {
        Student foundStudent = getStudentById(id);//1,"Jack","Sparrow","Jack@mail.com",...

        //emailin unique olmasina engel var mi???
        //DTOda gelen email             tablodaki email
        //1-xxx@mail.com                YOK     V   (existByEmail:false) -->update
        //2-harry@mail.com              id:2 olan ogrencinin maili  X  (existByEmail:true) -->ConflictException
        //3-jack@mail.com               kendisine ait V (existByEmail:true)

        //istek ile gonderilen email daha once kullanilmis mi ?
        boolean existsEmail = repository.existsByEmail(studentDTO.getEmail());
        if (existsEmail && !foundStudent.getEmail().equals(studentDTO.getEmail())) {
            //cakisma var
            throw new ConflictException("Email already exists");
        }
        foundStudent.setName(studentDTO.getName());
        foundStudent.setLastName(studentDTO.getLastName());
        foundStudent.setEmail(studentDTO.getEmail());

        repository.save(foundStudent);//saveOrUpdate gibi calisir.

    }

    //12- tablodaki tum kayitlardan istenen ogrenci sayfasini getirme
    public Page<Student> getAllStudentsPaging(Pageable pageable) {
        return repository.findAll(pageable); //istenen bilgiler verilirse tum kayitlardan sadece ilgili sayfayi getirir.
        //istenen bilgileri pageable ile toplu olarak verebiliriz:sayfaNo,her sayfada kayit sayisi, siralama bilgisi(hangi ozellik ,hangi yonde)
    }
}
