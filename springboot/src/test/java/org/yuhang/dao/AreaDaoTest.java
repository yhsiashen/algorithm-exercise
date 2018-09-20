package org.yuhang.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by chinalife on 2018/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    AreaDao areaDao;

    @Test
    public void queryAreaList() throws Exception {
       areaDao.queryAreaList();
    }

    @Test
    public void queryAreaById() throws Exception {

    }

    @Test
    public void insertArea() throws Exception {

    }

    @Test
    public void updateArea() throws Exception {

    }

    @Test
    public void deleteArea() throws Exception {

    }

}