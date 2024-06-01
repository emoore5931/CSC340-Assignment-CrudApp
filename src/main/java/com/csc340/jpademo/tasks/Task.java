package com.csc340.jpademo.tasks;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;
    @JoinColumn(referencedColumnName = "goal_id")
    private int goalId;
    @Nonnull
    private String title;
    private String details;
    private String status;

    public Task() {}

    public Task(int taskId, String status, int goalId, @Nonnull String title, String details) {
        this.taskId = taskId;
        this.status = status;
        this.goalId = goalId;
        this.title = title;
        this.details = details;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
