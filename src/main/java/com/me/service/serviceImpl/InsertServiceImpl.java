package com.me.service.serviceImpl;

import com.me.mybatis.entity.MeSysPortraitInfo;
import com.me.mybatis.mapper.MeSysPortraitInfoMapper;
import com.me.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * Created by Logan Zhou on 2018-03-23.
 */
@Service
public class InsertServiceImpl implements InsertService{

    @Autowired
    private MeSysPortraitInfoMapper meSysPortraitInfoMapper;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void insertData() {

        for (int i = 0; i < 100; i++) {
            MeSysPortraitInfo meSysPortraitInfo = new MeSysPortraitInfo();
            meSysPortraitInfo.setPortraitName("name-"+i);
            meSysPortraitInfo.setStar(i%5);
            meSysPortraitInfoMapper.insert(meSysPortraitInfo);
        }

        /*taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    MeSysPortraitInfo meSysPortraitInfo = new MeSysPortraitInfo();
                    meSysPortraitInfo.setPortraitName("run-name-"+i);
                    meSysPortraitInfo.setStar(i%5);
                    meSysPortraitInfoMapper.insert(meSysPortraitInfo);
                }

            }
        });*/
    }
}
