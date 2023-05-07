package is.hi.hbv501g.ODAT.Services;

import java.util.List;
import java.util.Optional;

import is.hi.hbv501g.ODAT.Entities.Tfolder;

public interface TfolderService {

    Tfolder save(Tfolder foldername);
    void delete(Tfolder foldername);
    List<Tfolder> findAll();
    Optional<Tfolder> findById(long id);

}
