package com.quarkus.developers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quarkus.developers.enumerations.FooTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FooDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -9059550948377671129L;

    @Null
    private Long id;

    @Null
    private Integer version;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @Null
    private OffsetDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @Null
    private OffsetDateTime lastModifiedDate;

    @NotBlank(message = "The Name is mandatory")
    private String name;

    private String title;

    @NotNull
    private FooTypeEnum type;
}
