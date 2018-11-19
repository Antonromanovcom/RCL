package com.antonromanov;


import com.antonromanov.springhibernate.DAO.UserDAOImpl;
import com.antonromanov.springhibernate.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/Spring-Module.xml")
public class DaoTests {

    @Autowired
    private UserDAOImpl personDao;

    @Test
    public void testCrudOperations() {

        //loading all
        List<User> testedList = personDao.getPersonList();
        System.out.println("All loaded: " + testedList);
        Assert.assertTrue(testedList.size() > 0);
    }
}
