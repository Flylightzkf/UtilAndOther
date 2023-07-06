package com.example.powerjobdemo.job;

import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

/**
 * @author benjamin_5
 * @Description 简单任务执行器
 * @date 2023/5/3
 */
@Component
public class SimpleJobServer implements BasicProcessor {

    @Override
    public ProcessResult process(TaskContext taskContext) throws Exception {
        String jobParams = taskContext.getJobParams();
        System.out.println("参数: " + jobParams);

        System.out.println("定时任务执行");

        return new ProcessResult(true, "定时任务执行成功");
    }
}
