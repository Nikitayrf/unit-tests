package seminars.seminar4.book;


import org.junit.jupiter.api.Test;
import seminars.seminar4.work.book.Book;
import seminars.seminar4.work.book.BookRepository;
import seminars.seminar4.work.book.BookService;
import seminars.seminar4.work.book.InMemoryBookRepository;
import seminars.seminar4.work.hotel.BookingService;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    /**
     * Задание 2.
     * <p>
     * У вас есть класс BookService, который использует интерфейс BookRepository
     * для получения информации о книгах из базы данных. Ваша задача написать
     * unit-тесты для BookService, используя Mockito для создания мок-объекта
     * BookRepository.
     */

    @Test
    void findBookbyID() {
        // Arrange
        BookRepository bookRepository = mock( BookRepository.class );
        InMemoryBookRepository inMemoryBookRepository = new InMemoryBookRepository();
        when( bookRepository.findById( "1" ) ).thenReturn( inMemoryBookRepository.findById( "1" ) );
        BookService bookService = new BookService( bookRepository );
        // Act
        Book res = bookService.findBookById( "1" );
        // Assert
        assertEquals( "Book1", res.getTitle() );
    }

    @Test
    void findAllBooks() {
        // Arrange
        BookRepository bookRepository = mock( BookRepository.class );
        InMemoryBookRepository inMemoryBookRepository = new InMemoryBookRepository();
        when( bookRepository.findAll() ).thenReturn( inMemoryBookRepository.findAll() );
        BookService bookService = new BookService( bookRepository );
        //Act
        List<Book> books = bookService.findAllBooks();
        // Assert
        assertEquals( 2, books.size() );
        assertEquals( "Book1", books.get( 0 ).getTitle() );
        assertEquals( "Author2", books.get( 1 ).getAuthor() );

    }

}