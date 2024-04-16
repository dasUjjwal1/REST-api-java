package com.myspringmysql.springsql.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "master_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String productCode;
    private String lineOfBusiness;
    private Boolean isActive;
    private Boolean isDelete;
    private String createdBy;
    private String alias;
    private String icon;

}
