package task.job.restApi.service;

import task.job.restApi.model.Opcina;

import java.util.List;

public interface OpcinaService {
    List<Opcina> getAllOpcine();
    Opcina getOpcina(long id);
    Opcina addOpcina(Opcina opcina);
    void deleteOpcina(long opcinaId);
    Opcina updateOpcina(long opcinaId);
}
