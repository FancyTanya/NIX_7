package ua.com.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.DAO;
import ua.com.alevel.model.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RouteImpl implements DAO {
   public Route route;
    private static final Logger logger = LoggerFactory.getLogger(RouteImpl.class);

    private final Connection connection;
    private static final String DELETE = "DELETE FROM user WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM user ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM user WHERE name=?";
    private static final String INSERT = "INSERT INTO user(name, tel, passwd) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE user SET name=?, tel=?, passwd=? WHERE id=?";

    public RouteImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Object model) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(INSERT))
        {
            statement.setInt(1, route.getId());
            statement.setInt(2, route.getFromId());
            statement.setInt(3, route.getToId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        return result;
    }

    @Override
    public Object read(Object o) {
        return null;
    }

    @Override
    public boolean update(Object model) {
        return false;
    }

    @Override
    public boolean delete(Object model) {
        return false;
    }
}
