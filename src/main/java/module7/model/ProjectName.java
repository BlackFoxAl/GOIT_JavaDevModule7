package module7.model;

public class ProjectName {
    //project_id,name
    private int projectId;
    private String name;

    public ProjectName(int projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }
}
