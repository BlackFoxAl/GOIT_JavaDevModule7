package module7;

import module7.db.UtilQueries;

public class DatabaseInitService {
    public static void main(String [] args) {
        String filenameInit = "sql/init_db.sql";
        new UtilQueries().executeSetQueries(filenameInit);
    }
}
