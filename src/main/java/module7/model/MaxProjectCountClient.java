package module7.model;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;
public MaxProjectCountClient(String name, int projectCount) {
    this.name = name;
    this.projectCount = projectCount;
}

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }
    public String getName() {
        return name;
    }

    public int getProjectCount() {
        return projectCount;
    }
}

