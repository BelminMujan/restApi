package service;

import model.Znamenitost;

import java.util.List;

public interface ZnamenitostService {
    List<Znamenitost> getAllZnamenitosti();
    Znamenitost getZnamenitost(long id);
    Znamenitost createZnamenitost(Znamenitost znamenitost);
    Znamenitost updateZnamenitost(Znamenitost znamenitost);
    void deleteZnamenitost(long id);
}
