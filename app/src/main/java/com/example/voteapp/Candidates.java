package com.example.voteapp;

import java.io.Serializable;

public class Candidates implements Serializable {

    private String id;
    private String name;
    private int num_votes;

    public Candidates(String id, String name, int num_votes) {
        this.id = id;
        this.name = name;
        this.num_votes = num_votes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum_votes() {
        return num_votes;
    }

    public void setNum_votes(int num_votes) {
        this.num_votes = num_votes;
    }

    @Override
    public String toString() {
        return name;
    }
}
