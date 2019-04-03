package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NamedNativeQueries({
        @NamedNativeQuery(name = "Company.findCompanyByFirstThreeLetters",
                query = "SELECT * FROM Company" +
                        " WHERE substr(company_name,1,3) = :COMPANY_NAME",
                resultClass = Company.class
        ),
        @NamedNativeQuery(name = "Company.findCompanyByAnyFragment",
                query = "SELECT * FROM Company" +
                        " WHERE company_name LIKE :COMPANY_NAME",
                resultClass = Company.class)
})
@Entity
public class Company {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    private int id;

    @NotNull
    @Column(name = "COMPANY_NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}