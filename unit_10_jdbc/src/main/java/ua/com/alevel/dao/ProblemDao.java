package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.model.Problem;
import ua.com.alevel.model.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProblemDao {

    private static final Logger logger = LoggerFactory.getLogger(ProblemDao.class);
    private static final String SELECT_ALL_WITHOUT_SOLUTIONS = "SELECT p.id, p.from_id, p.to_id FROM problems p LEFT JOIN  solutions s ON p.id = s.problem_id WHERE s.problem_id IS NULL ";
    private static final String SELECT_ID_COST = "SELECT problems.from_id, problems.to_id, routes.cost FROM problems, routes WHERE id NOT IN (SELECT problem_id FROM solutions ";
    private final Connection connection;

    public ProblemDao(Connection connection) {
        this.connection = connection;
    }

    public List<Problem> findAll() {
        List<Problem> problemList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_WITHOUT_SOLUTIONS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int fromId = resultSet.getInt("from_id");
                int toId = resultSet.getInt("to_id");
                problemList.add(new Problem(id, fromId, toId));
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        return problemList;
    }

    public List<Route> routesForSolution() {
        List<Route> newRoutesForSolution = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ID_COST);
            while (resultSet.next()) {
                int fromId = resultSet.getInt("from_id");
                int toId = resultSet.getInt("to_id");
                int cost = resultSet.getInt("cost");
                newRoutesForSolution.add(new Route(fromId, toId, cost));
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        return newRoutesForSolution;
    }
}
