package is.hi.hbv501g.ODAT.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv501g.ODAT.Entities.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long>{
    
    Goal save(Goal goal);
    void delete(Goal goal);
    //void edit(Goal goal);
    List<Goal> findAll();
    Optional<Goal> findById(long id);
}
