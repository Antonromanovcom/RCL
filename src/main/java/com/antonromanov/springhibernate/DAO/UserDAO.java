package com.antonromanov.springhibernate.DAO;

import com.antonromanov.springhibernate.model.User;
import java.util.List;

public interface UserDAO {
    public List<User> getPersonList();
}
