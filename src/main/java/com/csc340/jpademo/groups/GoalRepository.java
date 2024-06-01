package com.csc340.jpademo.groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

    @Query(value = "select * from goals where title like ?1%", nativeQuery = true)
    public List<Goal> getGoalByTitle(String title);

    @Query(value = "select * from goals where goal_id = ?1", nativeQuery = true)
    public Goal getGoalById(int id);
}
