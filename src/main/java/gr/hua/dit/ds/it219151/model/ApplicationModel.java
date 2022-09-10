package gr.hua.dit.ds.it219151.model;

public class ApplicationModel {
    private Long id;
    private String document;
    private String birthday;
    private Long citizen_id;
    private Long office_worker_id;
    private Long army_officer_id;
    private Long validated;
    private Long approved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCitizen_id() {
        return citizen_id;
    }

    public void setCitizen_id(Long citizen_id) {
        this.citizen_id = citizen_id;
    }

    public Long getOffice_worker_id() {
        return office_worker_id;
    }

    public void setOffice_worker_id(Long office_worker_id) {
        this.office_worker_id = office_worker_id;
    }

    public Long getArmy_officer_id() {
        return army_officer_id;
    }

    public void setArmy_officer_id(Long army_officer_id) {
        this.army_officer_id = army_officer_id;
    }

    public Long getValidated() {
        return validated;
    }

    public void setValidated(Long validated) {
        this.validated = validated;
    }

    public Long getApproved() {
        return approved;
    }

    public void setApproved(Long approved) {
        this.approved = approved;
    }
}
