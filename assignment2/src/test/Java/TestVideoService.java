import is.ru.honn.rutube.domain.Video;
import is.ru.honn.rutube.service.VideoService;
import is.ru.honn.rutube.service.ServiceException;
import is.ru.honn.rutube.service.VideoServiceStub;
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

public class TestVideoService extends TestCase {
    Logger log = Logger.getLogger(TestVideoService.class.getName());
    VideoServiceStub service;

    @Before
    public void setup() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:resources/spring.config");
        service = new VideoServiceStub();
    }
}
