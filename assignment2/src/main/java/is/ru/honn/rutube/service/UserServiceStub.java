package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sigmarb on 28.9.2016.
 */
public class UserServiceStub implements UserService
{
    private List<User> _users;

    public UserServiceStub() {
        _users = new ArrayList<User>();
    }
    public UserServiceStub(List<User> users) {
        _users = users;
    }

    public int addUser(User user) throws ServiceException {
        return 1;
    }

    public User getUser(int id) {
        
    }

    public List<User> getUsers()
    {
        return _users;
    }
}
