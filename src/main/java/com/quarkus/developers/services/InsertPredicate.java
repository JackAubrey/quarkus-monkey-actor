package com.quarkus.developers.services;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Singleton
public class InsertPredicate implements Scheduled.SkipPredicate {
    AtomicInteger skip = new AtomicInteger();

    @Override
    public boolean test(ScheduledExecution execution) {
        boolean toSkip = skip.incrementAndGet() > 5;
        log.info("----->>> Test {} | To be Skipped: {}", skip.get(), toSkip);
        return toSkip;
    }
}
