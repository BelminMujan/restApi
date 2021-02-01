package task.job.restApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.job.restApi.exceptions.ResourceNotFoundException;
import task.job.restApi.model.Opcina;
import task.job.restApi.repository.OpcinaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OpcinaServiceImlp implements OpcinaService {

    @Autowired
    public OpcinaRepository opcinaRepository;

    @Override
    public List<Opcina> getAllOpcine() {
        return opcinaRepository.findAll();
    }

    @Override
    public Opcina getOpcina(long id) {
        Optional<Opcina> opcinaDb=this.opcinaRepository.findById(id);
        if(opcinaDb.isPresent()){
            return opcinaDb.get();
        }else{
            throw new ResourceNotFoundException("Ne postoji opcina sa id: "+id);
        }
    }

    @Override
    public Opcina addOpcina(Opcina opcina) {
        return this.opcinaRepository.save(opcina);
    }

    @Override
    public void deleteOpcina(long opcinaId) {
        Optional<Opcina> opcinaDb=this.opcinaRepository.findById(opcinaId);
        if(opcinaDb.isPresent()){
            this.opcinaRepository.delete(opcinaDb.get());
        }else{
            throw new ResourceNotFoundException("Nije pronadjena opcina sa ID: "+opcinaId);
        }
    }

    @Override
    public Opcina updateOpcina(long opcinaId) {
        return null;
    }
}
