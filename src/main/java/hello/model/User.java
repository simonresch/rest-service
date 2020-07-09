package hello.model;


import java.util.List;

public class User {

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Job> jobs;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ",lastName="
                + lastName + ", email=" + email + "]";
    }
}
