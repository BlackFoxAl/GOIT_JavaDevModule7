package module7.db;

import module7.model.Client;
import module7.model.Project;
import module7.model.ProjectName;
import module7.model.ProjectWorker;
import module7.model.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitTable {
    Connection connection;
    public InitTable() {
        try {
            connection = Database.getInstance().getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private final Worker[] workers = {
                new Worker(1,"Olivia Bennett","2001-01-01","Senior",80000),
                new Worker(2,"Ethan Chambers","2002-02-02","Senior",80000),
                new Worker(3,"Isabella Martinez","2003-03-03","Senior",60000),
                new Worker(4,"Aiden Thompson","2004-04-04","Middle",40000),
                new Worker(5,"Sophia Reynolds","2005-05-05","Middle",30000),
                new Worker(6,"Caleb Mitchell","2006-06-06","Middle",20000),
                new Worker(7,"Ava Harper","2007-07-07","Junior",5000),
                new Worker(8,"Liam Sanchez","2008-08-08","Junior",4000),
                new Worker(9,"Mia Anderson","2009-09-09","Junior",3000),
                new Worker(10,"Noah Patel","2010-10-10","Trainee",900)
    };
    private final Client[] clients = {
                new Client(1,"Emma Carter"),
                new Client(2,"Jackson Price"),
                new Client(3,"Amelia Foster"),
                new Client(4,"Lucas Harrison"),
                new Client(5,"Chloe Mitchell")
    };
    private final Project[] projects = {
                new Project(1,1,"2023-01-01","2023-02-01"),
                new Project(2,3,"2023-02-01","2023-12-01"),
                new Project(3,2,"2023-03-01","2024-02-01"),
                new Project(4,3,"2023-04-01","2024-12-01"),
                new Project(5,3,"2023-05-01","2025-02-01"),
                new Project(6,4,"2023-06-01","2025-12-01"),
                new Project(7,4,"2023-07-01","2026-02-01"),
                new Project(8,4,"2023-08-01","2026-12-01"),
                new Project(9,5,"2023-09-01","2027-02-01"),
                new Project(10,5,"2023-10-01","2027-12-01")
    };
    private final ProjectWorker[] projectWorkers = {
                new ProjectWorker(1,5),
                new ProjectWorker(2,4),
                new ProjectWorker(3,6),
                new ProjectWorker(3,3),
                new ProjectWorker(4,1),
                new ProjectWorker(4,2),
                new ProjectWorker(5,4),
                new ProjectWorker(5,3),
                new ProjectWorker(5,2),
                new ProjectWorker(6,1),
                new ProjectWorker(6,10),
                new ProjectWorker(6,9),
                new ProjectWorker(7,10),
                new ProjectWorker(7,9),
                new ProjectWorker(7,8),
                new ProjectWorker(7,7),
                new ProjectWorker(8,8),
                new ProjectWorker(8,7),
                new ProjectWorker(8,6),
                new ProjectWorker(8,5),
                new ProjectWorker(9,8),
                new ProjectWorker(9,7),
                new ProjectWorker(9,6),
                new ProjectWorker(9,4),
                new ProjectWorker(9,3),
                new ProjectWorker(10,5),
                new ProjectWorker(10,4),
                new ProjectWorker(10,3),
                new ProjectWorker(10,2),
                new ProjectWorker(10,1)
    };
    private final ProjectName[] projectNames = {
                new ProjectName(1,"Project A"),
                new ProjectName(2,"Project B"),
                new ProjectName(3,"Project C"),
                new ProjectName(4,"Project D"),
                new ProjectName(5,"Project E"),
                new ProjectName(6,"Project F"),
                new ProjectName(7,"Project G"),
                new ProjectName(8,"Project H"),
                new ProjectName(9,"Project I"),
                new ProjectName(10,"Project J")
    };
    public void initializationWorker() {
        try {
            //Connection connection = Database.getInstance().getConnection();
            String sqlTemplate = "INSERT INTO worker(id,name,birthday,level,salary) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlTemplate);
            for(Worker worker : workers) {
                statement.setInt(1,worker.getId());
                statement.setString(2,worker.getName());
                statement.setString(3,worker.getBirthday());
                statement.setString(4,worker.getLevel());
                statement.setInt(5,worker.getSalary());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void initializationClient() {
        try {
            //Connection connection = Database.getInstance().getConnection();
            String sqlTemplate = "INSERT INTO client(id,name) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlTemplate);
            for(Client client : clients) {
                statement.setInt(1,client.getId());
                statement.setString(2,client.getName());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void initializationProject() {
        try {
            //Connection connection = Database.getInstance().getConnection();
            String sqlTemplate = "INSERT INTO project(id,client_id,start_date,finish_date) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlTemplate);
            for(Project project : projects) {
                statement.setInt(1,project.getId());
                statement.setInt(2,project.getClientId());
                statement.setString(3,project.getStartDate());
                statement.setString(4,project.getFinishData());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void initializationProjectWorker() {
        try {
            //Connection connection = Database.getInstance().getConnection();
            String sqlTemplate = "INSERT INTO project_worker(project_id,worker_id) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlTemplate);
            for(ProjectWorker projectWorker : projectWorkers) {
                statement.setInt(1,projectWorker.getProjectId());
                statement.setInt(2,projectWorker.getWorkerId());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void initializationProjectName() {
        try {
            //Connection connection = Database.getInstance().getConnection();
            String sqlTemplate = "INSERT INTO project_name(project_id,name) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlTemplate);
            for(ProjectName projectName : projectNames) {
                statement.setInt(1,projectName.getProjectId());
                statement.setString(2,projectName.getName());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
