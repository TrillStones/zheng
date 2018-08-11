package com.zheng.test.web.controller.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@RequestMapping(value = "redis")
@Controller
public class RedisController {

    private Logger logger = Logger.getLogger(RedisController.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    @RequestMapping(value = "/set", produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String selectUserByIdTest() {
        ShardedJedis jedis = shardedJedisPool.getResource();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            jedis.set("person." + i + ".name", "frank");
            jedis.set("person." + i + ".city", "beijing");
            String name = jedis.get("person." + i + ".name");
            String city = jedis.get("person." + i + ".city");
//            assertEquals("frank", name);
//            assertEquals("beijing", city);
            jedis.del("person." + i + ".name");
            Boolean result = jedis.exists("person." + i + ".name");
//            assertEquals(false, result);
            result = jedis.exists("person." + i + ".city");
//            assertEquals(true, result);
        }
        long end = System.currentTimeMillis();
        for (Jedis myJedis : jedis.getAllShards()) {
            System.out.println("redis shard: " + myJedis.getClient().getHost() + ":" + myJedis.getClient().getPort());
            System.out.println("redis shard size: " + myJedis.dbSize());
        }
        System.out.println("total time: " + (end - begin) / 1000);
        jedis.close();
        return null;
    }

}