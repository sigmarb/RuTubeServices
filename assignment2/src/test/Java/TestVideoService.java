/**
 * Created by Asgeir on 30/09/2016.
 */
import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import is.ru.honn.rutube.service.UserService;
import is.ru.honn.rutube.service.ServiceException;
import is.ru.honn.rutube.service.UserServiceStub;
import is.ru.honn.rutube.service.VideoServiceStub;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


public class TestVideoService {
    VideoServiceStub service;

    @Before
    public void setup() {
        User user1 = new User(65509522, "Laura", "Kenedy", "lkenedy@usatoday.com", "Bérangére", "2015-11-07");
        User user2 = new User(98406777, "Jeremy", "Cooper", "jcooper1@whitehouse.gov", "Kallisté", "2065-09-18");
        List<User> listUSER = new ArrayList<User>();
        listUSER.add(user1);
        listUSER.add(user2);

        List<String> TAGS = new ArrayList<String>();
        TAGS.add("UNHEALTHY");
        TAGS.add("ONION");

        List<Video> list = new ArrayList<Video>();
        Video video1 = new Video(93074428, "PULSA", "HOW TO EAT A PULSA", "WWW.PULSUHUB.COM", "LIVESTREAM", TAGS);
        user1.addVideo(video1);

        list.add(video1);
        service = new VideoServiceStub(listUSER);
    }

    @Test
    public void testAddVideoToUser() {
        List<String> TAGS = new ArrayList<String>();
        TAGS.add("UNHEALTHY");
        TAGS.add("ONION");

        Video testvideo = new Video(12, "PULLA", "HOW TO EAT A PULSA", "WWW.PULLUHUB.COM", "LIVESTREAM", TAGS);

        int videoSize = -1;
        try {
            videoSize = service.addVideo(testvideo, 65509522);
        } catch (ServiceException e) {
        }

        int videoCount = 0;
        try {
            videoCount = service.getVideosbyUser(65509522).size();
        } catch (ServiceException e) {
        }
        assertEquals(2,videoCount);
    }

    @Test
    public void testAddVideoThatFailsVideoIdTaken() {
        List<String> TAGS = new ArrayList<String>();
        TAGS.add("UNHEALTHY");
        TAGS.add("ONION");
        Video testvideo = new Video(93074428, "PULSA", "HOW TO EAT A PULSA", "WWW.PULSUHUB.COM", "LIVESTREAM", TAGS);
        try {
            int userSize = service.addVideo(testvideo,98406777);
        } catch (ServiceException e) {
            assertEquals("VideoId taken", e.getMessage());
        }
    }

    @Test
    public void testAddVideoThatFailsVideoSourceTaken() {
        List<String> TAGS = new ArrayList<String>();
        TAGS.add("UNHEALTHY");
        TAGS.add("ONION");
        Video testvideo = new Video(93074428, "PULSA", "HOW TO EAT A PULSA", "WWW.PULSUHUB.COM", "LIVESTREAM", TAGS);
        try {
            int userSize = service.addVideo(testvideo,98406777);
        } catch (ServiceException e) {
            assertEquals("Source taken", e.getMessage());
        }
    }

    @Test
    public void testAddVideoThatFailsVideoTitleTaken() {
        List<String> TAGS = new ArrayList<String>();
        TAGS.add("UNHEALTHY");
        TAGS.add("ONION");
        Video testvideo = new Video(93074428, "PULSA", "HOW TO EAT A PULSA", "WWW.PULSUHUB.COM", "LIVESTREAM", TAGS);
        try {
            int userSize = service.addVideo(testvideo,98406777);
        } catch (ServiceException e) {
            assertEquals("Title taken", e.getMessage());
        }
    }


    @Test
    public void testGetVideoThatDoesNotExist() {
        int VideoId = 3000;
        Video newVideo = null;
        try {
            newVideo= service.getVideo(VideoId);
        } catch (ServiceException e) {
            assertEquals("No video found", e.getMessage());
        }

    }

}
