package com.example.missingCats.kittys;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Cat {
    @Id
    @SequenceGenerator(
            name = "cat_sequence",
            sequenceName = "cat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cat_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private Integer age;

    public Cat() {
    }

    public Cat(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.description = email;
        this.age = age;
    }

    public Cat(String name, String description, Integer age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
