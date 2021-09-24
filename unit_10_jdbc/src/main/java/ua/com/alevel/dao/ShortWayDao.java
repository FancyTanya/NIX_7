package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.ShortWayMain;
import ua.com.alevel.entity.Graph;
import ua.com.alevel.model.Problem;
import ua.com.alevel.model.Solution;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


public class ShortWayDao {
    private static ShortWayDao instance;
    public Graph graph = new Graph();
    private static final Logger logger = LoggerFactory.getLogger(ShortWayMain.class);

    Properties props = loadProperties();
    String url = props.getProperty("url");


    private static final String DELETE = "DELETE FROM user WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM ";
    private static final String FIND_BY_ID = "SELECT * FROM problems WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM locations WHERE name=?";
    private static final String INSERT = "INSERT INTO solutions(cost) VALUES(?)";
    private static final String UPDATE = "UPDATE routes SET from_id=?, to_id=?, cost=? WHERE id=?";

    private ShortWayDao() {
        super();
    }

    Properties properties = loadProperties();

    public static ShortWayDao getInstance() {
        if (instance == null) {
            instance = new ShortWayDao();
        }
        return instance;
    }

    public HashMap shortWayPath() {
        return graph.mapOfVertexAndMinDistance();
    }

    public List<Problem> findAllProblems() throws SQLException {

        List<Problem> problems = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, props);
            connection.setAutoCommit(false);
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_ALL + "solutions");

                while (resultSet.next()) {
                    Problem problem = new Problem();
                    problem.setId(resultSet.getInt("id"));
                    problem.setFromId(resultSet.getInt("fromId"));
                    problem.setToId(resultSet.getInt("toId"));

                    problems.add(problem);
                }
            } catch (SQLException e) {
            connection.rollback();
            logger.warn(e.getMessage());
            throw new RuntimeException(e);
        }
          } catch (SQLException e) {
        connection.rollback();
        logger.warn(e.getMessage());
        throw new RuntimeException(e);
    } finally {
            close(statement);
            close(connection);
        }
        return problems;
    }

    public int insertSolutions(Solution solution) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url, props);
            int result = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                solution.setProblemId(resultSet.getInt(1));
            }
            return result;
        } catch (SQLException e) {
            logger.warn(e.getMessage());
            throw new RuntimeException();
        } finally {
            close(statement);
            close(connection);
        }
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = ShortWayMain.class.getResourceAsStream("/jdbc.properties"))
        {
            properties.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return properties;
    }

    private static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                logger.warn(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    private static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                logger.warn(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
}





