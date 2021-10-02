package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.*;
import ua.com.alevel.model.Problem;
import ua.com.alevel.model.Solution;
import ua.com.alevel.service.GraphService;
import ua.com.alevel.service.SolutionService;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class ShortWayMain {
    private static final Logger logger = LoggerFactory.getLogger(ShortWayMain.class);

    public static void main(String[] args) {

        ProblemDao problemDao;
        SolutionService solutionService = new SolutionService();
        GraphService graphService = new GraphService();
        Properties props = loadProperties();
        String url = props.getProperty("url");

        try(Connection connection = DriverManager.getConnection(url, props)) {
            problemDao = new ProblemDao(connection);
            List<Problem> allProblems = problemDao.findAll();
            HashMap mapCityAndMinDistance = graphService.startGraphService();
            var solution = solutionService.setSolutionToDB();

        } catch (SQLException e) {
            logger.warn(e.getMessage());
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
}
