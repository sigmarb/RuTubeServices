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
        _users = new ArrayList<User>(users);
    }


    public List<Video> getVideosbyUser(int userId) throws ServiceException
    {
        List<Video> tmp;
        for (User u:_users)
        {
            if(userId == u.getUserId())
            {
                tmp = u.getVideos();
                return tmp;
            }
        }

        throw new ServiceException("No user found");
    }


    //if (u.getUserId() == user.getUserId()) {
    //throw new ServiceException("UserId taken");

    public int addVideo(Video video, int userId) throws ServiceException
    {
        for (User u:_users)
        {
            if(u.getUserId() == userId)
            {
                for (Video V:u.getVideos())
                {
                    if (video.getVideoId() == V.getVideoId())
                    {
                        throw new ServiceException("VideoId taken");
                    }
                    if (video.getSource() == V.getSource())
                    {
                        throw new ServiceException("Source taken");
                    }
                    if (video.getTitle() == V.getTitle())
                    {
                        throw new ServiceException("Title taken");
                    }
                }
                u.addVideo(video);
                return u.getVideos().size();
            }
        }
        throw new ServiceException("No user found");
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
        throw new ServiceException("No video found");
    }
}
