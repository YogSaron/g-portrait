package com.me.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 根据八字查询五行
 * Created by Logan Zhou on 2018-01-12.
 */
public class FiveElementsFromBazi {
    public Map<String,Integer> getFEFromBazi(){
        /*String[] gold = {"庚","辛","申","酉"};
        String[] wood = {"甲","乙","寅","卯"};
        String[] water = {"壬","癸","亥","子"};
        String[] fire = {"丙","丁","巳","午"};
        String[] soil = {"戊","己","辰","戍","丑","未"};*/
        String bazi = "己未丙子乙酉癸未";
        String gold = "庚辛申酉";
        String wood = "甲乙寅卯";
        String water = "壬癸亥子";
        String fire = "丙丁巳午";
        String soil = "戊己辰戍丑未";
        String[] bs = bazi.split("");
        int go = 0,wo = 0,wa = 0,fi = 0,so = 0;
        Map map = new HashMap<String,Integer>();
        for (int i = 0; i <bazi.length() ; i++) {
            if(gold.contains(bs[i])){
                go++;
                continue;
            };
            if(wood.contains(bs[i])){
                wo++;
                continue;
            };
            if(water.contains(bs[i])){
                wa++;
                continue;
            };
            if(fire.contains(bs[i])){
                fi++;
                continue;
            };
            if(soil.contains(bs[i])){
                so++;
                continue;
            };
        }
        map.put("go",go);
        map.put("wo",wo);
        map.put("wa",wa);
        map.put("fi",fi);
        map.put("so",so);
        return map;
    }

    public static void main(String[] args) {
        FiveElementsFromBazi fe = new FiveElementsFromBazi();
        Map<String,Integer> hm = fe.getFEFromBazi();
        System.out.println(hm);
    }
}
