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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test.resources.spring.config")

public class TestUserService extends TestCase {
    Logger log = Logger.getLogger(TestUserService.class.getName());
    UserServiceStub service;

    @Before
    public void setup() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:..test.resources.spring.config");
        User user1 = (User)ctx.getBean("user1");
        User user2 = (User)ctx.getBean("user2");
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
        } catch(Exception e) {
            assertEquals(3, userSize);
        }
        assertEquals(3, userSize);
    }
}
