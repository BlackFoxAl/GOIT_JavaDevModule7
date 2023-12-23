package module7;

import module7.db.Database;
import module7.model.*;
import module7.utilfile.ParseSQLFile;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    static String filenameFindMaxProjectsClient = "sql/find_max_projects_client.sql";
    static String filenameFindLongestProject = "sql/find_longest_project.sql";
    static String filenameFindMaxSalaryWorker = "sql/find_max_salary_worker.sql";
    static String filenameFindYoungestEldestWorkers = "sql/find_youngest_eldest_workers.sql";
    static String filenamePrintProjectPrices = "sql/print_project_prices.sql";
    public static List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        String sql = new ParseSQLFile(filenameFindMaxProjectsClient).getOneSqlQuery();
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlTemplate = sql;
            PreparedStatement statement = connection.prepareStatement(sqlTemplate);
            statement.setInt(1, 1);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                maxProjectCountClients.add(new MaxProjectCountClient(rs.getString("name"),
                                                                     rs.getInt("project_count") ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maxProjectCountClients;
    }
    public static List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjects = new ArrayList<>();
        String sql = new ParseSQLFile(filenameFindLongestProject).getOneSqlQuery();
        try {
            Connection connection = module6.db.Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                longestProjects.add(new LongestProject(rs.getString("name"),rs.getInt("mounth_count") ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return longestProjects;
    }
    public static List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        String sql = new ParseSQLFile(filenameFindMaxSalaryWorker).getOneSqlQuery();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                maxSalaryWorkers.add(new MaxSalaryWorker(rs.getString("name"),
                        rs.getInt("salary") ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maxSalaryWorkers;
    }

    public static List<YoungestEldestWorker> findYoungestEldestWorkers() {
        List<YoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();
        String sql = new ParseSQLFile(filenameFindYoungestEldestWorkers).getOneSqlQuery();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                youngestEldestWorkers.add(new YoungestEldestWorker(rs.getString("type"),
                        rs.getString("name"), LocalDate.parse(rs.getString("birthday"))));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return youngestEldestWorkers;
    }

    public static List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> projectPrices = new ArrayList<>();
        String sql = new ParseSQLFile(filenamePrintProjectPrices).getOneSqlQuery();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                projectPrices.add(new ProjectPrice(rs.getString("name"),
                        rs.getInt("price") ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return projectPrices;
    }
}
