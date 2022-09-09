package com.example.Tutorial.Application.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/* Base Pojo Containing common fields and utility methods for all MFN  entities*/
@Data
@MappedSuperclass
public class BaseModel {

    @Column(name = "CRTE_USER_ID", nullable = false)
    @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
    @Convert(disableConversion = true)
    private UUID createdUserId;

    @Column(name = "UPDT_USER_ID", nullable = false)
    @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
    @Convert(disableConversion = true)
    private UUID updatedUserId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPD_DT")
    private Date lastUpdatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CRTD_DT")
    private Date createdDate;

    public void populateCreatedFields() {
        this.setCreatedDate(new Date());
        this.setCreatedUserId(UUID.randomUUID());
    }


    public void populateUpdatedFields() {
        this.setLastUpdatedDate(new Date());
        this.setUpdatedUserId(UUID.randomUUID());
    }


}
