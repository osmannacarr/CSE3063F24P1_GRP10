package org.example.business;

import org.example.dataAccess.AdvisorDao;
import org.example.entities.Advisor;

import java.util.List;

public class AdvisorManager implements AdvisorService{

    AdvisorDao _advisorDao;

    public AdvisorManager(AdvisorDao advisorDao){
        _advisorDao = advisorDao;
    }

    @Override
    public List<Advisor> getAll() {
        return _advisorDao.getAll();
    }

    @Override
    public Advisor getById(int id) {
        return _advisorDao.getById(id);
    }

    @Override
    public void insert(Advisor advisor) {
        _advisorDao.insert(advisor);
    }

    @Override
    public void update(Advisor advisor) {
        _advisorDao.update(advisor);
    }

    @Override
    public void delete(Advisor advisor) {
        _advisorDao.delete(advisor);
    }
}
