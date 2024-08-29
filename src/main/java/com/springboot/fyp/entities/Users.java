package com.springboot.fyp.entities;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "lastname", length = 200)
    private String lastName;

    @Column(name = "phoneNo", length = 200)
    private String phoneNo;

    @Column(name = "imageName", length = 200)
    private String imageName;

    @Column(name = "role", length = 200)
    private String role;

    @Column(name = "enabled", length = 200)
    private boolean enabled;
    @OneToOne(mappedBy = "")
    private TestResult testresult;

    public Users() {
        super();
    }

    // Getters and Setters

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public TestResult getTestresult() {
		return testresult;
	}

	public void setTestresult(TestResult testresult) {
		this.testresult = testresult;
	}

	public void setRole(String role) {
        this.role = role;
    }
    
}

