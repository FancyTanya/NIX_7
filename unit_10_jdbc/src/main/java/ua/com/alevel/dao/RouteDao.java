package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.model.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDao {
   public Route route;
   private static final Logger logger = LoggerFactory.getLogger(RouteDao.class);
    private final Connection connection;

    private static final String FIND_ALL = "SELECT * FROM routes ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM routes WHERE id=?";

    public RouteDao(Connection connection) {
        this.connection = connection;
    }


    public List<Route> findById(int routeId) {
        List<Route> routeList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, routeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int fromId = resultSet.getInt("from_id");
                int toId = resultSet.getInt("to_id");
                int cost = resultSet.getInt("cost");
                routeList.add(new Route(id, fromId, toId, cost));
            }

        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        return routeList;
    }


}
