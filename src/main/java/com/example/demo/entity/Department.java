package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {
	@Id
    private int id;

    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;

    @Column(name = "location", length = 100)
    private String location;

//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//    private List<Employee> employees;
	   public Department() {
		super();
	}

	public Department(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



	

}
