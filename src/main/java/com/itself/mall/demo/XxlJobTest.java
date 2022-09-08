package com.itself.mall.demo;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobContext;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class XxlJobTest {


    @XxlJob("test")
    public ReturnT<String> xxlJobTest(String date) {
        XxlJobContext xxlJobContext = XxlJobContext.getXxlJobContext();
        String jobParam = xxlJobContext.getJobParam();
        log.info("---------xxlJobTest定时任务执行成功--------{}",jobParam);
        return ReturnT.SUCCESS;
    }
}
