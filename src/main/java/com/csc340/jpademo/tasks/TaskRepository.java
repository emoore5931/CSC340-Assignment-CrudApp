package com.csc340.jpademo.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "select * from tasks where goal_id = ?1", nativeQuery = true)
    public List<Task> getTasksByGoalId(int goalId);

    @Query(value = "select * from tasks where task_id = ?1", nativeQuery = true)
    public Task getTaskById(int taskId);
}
