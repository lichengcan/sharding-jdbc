package com.cxytiandi.sharding.controller;

import com.cxytiandi.sharding.po.LouDong;
import com.cxytiandi.sharding.service.LouDongService;
import com.cxytiandi.sharding.utils.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LouDongController {

    @Autowired
    private LouDongService louDongService;

    @GetMapping("/lds")
    public Object list() {
        return louDongService.list();
    }

    @Autowired
    IdGeneratorSnowflake idGeneratorSnowflake;

    @PostMapping("/ld/add")
    public Object add() {
        for (long i = 0; i < 10; i++) {
            LouDong louDong = new LouDong();
            louDong.setId(idGeneratorSnowflake.snowflakeId().toString());
            louDong.setCity("深圳");
            louDong.setRegion("宝安");
            louDong.setName("李四");
            louDong.setLdNum("A");
            louDong.setUnitNum("2");
            louDongService.addLouDong(louDong);
        }
        return "success";
    }

}
