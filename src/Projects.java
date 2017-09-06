public class Projects {
    private String projectName;
    private int customer_id;
    private int cost;
    private int itcompany_id;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getItcompany_id() {
        return itcompany_id;
    }

    public void setItcompany_id(int itcompany_id) {
        this.itcompany_id = itcompany_id;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projectName='" + projectName + '\'' +
                ", customer_id=" + customer_id +
                ", cost=" + cost +
                ", itcompany_id=" + itcompany_id +
                '}';
    }
}
