package gr.hua.dit.ds.it219151.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPLICATION")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "document")
    private String document;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "citizen_id")
    private Long citizenId;

    @Column(name = "office_worker_id")
    private Long officeWorkerId;

    @Column(name = "army_officer_id")
    private Long armyOfficerId;

    @Column(name = "validated")
    private Long validated;

    @Column(name = "approved")
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

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public Long getOfficeWorkerId() {
        return officeWorkerId;
    }

    public void setOfficeWorkerId(Long officeWorkerId) {
        this.officeWorkerId = officeWorkerId;
    }

    public Long getArmyOfficerId() {
        return armyOfficerId;
    }

    public void setArmyOfficerId(Long armyOfficerId) {
        this.armyOfficerId = armyOfficerId;
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
