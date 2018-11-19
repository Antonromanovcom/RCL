package com.dimitrisli.springJdbcOracle.dao.impl;

import com.dimitrisli.springJdbcOracle.dao.LocationDao;
import com.dimitrisli.springJdbcOracle.model.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/context/applicationContext.xml")
@TransactionConfiguration(transactionManager = "jdbcTransactionManager", defaultRollback = true)
@Transactional
public class LocationDaoTest {

    @Inject private LocationDao locationDao;

    @Test
    public void testSelectAllLocations(){
    List<String> locations = locationDao.getLocations();
    assertThat(locations.size(), is(1));
    }



}
