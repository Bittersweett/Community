package com.nowcoder.community.config;

import com.nowcoder.community.quartz.AlphaJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * 配置 -> 数据库 -> 调用
 */
@Configuration
public class QuartzConfig {

    // FactoryBean可简化Bean的实例化过程：
    // 1.通过FactoryBean封装了Bean的实例化过程
    // 2.可以将FactoryBean装配到Spring容器里
    // 3.将FactoryBean注入给其它的Bean
    // 4.该Bean得到的是FactoryBean所管理的对象实例

    // 配置JobDetail
    //@Bean
    public JobDetailFactoryBean alphaJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(AlphaJob.class);
        factoryBean.setName("alphaJob"); // 任务名字
        factoryBean.setGroup("alphaJobGroup"); // 任务组名
        factoryBean.setDurability(true); // 任务是否持久保存
        factoryBean.setRequestsRecovery(true); // 任务是否可恢复
        return factoryBean;
    }

    // 配置Trigger (两种方式SimpleTriggerFactoryBean，CronTriggerFactoryBean)
    //@Bean
    public SimpleTriggerFactoryBean alphaTrigger(JobDetail alphaJobDetail) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(alphaJobDetail);
        factoryBean.setName("alphaTrigger");
        factoryBean.setGroup("alphaTriggerGroup");
        factoryBean.setRepeatInterval(3000); // 3000ms执行一次
        factoryBean.setJobDataMap(new JobDataMap());
        return factoryBean;
    }

}
