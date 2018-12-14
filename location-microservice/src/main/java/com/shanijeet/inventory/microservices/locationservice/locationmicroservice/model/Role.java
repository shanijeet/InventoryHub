package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLE_DETAIL")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ROLE_ID")
    private int id;

    @Column(name="ASSIGNED_ROLE")
    private String role;

    public Role() {
    }

    @ManyToMany(mappedBy = "roleList")
    private Set<User> userSet=new HashSet<>();

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", userSet=" + userSet +
                '}';
    }
}
