package com.example.Tutorial.Application.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@ToString(callSuper = true)
@MappedSuperclass
public class ApplicationBaseModel extends BaseModel {

    @Column(name = "application_id", nullable = false)
    @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
    @Convert(disableConversion = true)
    private UUID applicationId;

    @Override
    public void populateCreatedFields() {
        super.populateCreatedFields();
        this.setApplicationId(UUID.randomUUID());
    }

    @Override
    public void populateUpdatedFields() {
        super.populateUpdatedFields();
        this.setApplicationId(UUID.randomUUID());
    }

}
