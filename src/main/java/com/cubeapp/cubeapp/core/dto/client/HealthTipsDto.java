package com.cubeapp.cubeapp.core.dto.client;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
//@EqualsAndHashCode
@NoArgsConstructor
public class HealthTipsDto implements Serializable {
    long id;
    String tip;
    long userId;
}