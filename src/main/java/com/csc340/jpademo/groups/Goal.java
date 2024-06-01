package com.csc340.jpademo.groups;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToMany(mappedBy = "goals", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private int goalId;
    private int userId;
    @Nonnull
    private String title;
    private String details;
    @Temporal(TemporalType.DATE)
    private Date targetDate;
    private String status;

    public Goal(int goalId, int userId, String details, @Nonnull String title, String status, Date targetDate) {
        this.goalId = goalId;
        this.userId = userId;
        this.details = details;
        this.title = title;
        this.status = status;
        this.targetDate = targetDate;
    }

    public Goal() {
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
