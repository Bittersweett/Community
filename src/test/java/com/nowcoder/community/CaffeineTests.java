package com.nowcoder.community;

import com.nowcoder.community.controller.AlphaController;
import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class) //以它测
public class CaffeineTests {

    @Autowired
    private DiscussPostService postService;

    @Test
    public void testCache() {
        System.out.println(postService.findDiscussPost(0, 0, 10, 1));
        System.out.println(postService.findDiscussPost(0, 0, 10, 1));
        System.out.println(postService.findDiscussPost(0, 0, 10, 1));
        System.out.println(postService.findDiscussPost(0, 0, 10, 0));
    }
}
