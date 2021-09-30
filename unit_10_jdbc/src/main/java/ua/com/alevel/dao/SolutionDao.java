package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.model.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SolutionDao {
    Logger logger = LoggerFactory.getLogger(SolutionDao.class);
    private static final String INSERT = "INSERT INTO solutions(problem_id, cost) VALUES(?,?)";

    private final Connection connection;

    public SolutionDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(Solution solution) {
        try(PreparedStatement statement = connection.prepareStatement(INSERT)) {
            connection.setAutoCommit(false);
            statement.setInt(1, solution.getProblemId());
            statement.setInt(2, solution.getCost());
            statement.addBatch();
            statement.executeBatch();

            connection.commit();

        } catch (SQLException throwables) {
            logger.warn(throwables.getMessage());
        }
    }

}
