package com.quarkus.developers.repositories;

import com.quarkus.developers.entities.FooEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FooRepository implements PanacheRepository<FooEntity> {
}
