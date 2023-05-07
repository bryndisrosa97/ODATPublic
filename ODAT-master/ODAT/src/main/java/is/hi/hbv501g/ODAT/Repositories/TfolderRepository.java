package is.hi.hbv501g.ODAT.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv501g.ODAT.Entities.Tfolder;

public interface TfolderRepository extends JpaRepository<Tfolder, Long> {

    Tfolder save(Tfolder foldername);
    void delete(Tfolder foldername);
    List<Tfolder> findAll();
    Optional<Tfolder> findById(long id);

}
