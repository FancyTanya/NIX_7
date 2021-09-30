package ua.com.alevel.service;

import ua.com.alevel.dao.ProblemDao;
import ua.com.alevel.dao.ShortWayDao;
import ua.com.alevel.model.Problem;

import java.util.List;

public class ProblemService {
    private ProblemDao problemDao;
    List<Problem> problemList;

    public List<Problem> findAllProblems() {
        List<Problem> problemList = problemDao.findAll();
        return problemList;
    }
}
