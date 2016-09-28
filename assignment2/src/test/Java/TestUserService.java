import is.ru.honn.rutube.domain.Video;
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

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)

public class TestUserService extends TestCase {
    Logger log = Logger.getLogger(TestUserService.class.getName());
    UserServiceStub service;

    @Before
    public void setup() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:resources/spring.config");
        service = new VideoServiceStub();
    }
}
