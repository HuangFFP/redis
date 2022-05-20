package cn.hifeifei;

import cn.hifeifei.config.RedisTemplateConfig;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.resource.ClientResources;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.lettuce.LettuceConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;


    @Test
    void contextLoads() {

        redisTemplate.opsForValue().getAndSet("key","234");
        System.out.println(redisTemplate.opsForValue().get("key"));
    }

    @Test
    public void publish(){
//        redisTemplate

        RedisClient client = RedisClient.create();
//        RedisURI redisURI = new RedisURI("",6379);
//        RedisClient client = new RedisClient();
        new Thread(()->{
            redisTemplate.convertAndSend("菊嘛李","逊啊");
        },"publish").start();

        new Thread(()->{
//            redisClient.connectPubSub();
        },"subscribe").start();



    }

}
