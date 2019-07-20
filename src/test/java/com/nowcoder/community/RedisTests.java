package com.nowcoder.community;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * string类测试
     */
//    @Test
//    public void testStrings() {
//        String redisKey = "test:count";
//        redisTemplate.opsForValue().set(redisKey, 1); //存string数据
//        System.out.println(redisTemplate.opsForValue().get(redisKey)); //取string数据
//        System.out.println(redisTemplate.opsForValue().increment(redisKey));
//        System.out.println(redisTemplate.opsForValue().decrement(redisKey));
//    }
//
//    @Test
//    public void testHashes() {
//        String redisKey = "test:user";
//        redisTemplate.opsForHash().put(redisKey, "id", 1);
//        redisTemplate.opsForHash().put(redisKey, "username", "leon");
//        System.out.println(redisTemplate.opsForHash().get(redisKey, "id"));
//        System.out.println(redisTemplate.opsForHash().get(redisKey, "username"));
//    }

//    @Test
//    public void testList() {
//        String redisKey = "test:ids";
//        redisTemplate.opsForList().leftPush(redisKey, 101);
//        redisTemplate.opsForList().leftPush(redisKey, 102);
//        redisTemplate.opsForList().leftPush(redisKey, 103);
//
//        System.out.println(redisTemplate.opsForList().size(redisKey));
//        System.out.println(redisTemplate.opsForList().index(redisKey, 0));
//        System.out.println(redisTemplate.opsForList().range(redisKey, 0, 2));
//        System.out.println(redisTemplate.opsForList().leftPop(redisKey));
//        System.out.println(redisTemplate.opsForList().leftPop(redisKey));
//    }


//    @Test
//    public void testSets() {
//        String redisKey = "test:teachers";
//
//        redisTemplate.opsForSet().add(redisKey, "Leon", "Chris", "Jill");
//        System.out.println(redisTemplate.opsForSet().size(redisKey));
//        System.out.println(redisTemplate.opsForSet().pop(redisKey));
//        System.out.println(redisTemplate.opsForSet().members(redisKey));
//    }
//    @Test
//    public void testSortedSets() {
//        String redisKey = "test:students";
//        redisTemplate.opsForZSet().add(redisKey, "Leon", 12);
//        redisTemplate.opsForZSet().add(redisKey, "Ada", 13);
//        redisTemplate.opsForZSet().add(redisKey, "Louis", 14);
//        System.out.println(redisTemplate.opsForZSet().zCard(redisKey));
//        System.out.println(redisTemplate.opsForZSet().score(redisKey, "Leon"));
//        System.out.println(redisTemplate.opsForZSet().reverseRank(redisKey, "Ada"));
//        System.out.println(redisTemplate.opsForZSet().reverseRange(redisKey, 0, 2));
//    }

//    @Test
//    public void testKeys() {
//        redisTemplate.delete("test:user");
//        System.out.println(redisTemplate.hasKey("test:user")); //exists命令
//        redisTemplate.expire("test:students", 10, TimeUnit.SECONDS); //设置过期时间
//    }

    //多次访问同一个key
//    @Test
//    public void testBoundOperation() {
//        String redisKey = "test:count";
//        BoundValueOperations operations = redisTemplate.boundValueOps(redisKey);
//        operations.increment();
//        operations.increment();
//        operations.increment();
//        operations.increment();
//
//        System.out.println(operations.get());
//    }

    //编程式事务
    @Test
    public void testTransactional() {
        Object obj = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                String redisKey = "test:tx";
                redisOperations.multi(); //启用事务
                redisOperations.opsForSet().add(redisKey, "Leon");
                redisOperations.opsForSet().add(redisKey, "Chris");
                redisOperations.opsForSet().add(redisKey, "Leon");

                System.out.println(redisOperations.opsForSet().members(redisKey));
                return redisOperations.exec();
            }
        });
        System.out.println(obj);
    }
}
