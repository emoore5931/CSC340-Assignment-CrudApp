package com.csc340.jpademo.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {
    @Autowired
    GoalRepository goalRepository;

    public Object getAllGoals() {
        return goalRepository.findAll();
    }

    public Object getGoalsByTitle(String title) {
        return goalRepository.getGoalByTitle(title);
    }

    public void addNewGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public Goal getGoalById(int id) {
        return goalRepository.getGoalById(id);
    }

    public void removeGoal(int goalId) {
        goalRepository.deleteById(goalId);
    }

    public void updateGoal(Goal goal) {
        goalRepository.save(goal);
    }
}