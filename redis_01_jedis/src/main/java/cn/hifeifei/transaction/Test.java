package cn.hifeifei.transaction;

import cn.hifeifei.util.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @description:
 * @since: version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Jedis jedis = JedisUtils.connection();

        jedis.select(5);
        jedis.flushDB();

        // 开启事务
        Transaction multi = jedis.multi();

        try {
            multi.set("k1","v1");
            multi.set("k2","v2");
            int i = 1/0;
            multi.exec();
        } catch (Exception e) {
            //抛弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.mget("k1", "k2"));
            jedis.close();
        }

    }

}