package com.hyc.service;

import com.hyc.domain.Girl;
import com.hyc.exception.GirlException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by hyc26 on 2018-10-27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void getAgeById() throws Exception {
        Integer i = girlService.getAgeById(8);
        Assert.assertEquals(Integer.valueOf(20), i);
    }

    @Test(expected = GirlException.class)
    public void getAgeByIdFail() throws Exception {
        Integer i = girlService.getAgeById(7);
    }
}