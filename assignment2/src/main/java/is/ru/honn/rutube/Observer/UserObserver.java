package is.ru.honn.rutube.Observer;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by sigmarb on 3.10.2016.
 */
public class UserObserver extends Observer
{

    @Override
    public void update(User u)
    {
        System.out.println("Id: " + u.getUserId());
        System.out.println("First name: " + u.getFirstName());
        System.out.println("Last name: " + u.getLastName());
        System.out.println("Email: " + u.getEmail());
        System.out.println("Display Name: " + u.getDisplayName());
        System.out.println("Birth date: " + u.getBirthDate());
        System.out.println("Number of videos: " + u.getVideos().size());
    }
}