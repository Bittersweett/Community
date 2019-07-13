package com.nowcoder.community.util;

public interface CommunityConstant {


    int ACTIVATION_SUCCESS = 0; //激活成功
    int ACTIVATION_REPEAT = 1; //重复激活
    int ACTIVATION_FAILURE = 2; //激活失败

    int DEFAULT_EXPIRED_SECONDS = 3600 * 12; //默认状态的登录凭证的超时时间
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100; //记住状态的登录凭证超时时间

    int ENTITY_TYPE_POST = 1;//实体类型：帖子
    int ENTITY_TYPE_COMMENT = 2;//实体类型：评论
}
