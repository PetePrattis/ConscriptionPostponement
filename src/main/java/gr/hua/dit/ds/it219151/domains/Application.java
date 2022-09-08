package gr.hua.dit.ds.it219151.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPLICATION", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "document")
    private String document;

    @Column(name = "birthday")
    private String birthday;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    @Column(name = "office_worker_id")
    private Long office_worker_id;

    @Column(name = "army_officer_id")
    private Long army_officer_id;

    @Column(name = "validated")
    private Boolean validated;

    @Column(name = "approved")
    private Boolean approved;

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

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
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

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
