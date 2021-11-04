package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.ProblemDao;
import ua.com.alevel.graphUtil.Graph;
import ua.com.alevel.model.Problem;
import ua.com.alevel.model.Solution;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ShortWayMain {
    private static final Logger logger = LoggerFactory.getLogger(ShortWayMain.class);

    public static void main(String[] args) {

        ProblemDao problemDao;
        Properties props = new Properties();

        try (InputStream inputStream = ShortWayMain.class.getResourceAsStream("/jdbc.properties")) {
            props.load(inputStream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        try (Connection connection = DriverManager.getConnection(props.getProperty("url"), props)) {
            problemDao = new ProblemDao(connection);

            Graph graph = new Graph();

            List<Problem> allProblems = problemDao.findAll();

            List<Solution> solutions = graph.solutionFromGraph(graph, allProblems);

            problemDao.insert(solutions);

        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
    }

}
