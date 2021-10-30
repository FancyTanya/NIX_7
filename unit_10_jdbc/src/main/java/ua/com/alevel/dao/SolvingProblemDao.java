package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.model.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SolvingProblemDao {

    private static final Logger logger = LoggerFactory.getLogger(SolvingProblemDao.class);
    private final Connection connection;

    public SolvingProblemDao(Connection connection) {
        this.connection = connection;
    }

    public List<Route> routesForSolution() {
        List<Route> newRoutesForSolution = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT problems.from_id," +
                    " problems.to_id, routes.cost FROM problems, routes WHERE id NOT IN (SELECT problem_id FROM solutions ");
            while (resultSet.next()) {
                int fromId = resultSet.getInt("from_id");
                int toId = resultSet.getInt("to_id");
                int cost = resultSet.getInt("cost");
                newRoutesForSolution.add(new Route(fromId, toId, cost));
            }
        } catch (SQLException e) {
            logger.warn("SQL exception", e);
        }
        return newRoutesForSolution;
    }
}
