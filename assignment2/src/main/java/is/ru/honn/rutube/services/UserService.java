package is.ru.honn.rutube.services;

import is.ru.honn.rutube.domain.User;

import java.util.List;

/**
 * Created by sigmarb on 28.9.2016.
 */
public interface UserService
{
    int addUser(User user) throws ServiceException;
    List<User> getUsers();
}