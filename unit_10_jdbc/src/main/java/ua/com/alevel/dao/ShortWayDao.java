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
import java.util.List;
import java.util.Properties;

public class ShortWayDao {
    public ShortWayDao shortWayDao = new ShortWayDao();
    private static final Logger logger = LoggerFactory.getLogger(ShortWayMain.class);

    Properties props = loadProperties();
    String url = props.getProperty("url");
    Connection connection ;
    Statement statement ;

    private static final String FIND_ALL = "SELECT * FROM ";

    public List<Problem> findAllProblems() throws SQLException {

        List<Problem> problems = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(url, props)) {
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
        }
        return problems;
    }

    public int insertSolutions(Solution solution) {
        PreparedStatement statement = null;

        try(Connection connection = DriverManager.getConnection(url, props)) {

            int result = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                solution.setProblemId(resultSet.getInt(1));
            }
            return result;
        } catch (SQLException e) {
            logger.warn(e.getMessage());
            throw new RuntimeException();
        }
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = ShortWayMain.class.getResourceAsStream("/jdbc.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return properties;
    }

//    private static void close(Connection con) {
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                logger.warn(e.getMessage());
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private static void close(Statement stmt) {
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                logger.warn(e.getMessage());
//                throw new RuntimeException(e);
//            }
//        }
//    }
}





