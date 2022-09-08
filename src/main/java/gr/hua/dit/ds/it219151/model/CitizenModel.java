package gr.hua.dit.ds.it219151.model;

public class CitizenModel {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private Long enlistment_number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getEnlistment_number() {
        return enlistment_number;
    }

    public void setEnlistment_number(Long enlistment_number) {
        this.enlistment_number = enlistment_number;
    }
}
