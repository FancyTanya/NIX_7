package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.model.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDao {

    private static final Logger logger = LoggerFactory.getLogger(LocationDao.class);
    private final Connection connection;

    private static final String FIND_ALL = "SELECT * FROM locations ";

    public LocationDao(Connection connection) {
        this.connection = connection;
    }

    public List<Location> findAll(int locationId) {
        List<Location> locationList = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            statement.setInt(1, locationId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                locationList.add(new Location(name));

            }
        } catch (SQLException throwables) {
            logger.warn(throwables.getMessage());
        }
        return locationList;
    }

}
