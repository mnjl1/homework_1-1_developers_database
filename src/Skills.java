public class Skills {
    private String skillName;
    private int developer_id;

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "skillName='" + skillName + '\'' +
                ", developer_id=" + developer_id +
                '}';
    }
}
