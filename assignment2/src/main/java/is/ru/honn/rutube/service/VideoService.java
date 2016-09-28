package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.Video;

import java.util.List;

/**
 * Created by sigmarb on 28.9.2016.
 */

    public interface VideoService
    {
        List<Video> getVideosbyUser(int userId) throws ServiceException;
        int addVideo(Video video, int userId) throws ServiceException;
        Video getVideo(int videoId) throws ServiceException;
    }


