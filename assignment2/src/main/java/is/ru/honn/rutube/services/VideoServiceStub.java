package is.ru.honn.rutube.services;

import is.ru.honn.rutube.domain.Video;

import java.util.List;

/**
 * Created by sigmarb on 28.9.2016.
 */
public class VideoServiceStub implements VideoService
{
    List<Video> getVideosbyUser(int userId);
    int addVideo(Video video, int userId) throws ServiceException;
    Video getVideo(int videoId);
}
