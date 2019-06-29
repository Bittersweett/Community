package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    /**
     * Select Data
     * @param userId
     * @param offset 起始页
     * @param limit
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * Select Count
     * @Param用于给参数取别名，如果只有一个参数，并且在<if>里使用，就必须加别名
     * @param userId
     * @return
     */
    int selectDisscountPostRows(@Param("userId") int userId);

}
