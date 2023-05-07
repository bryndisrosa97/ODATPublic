package is.hi.hbv501g.ODAT.Services.Implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv501g.ODAT.Entities.Task;
import is.hi.hbv501g.ODAT.Repositories.TaskRepository;
import is.hi.hbv501g.ODAT.Services.TaskService;

@Service
public class TaskServiceImplementation implements TaskService {

    TaskRepository repository;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository) {
        this.repository = taskRepository;
    }

    @Override
    public Task save(Task task) {
        return repository.save(task);
    }

    @Override
    public void delete(Task task) {
        repository.delete(task);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Task> findById(long id) {
        return repository.findById(id);
    }

}
