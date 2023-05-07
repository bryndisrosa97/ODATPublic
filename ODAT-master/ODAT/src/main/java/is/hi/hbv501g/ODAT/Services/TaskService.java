package is.hi.hbv501g.ODAT.Services;

import java.util.List;
import java.util.Optional;

import is.hi.hbv501g.ODAT.Entities.Task;

public interface TaskService {

    Task save(Task task);
    void delete(Task task);
    List<Task> findAll();
    Optional<Task> findById(long id);

}
