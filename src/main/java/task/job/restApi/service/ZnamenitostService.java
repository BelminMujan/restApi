package task.job.restApi.service;

import task.job.restApi.model.Znamenitost;

import java.util.List;

public interface ZnamenitostService {
    List<Znamenitost> getAllZnamenitosti();
    Znamenitost getZnamenitost(long id);
    Znamenitost createZnamenitost(Znamenitost znamenitost);
    Znamenitost updateZnamenitost(Znamenitost znamenitost);
    void deleteZnamenitost(long id);
}
