package is.hi.hbv501g.ODAT.Services;

import java.util.List;
import java.util.Optional;

import is.hi.hbv501g.ODAT.Entities.Goal;

public interface GoalService {

    Goal save(Goal goal);
    void delete(Goal goal);
    //void edit(Goal goal);
    List<Goal> findAll();
	Optional<Goal> findById(long id);
    
}
