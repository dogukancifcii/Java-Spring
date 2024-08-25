package com.dogukan.repository;

import com.dogukan.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //JpaRepository oldugu icin yazmak zorunda degiliz fakat optional olarak okunabilirlik icin yazilabilir
public interface BookRepository extends JpaRepository<Book, Long> {
}
