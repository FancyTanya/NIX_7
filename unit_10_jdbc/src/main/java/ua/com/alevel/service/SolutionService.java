package ua.com.alevel.service;

import ua.com.alevel.dao.SolutionDao;
import ua.com.alevel.model.Solution;

public class SolutionService {
    private SolutionDao solutionDao;
    private Solution solution = new Solution();

    public void setSolutionToDB() {
        solutionDao.insert(solution);
    }
}
