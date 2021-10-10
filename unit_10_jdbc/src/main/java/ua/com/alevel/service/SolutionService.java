package ua.com.alevel.service;

import ua.com.alevel.dao.SolutionDao;
import ua.com.alevel.model.Solution;

import java.sql.Connection;
import java.util.List;

public class SolutionService {
    private SolutionDao solutionDao ;
    private Solution solution;


    public List<Solution> setSolutionToDB(List<Solution> solutions) {
        solutionDao.insert(solutions);
        return new Solution();
    }
}
