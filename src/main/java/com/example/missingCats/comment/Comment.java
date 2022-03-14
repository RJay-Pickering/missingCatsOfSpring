package com.example.missingCats.comment;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    private Long id;
    private Integer animal_id;
    private Integer human_id;
    private String body;

    public Comment() {
    }

    public Comment(Long id, Integer animal_id, Integer human_id, String body) {
        this.id = id;
        this.animal_id = animal_id;
        this.human_id = human_id;
        this.body = body;
    }

    public Comment(Integer animal_id, Integer human_id, String body) {
        this.animal_id = animal_id;
        this.human_id = human_id;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public Integer getAnimal() {
        return animal_id;
    }

    public Integer getHuman() {
        return human_id;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "animal='" + animal_id + '\'' +
                ", human='" + human_id + '\'' +
                ", body=" + body +
                '}' + '\'';
    }
}

