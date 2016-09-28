package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sigmarb on 28.9.2016.
 */
public class VideoServiceStub implements VideoService
{
    private List<User> _users;


    public VideoServiceStub()
    {
        _users = new ArrayList<User>();
    }
    public VideoServiceStub(List<User> users)
    {
        _users = users;
    }


    public List<Video> getVideosbyUser(int userId) throws ServiceException
    {
        List<Video> tmp;
        for (User u:_users)
        {
            if(userId == u.getId())
            {
                tmp = u.getVideos();
            }
        }

        throw new ServiceException();
    }


    public int addVideo(Video video, int userId) throws ServiceException
    {
        for (User u:_users)
        {
            if(u.getId() == userId)
            {
                u.addVideo(video);
            }
        }
        return 0;
    }


    public Video getVideo(int videoId) throws ServiceException
    {
        List<Video> tmp;
        Video tmpVideo;
        for (User u:_users)
        {
            tmp = u.getVideos();

            for (Video v:u.getVideos())
            {
                if(v.getVideoId() == videoId)
                {
                    tmpVideo = v;
                }
            }
        }
        throw new ServiceException();
    }
}
