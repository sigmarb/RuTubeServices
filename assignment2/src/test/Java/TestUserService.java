import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.service.UserService;
import is.ru.honn.rutube.service.ServiceException;
import is.ru.honn.rutube.service.UserServiceStub;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


public class TestUserService {
    UserServiceStub service;

    @Before
    public void setup() {
        User user1 = new User(65509522, "Laura", "Kenedy", "lkenedy@usatoday.com", "Bérangére", "2015-11-07");
        User user2 = new User(98406777, "Jeremy", "Cooper", "jcooper1@whitehouse.gov", "Kallisté", "2065-09-18");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        service = new UserServiceStub(list);
    }

    @Test
    public void testAddUser() {
        User testUser = new User(12345, "Ásgeir", "Frímannsson", "asgeirf14@ru.is", "GeiriFriCool17", "1993-08-08");
        int userSize = -1;
        try {
            userSize = service.addUser(testUser);
        } catch (ServiceException e) {
        }
        assertEquals(3, userSize);
    }

    @Test
    public void testAddUserThatFailsUserIdTaken() {
        User testUser = new User(65509522, "Ásgeir", "Frímannsson", "asgeirf14@ru.is", "GeiriFriCool17", "1993-08-08");
        try {
            int userSize = service.addUser(testUser);
        } catch (ServiceException e) {
            assertEquals("UserId taken", e.getMessage());
        }
    }

    @Test
    public void testAddUserThatFailsUserEmailTaken() {
        User testUser = new User(26, "Ásgeir", "Frímannsson", "asgeirf14@ru.is", "GeiriFriCool17", "1993-08-08");
        try {
            int userSize = service.addUser(testUser);
        } catch (ServiceException e) {
            assertEquals("Email taken", e.getMessage());
        }
    }

    @Test
    public void testAddUserThatFailsUserDisplayNameTaken() {
        User testUser = new User(26, "Ásgeir", "Frímannsson", "asgeirf14@ru.is", "GeiriFriCool17", "1993-08-08");
        try {
            int userSize = service.addUser(testUser);
        } catch (ServiceException e) {
            assertEquals("Display name taken", e.getMessage());
        }
    }


    @Test
    public void testGetUser() {
        int userId = 65509522;
        User newUser = null;
        try {
            newUser = service.getUser(userId);
        } catch (ServiceException e) {

        }
        assertEquals("Laura",newUser.getFirstName());
        assertEquals("Kenedy",newUser.getLastName());
        assertEquals("lkenedy@usatoday.com",newUser.getEmail());
        assertEquals("Bérangére", newUser.getDisplayName());
        assertEquals(LocalDate.of(2015,11,07), newUser.getBirthDate());
    }

    @Test
    public void testGetUserThatDoesNotExist() {
        int userId = 3000;
        User newUser = null;
        try {
            newUser = service.getUser(userId);
        } catch (ServiceException e) {
            assertEquals("No user found", e.getMessage());
        }

    }

}
