package com.piotrke.user.entities;

import com.piotrke.user.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private String id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;
}
