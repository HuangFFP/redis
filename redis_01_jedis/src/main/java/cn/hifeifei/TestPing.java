package cn.hifeifei;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @description:
 * @since: version 1.0
 */
public class TestPing {

    public static void main(String[] args) {
        // new Jedis
        Jedis jedis = new Jedis("172.16.5.19",6379);
        jedis.auth("jkct-redis-123456");
        System.out.println(jedis.ping());

        //
        jedis.select(5);

        jedis.getSet("test","getset");
        System.out.println(jedis.setnx("test", "setnx"));


    }
}