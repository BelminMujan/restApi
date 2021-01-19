package service;

import exceptions.ResourceNotFoundException;
import model.Znamenitost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ZnamenitostRepository;

import javax.swing.text.html.Option;
import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ZnamenitostServiceImpl implements ZnamenitostService{

    @Autowired
    private ZnamenitostRepository znamenitostRepository;


    @Override
    public List<Znamenitost> getAllZnamenitosti() {
        return this.znamenitostRepository.findAll();
    }

    @Override
    public Znamenitost getZnamenitost(long id) {
        Optional<Znamenitost> znamenitostDb=this.znamenitostRepository.findById(id);
        if (znamenitostDb.isPresent()){
            return znamenitostDb.get();
        }else{
            throw new ResourceNotFoundException("Nije pronadjena znamenitost sa ID: " + id);
        }
    }

    @Override
    public Znamenitost createZnamenitost(Znamenitost znamenitost) {
        return this.znamenitostRepository.save(znamenitost);
    }

    @Override
    public Znamenitost updateZnamenitost(Znamenitost znamenitost) {
        Optional<Znamenitost> znamenitostDb=this.znamenitostRepository.findById(znamenitost.getId());
        if (znamenitostDb.isPresent()){
            Znamenitost znamenitostUpdate=znamenitostDb.get();
            znamenitostUpdate.setId(znamenitost.getId());
            znamenitostUpdate.setNaziv(znamenitost.getNaziv());
            znamenitostUpdate.setOpis(znamenitost.getOpis());
            znamenitostUpdate.setLatitude(znamenitost.getLatitude());
            znamenitostUpdate.setLongitude(znamenitost.getLongitude());
            return znamenitostUpdate;
        }else{
            throw new ResourceNotFoundException("NIje pronadjena znamenitost sa id :"+znamenitost.getId());
        }
    }

    @Override
    public void deleteZnamenitost(long id) {
        Optional<Znamenitost> znamenitostDb=this.znamenitostRepository.findById(id);
        if(znamenitostDb.isPresent()){
            this.znamenitostRepository.delete(znamenitostDb.get());
        }else{
            throw new ResourceNotFoundException("Nije pronadjena znamenitost sa ID: " + id);
        }
    }
}
