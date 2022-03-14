package com.example.missingCats.user;

import javax.persistence.*;

@Entity
@Table
public class Owner {
    @Id
    @SequenceGenerator(
            name = "owner_sequence",
            sequenceName = "owner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "owner_sequence"
    )
    private Long human_id;
    private String name;
    private Integer age;

    public Owner() {
    }

    public Owner(Long human_id, String name, Integer age) {
        this.human_id = human_id;
        this.name = name;
        this.age = age;
    }

    public Owner(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getHumanId() {
        return human_id;
    }

    public void setHumanId(Long id) {
        this.human_id = human_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "human_id=" + human_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}' + '\'';
    }
}
