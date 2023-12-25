package module7;

import module7.db.InitTable;

public class DatabasePopulateService {

    public static void main(String[] args) {
        InitTable initTable = new InitTable();
        initTable.initializationWorker();
        initTable.initializationClient();
        initTable.initializationProject();
        initTable.initializationProjectWorker();
        initTable.initializationProjectName();
    }
}
