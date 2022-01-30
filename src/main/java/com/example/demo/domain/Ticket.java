package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = Long.valueOf(0);

    String title = "";
    String description = "";
    String category = "";

    @ManyToOne @JoinColumn(name = "user_creator_id")
    User user_creator;




    // ---------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser_creator() {
        return user_creator;
    }

    public void setUser_creator(User user_creator) {
        this.user_creator = user_creator;
    }
}
