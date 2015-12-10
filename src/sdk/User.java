package sdk;

import java.util.Date;

/**
 * Created by sverreostgaard on 30.11.15.
 */
public class User {

    private int id, type;
    private String firstName, lastName, email, username, password, status;
    private Date created;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }

    public Date getCreated() {
        return created;
    }
}
