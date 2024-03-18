package org.task.librarymanagesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.task.librarymanagesystem.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByBookId(String bookId);
}
