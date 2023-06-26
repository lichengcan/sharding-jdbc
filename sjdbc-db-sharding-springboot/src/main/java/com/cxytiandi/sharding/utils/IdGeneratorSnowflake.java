package com.cxytiandi.sharding.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: sn
 * @Desc 雪花算法
 * @Date: 2022/12/5
 */
@Component
public class IdGeneratorSnowflake {

    private Logger log = LoggerFactory.getLogger(IdGeneratorSnowflake.class);

    private long workerId = 0;  //第几号机房
    private long datacenterId = 1;  //第几号机器
    private Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);

    @PostConstruct  //构造后开始执行，加载初始化工作
    public void init(){
        try{
            //获取本机的ip地址编码
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId: " + workerId);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("当前机器的workerId获取失败 ----> " + e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized Long snowflakeId(){
        return snowflake.nextId();
    }
}
