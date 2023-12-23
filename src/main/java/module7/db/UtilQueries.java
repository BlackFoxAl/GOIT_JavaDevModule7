package module7.db;

import module7.utilfile.ParseSQLFile;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UtilQueries {

    public void executeSetQueries(String filePath) {
        List<String> queries = new ParseSQLFile(filePath).getListSQLQuery();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            for (String query : queries) {
                statement.executeUpdate(query);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
