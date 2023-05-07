package is.hi.hbv501g.ODAT.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv501g.ODAT.Entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task save(Task task);
    void delete(Task task);
    List<Task> findAll();
    Optional<Task> findById(long id);

}
