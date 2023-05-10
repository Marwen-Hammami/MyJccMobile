/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vote;
import java.util.ArrayList;
import java.util.List;

public class ListVote {

    private List<Vote> votes;

    public ListVote() {
        this.votes = new ArrayList<>();
    }

    public void addVote(Vote vote) {
        this.votes.add(vote);
    }

    public void removeVote(Vote vote) {
        this.votes.remove(vote);
    }

    public List<Vote> getVotes() {
        return this.votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void printVotes() {
        for (Vote vote : this.votes) {
            System.out.println(vote.toString());
        }
    }
}