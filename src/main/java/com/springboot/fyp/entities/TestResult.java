package com.springboot.fyp.entities;

import jakarta.persistence.*;

@Table
@Entity
public class TestResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name="mockResultsimple", length=200)
	private String mockResultsimple;
	@Column(name="mockResultmedium", length=200)
	private String mockResultmedium;
	@Column(name="mockResulthard", length=200)
	private String mockResulthard;
	@Column(name="cvGrade", length=200)
	private String cvGrade;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
	private Users user;

	public TestResult() {
		super();
	}

	public String getMockResultsimple() {
		return mockResultsimple;
	}

	public void setMockResultsimple(String mockResultsimple) {
		this.mockResultsimple = mockResultsimple;
	}

	public String getMockResultmedium() {
		return mockResultmedium;
	}

	public void setMockResultmedium(String mockResultmedium) {
		this.mockResultmedium = mockResultmedium;
	}

	public String getMockResulthard() {
		return mockResulthard;
	}

	public void setMockResulthard(String mockResulthard) {
		this.mockResulthard = mockResulthard;
	}

	public String getCvGrade() {
		return cvGrade;
	}

	public void setCvGrage(String cvGrade) {
		this.cvGrade = cvGrade;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
