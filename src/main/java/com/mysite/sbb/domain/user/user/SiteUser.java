package com.mysite.sbb.domain.user.user;

import com.mysite.sbb.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SiteUser extends BaseEntity {

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;
}
