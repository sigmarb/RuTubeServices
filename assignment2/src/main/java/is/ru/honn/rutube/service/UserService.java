package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

import java.util.List;

/**
 * Created by sigmarb on 28.9.2016.
 */
public interface UserService
{
    int addUser(User user) throws ServiceException;
    User getUser(int id) throws ServiceException;
    List<User> getUsers();
}