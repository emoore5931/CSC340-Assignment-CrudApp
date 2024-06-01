package com.csc340.jpademo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Object getTasksForGoal(int goalId) {
        return taskRepository.getTasksByGoalId(goalId);
    }

    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

    public void removeTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task getTaskById(int taskId) {
        return taskRepository.getTaskById(taskId);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }
}
