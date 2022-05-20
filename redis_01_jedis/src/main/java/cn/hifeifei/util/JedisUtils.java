package cn.hifeifei.util;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @since: version 1.0
 */
public class JedisUtils {

    public static Jedis connection(){
        Jedis jedis = new Jedis("172.16.5.19",6379);
        jedis.auth("jkct-redis-123456");
        return jedis;
    }

}