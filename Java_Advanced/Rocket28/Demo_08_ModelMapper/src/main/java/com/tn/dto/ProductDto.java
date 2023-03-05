package com.tn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
public class ProductDto {

    private Integer id;

    private String name;

    private String price;
}
