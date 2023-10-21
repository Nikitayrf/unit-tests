package seminars.seminar4.work.database;

import java.util.List;

public class DataProcessor {
    // Логика DataProcessor завязана на логику Database, т.е. есть внутренняя зависимость.

    private Database database;

    public DataProcessor(Database database) {
        this.database = database;
    }

    public List<String> processData(String sql) {
        return database.query(sql);
    }
}
