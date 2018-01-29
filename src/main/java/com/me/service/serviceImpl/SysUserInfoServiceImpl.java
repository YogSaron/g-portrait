package com.me.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.common.utils.BaZi;
import com.me.common.utils.FiveElementsFromBazi;
import com.me.common.wrapBeans.UserBean;
import com.me.mybatis.entity.MeSysFiveElements;
import com.me.mybatis.entity.MeSysUserInfo;
import com.me.mybatis.mapper.MeSysFiveElementsMapper;
import com.me.mybatis.mapper.MeSysUserInfoMapper;
import com.me.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Logan Zhou on 2018-01-26.
 */
@Service("sysUserInfoService")
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Autowired
    private MeSysUserInfoMapper meSysUserInfoMapper;
    @Autowired
    private MeSysFiveElementsMapper meSysFiveElementsMapper;

    @Override
    public HashMap<String, Object> doPortraitInfoSave(UserBean userBean) {

        ObjectMapper objectMapper = new ObjectMapper();

        String birthdayYear = userBean.getBirthday().substring(0, 4);
        String birthdayMonth = userBean.getBirthday().substring(5, 7);
        String birthdayDay = userBean.getBirthday().substring(8, 10);
        String birthday = birthdayYear + "-" + birthdayMonth + "-" + birthdayDay;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        BaZi lunar;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(birthday));
            lunar = new BaZi(cal);
            //获取八字信息
            String bazi = lunar.getYearGanZhi(userBean.getHour());
            String[] bs = bazi.split(",");
            //封装user类并保存
            MeSysUserInfo meSysUserInfo = new MeSysUserInfo();
            meSysUserInfo.setUsername(userBean.getFirstName() + userBean.getLastName());
            meSysUserInfo.setSex(userBean.getSex());
            if (bs.length > 3) {
                meSysUserInfo.setHoroscopeYear(bs[0]);
                meSysUserInfo.setHoroscopeMonth(bs[1]);
                meSysUserInfo.setHoroscopeDay(bs[2]);
                meSysUserInfo.setHoroscopeHour(bs[3]);
            }
            meSysUserInfo.setYear(Integer.parseInt(birthdayYear));
            meSysUserInfo.setMonth(Integer.parseInt(birthdayMonth));
            meSysUserInfo.setDay(Integer.parseInt(birthdayDay));
            meSysUserInfo.setHour(userBean.getHour());
            meSysUserInfo.setCreateTime(new Date());
            meSysUserInfoMapper.insert(meSysUserInfo);
            //------封装五行属性
            //获取五行属性
            Map<String, Integer> fiveEles = FiveElementsFromBazi.getFEFromBazi(bazi.replace(",", ""));
            MeSysFiveElements meSysFiveElements = new MeSysFiveElements();
            meSysFiveElements.setParentId(meSysUserInfo.getId());
            meSysFiveElements.setFire(fiveEles.get("fi"));
            meSysFiveElements.setGold(fiveEles.get("go"));
            meSysFiveElements.setWater(fiveEles.get("wa"));
            meSysFiveElements.setSoil(fiveEles.get("so"));
            meSysFiveElements.setWood(fiveEles.get("wo"));
            meSysFiveElementsMapper.insert(meSysFiveElements);//赋值保存
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("userInfo", objectMapper.writeValueAsString(meSysUserInfo));
            map.put("fE", objectMapper.writeValueAsString(meSysFiveElements));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
