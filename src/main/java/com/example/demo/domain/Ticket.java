package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String title = "";
    private String description = "";
    private String category = "";

    @ManyToOne @JoinColumn(name = "user_creator_id")
    private User user_creator;




    // ---------------------------------------------------------------------
    public User getUser_creator() {
        return user_creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
