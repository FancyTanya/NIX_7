package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static ua.com.alevel.util.ConvertStringToTimestamp.convertStringToTimestamp;
import static ua.com.alevel.util.PrintToCSV.printToCSV;

;

public class ExportListOfOperationsToCSV {

    private static final Logger logger = LoggerFactory.getLogger(ExportListOfOperationsToCSV.class);
    private static final String SELECT_ALL = "SELECT * FROM Operation WHERE operationTime BETWEEN(?, ?) ";
    private final Connection connection;

    public ExportListOfOperationsToCSV(Supplier<Connection> connection) {
        this.connection = connection.get();

    }


    public void operationsByPeriodToCSV(String startData, String endData) {
        List<String> resultSetArray = new ArrayList<>();
        Timestamp start = convertStringToTimestamp(startData);
        Timestamp end = convertStringToTimestamp(endData);

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = null;
            statement.setTimestamp(1, start);
            statement.setTimestamp(2, end);

            resultSet = statement.executeQuery();
            int numColumns = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= numColumns; i++) {
                    sb.append(String.format(String.valueOf(resultSet.getString(i))) + " ");
                }
                resultSetArray.add(sb.toString());
                printToCSV(resultSetArray);
            }
        } catch (SQLException throwables) {
            logger.error("SQL exception " + throwables.getMessage());
        }
    }
//
//    private static Properties loadProperties() {
//        Properties properties = new Properties();
//        try (InputStream input = ExportListOfOperationsToCSV.class.getResourceAsStream("/jdbc.properties")) {
//            properties.load(input);
//        } catch (IOException e) {
//            throw new UncheckedIOException(e);
//        }
//        return properties;
//    }

}
