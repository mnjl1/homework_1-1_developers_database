public class Company {
    private int itcompany_id;
    private String companyName;


    public int getItcompany_id() {
        return itcompany_id;
    }

    public void setItcompany_id(int itcompany_id) {
        this.itcompany_id = itcompany_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "itcompany_id=" + itcompany_id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
