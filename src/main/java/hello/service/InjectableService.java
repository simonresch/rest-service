package hello.service;

import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class InjectableService {

    @Autowired
    private DataSource dataSource;

    public User findUserByName(final String name) {
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM users WHERE firstName = '" + name + "'");
             ) {
            User user = new User();
            if (!result.next()) {
                return user;
            }
            user.setId(result.getInt("id"));
            user.setFirstName(result.getString("firstName"));
            user.setLastName(result.getString("lastName"));
            user.setEmail(result.getString("email"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }
}
