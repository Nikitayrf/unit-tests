package seminars.seminar4.database;


import org.junit.jupiter.api.Test;
import seminars.seminar4.work.database.DataProcessor;
import seminars.seminar4.work.database.Database;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataProcessorTest {

    // 4.6.

    /**
     * Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
     * Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQL-
     * запрос и возвращает результат.
     * Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
     * выполнения запроса и обработки результатов.
     */

    // Что бы отвязаться от внутренних зависимостей DataProcessor, необходимо созать mock-объект
    // т.е. сэмулировать работу Database
    @Test
    void dataProcessorTest() {
        // Arrage (Подготовка)
        Database database = mock( Database.class );
        List<String> result = new ArrayList<>( List.of( "Data1", "Data2", "Data3" ) );
        when( database.query( "SELECT * FROM db;" ) ).thenReturn( result );
        DataProcessor dataProcessor = new DataProcessor( database );
        // Act (Выполнение)
        dataProcessor.processData( "SELECT * FROM db;" );
        // Assert (Проверка выполнения)
        assertEquals( result, database.query( "SELECT * FROM db;" ) );
    }
}