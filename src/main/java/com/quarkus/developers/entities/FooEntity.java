package com.quarkus.developers.entities;

import com.quarkus.developers.enumerations.FooTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FooEntity {
    @Id
    @SequenceGenerator(name = "fooSequence", sequenceName = "foo_sequence", allocationSize = 1)
    @GeneratedValue(generator = "fooSequence")
    private Long id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    private FooTypeEnum type;
}
