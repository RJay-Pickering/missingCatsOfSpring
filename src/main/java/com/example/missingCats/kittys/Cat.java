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
    private Long animal_id;
    private String name;
    private String description;
    private Integer age;

    public Cat() {
    }

    public Cat(Long animal_id, String name, String email, Integer age) {
        this.animal_id = animal_id;
        this.name = name;
        this.description = email;
        this.age = age;
    }

    public Cat(String name, String description, Integer age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public Long getAnimalId() {
        return animal_id;
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
                "animal_id=" + animal_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                '}' + '\'';
    }
}
