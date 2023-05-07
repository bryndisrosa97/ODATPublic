package is.hi.hbv501g.ODAT.Services.Implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv501g.ODAT.Entities.Tfolder;
import is.hi.hbv501g.ODAT.Repositories.TfolderRepository;
import is.hi.hbv501g.ODAT.Services.TfolderService;

@Service
public class TfolderServiceImplementation implements TfolderService {

    TfolderRepository repository;

    @Autowired
    public TfolderServiceImplementation(TfolderRepository tfolderRepository) {
        this.repository = tfolderRepository;
    }

    @Override
    public Tfolder save(Tfolder foldername) {
        return repository.save(foldername);
    }

    @Override
    public void delete(Tfolder foldername) {
        repository.delete(foldername);
    }

    @Override
    public List<Tfolder> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Tfolder> findById(long id) {
        return repository.findById(id);
    }

}
