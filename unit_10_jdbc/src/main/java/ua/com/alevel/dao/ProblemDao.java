package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.model.Problem;
import ua.com.alevel.model.Route;
import ua.com.alevel.model.Solution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemDao {

    private static final Logger logger = LoggerFactory.getLogger(ProblemDao.class);

    private final Connection connection;

    public ProblemDao(Connection connection) {
        this.connection = connection;
    }

    public List<Problem> findAll() {
        List<Problem> problemList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT p.id, p.from_id" +
                    ", p.to_id FROM problems p LEFT JOIN  solutions s ON p.id = s.problem_id WHERE s.problem_id IS NULL ");
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


    public void insert(List<Solution> solutions) {
        Solution solution = new Solution();
        try(PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO solutions (problem_id, cost) VALUES(?, ?)")) {
            for (Solution sol: solutions) {
                statement.setInt(1, solution.getProblemId());
                statement.setInt(2, solution.getCost());
            }

        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
    }
}
