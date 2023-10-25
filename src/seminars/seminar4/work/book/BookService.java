package seminars.seminar4.work.book;

import java.util.List;

public class BookService {
    // Логика BookService завязана на логику BookRepository, т.е. есть внутренняя зависимость.
    // Что бы отвязаться от внутренних зависимостей необходимо создать mock-объект для BookService
    // т.е. сэмулировать работу BookService
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}

