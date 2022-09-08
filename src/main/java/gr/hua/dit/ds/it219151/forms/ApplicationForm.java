package gr.hua.dit.ds.it219151.forms;

public class ApplicationForm {
    private String document;
    private String birthday;
    private String office_worker_id;
    private String army_officer_id;
    private String validated;
    private String approved;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getOffice_worker_id() {
        return office_worker_id;
    }

    public void setOffice_worker_id(String office_worker_id) {
        this.office_worker_id = office_worker_id;
    }

    public String getArmy_officer_id() {
        return army_officer_id;
    }

    public void setArmy_officer_id(String army_officer_id) {
        this.army_officer_id = army_officer_id;
    }

    public String getValidated() {
        return validated;
    }

    public void setValidated(String validated) {
        this.validated = validated;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }
}
