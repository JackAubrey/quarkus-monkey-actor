package com.quarkus.developers.services;

import com.github.javafaker.Faker;
import com.quarkus.developers.entities.FooEntity;
import com.quarkus.developers.enumerations.FooTypeEnum;
import com.quarkus.developers.mappers.FooMapper;
import com.quarkus.developers.repositories.FooRepository;
import io.quarkus.scheduler.Scheduled;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ApplicationScoped
public class ActorJobsService {
    private final FooRepository fooRepository;
    private final FooMapper fooMapper;

    private final Faker faker = new Faker();
    private AtomicInteger atomicInteger = new AtomicInteger();

    public ActorJobsService(FooRepository fooRepository, FooMapper fooMapper) {
        this.fooRepository = fooRepository;
        this.fooMapper = fooMapper;
    }

    @Scheduled(every = "5s")
    void performSearch() {
        long found = fooRepository.findAll().page(0, 10).count();
        log.info("Found {} entries", found);
    }

    @Transactional
    @Blocking
    @Scheduled(every = "2s")
    void performInsert() {
        FooEntity fooEntity = FooEntity.builder()
                .title(faker.book().title())
                .name(faker.name().fullName())
                .type(nextType())
                .build();
        fooRepository.persist(fooEntity);
        log.info("A new entity has been created: {}", fooMapper.entityToDto(fooEntity) );
    }

    private FooTypeEnum nextType() {
        if(atomicInteger.get() >= FooTypeEnum.values().length) {
            atomicInteger = new AtomicInteger();
        }

        return FooTypeEnum.values()[atomicInteger.getAndIncrement()];
    }
}
