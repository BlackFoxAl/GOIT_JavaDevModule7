package module7.model;

public class Project {

    private int id;
    private int clientId;
    private String startDate;
    private String finishData;

    public Project(int id, int clientId, String startDate, String finishData) {
        this.id = id;
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishData = finishData;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishData() {
        return finishData;
    }
}
