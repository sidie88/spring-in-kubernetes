package com.cxrus.microservices.bloomberg.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cxrus.microservices.bloomberg.scheduler.service.BloombergJobService;

@Component
public class BloombergJob implements Job {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BloombergJobService jobService;

    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("Job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());

        jobService.executeBloombergJob();

        logger.info("Next job scheduled @ {}", context.getNextFireTime());
    }
}
