package com.me;

import com.me.service.InsertService;
import com.me.service.serviceImpl.InsertServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Logan Zhou on 2018-03-23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

    @Autowired
    private InsertService insertService;

    @Test
    public void InsertTest(){
        long st = System.currentTimeMillis();
        insertService.insertData();
        long en = System.currentTimeMillis();
        System.out.println("1运行时间为"+(en-st));
    }
}
