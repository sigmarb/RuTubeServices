package is.ru.honn.rutube.service;

import is.ru.honn.rutube.Observer.Subject;
import is.ru.honn.rutube.Observer.UserObserver;
import is.ru.honn.rutube.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sigmarb on 28.9.2016.
 */
public class UserServiceStub implements UserService
{
    private List<User> _users;

    public UserServiceStub()
    {
        _users = new ArrayList<User>();
    }
    public UserServiceStub(List<User> users)
    {
        _users = new ArrayList<User>(users);
    }

    public int addUser(User user) throws ServiceException
    {
        for (User u: _users)
        {
            if (u.getUserId() == user.getUserId()) {
                throw new ServiceException("UserId taken");
            }
            if (u.getEmail().equals(user.getEmail())) {
                throw new ServiceException("Email already in use");
            }
            if (u.getDisplayName().equals(user.getDisplayName()))
            {
                throw new ServiceException("Display name taken");
            }
        }
        _users.add(user);
        Subject subject = new Subject();
        UserObserver u = new UserObserver(subject);
        u.notifyAll(user);
        return _users.size();
    }

    public User getUser(int id) throws ServiceException
    {
        User tmp;
        for (User u:_users)
        {
            if(u.getUserId() == id)
            {
                tmp = u;
                return tmp;
            }
        }
        throw new ServiceException("No user found");
    }

    public List<User> getUsers()
    {
        return _users;
    }

}
