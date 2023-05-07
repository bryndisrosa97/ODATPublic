package is.hi.hbv501g.ODAT.Services.Implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv501g.ODAT.Entities.Goal;
import is.hi.hbv501g.ODAT.Repositories.GoalRepository;
import is.hi.hbv501g.ODAT.Services.GoalService;

@Service
public class GoalServiceImplementation implements GoalService {
    GoalRepository repository;

    @Autowired
    public GoalServiceImplementation(GoalRepository goalRepository){
        this.repository = goalRepository;
    }

    @Override
    public Goal save(Goal goal) {
        return repository.save(goal);
    }

    @Override
    public void delete(Goal goal) {
        repository.delete(goal);
    }

    /*
    @Override
    public void edit(Goal goal) {
        repository.edit(goal);
    }*/

    @Override
    public List<Goal> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Goal> findById(long id) {
        return repository.findById(id);
    }

}
