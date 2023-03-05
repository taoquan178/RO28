package com.tn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống!")
    @Length(max =20, message="Tên chỉ được nhập tối đa 20 ký tự")
    @Pattern(regexp = "^[A-Z a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$", message = "Họ tên không được nhập số và kí tự đặc biệt")
    private String name;

    @NotNull(message = "Không được để FullName = Null")
    @Pattern(regexp = "^[A-Z a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$", message = "Họ tên không được nhập số và kí tự đặc biệt")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Pattern(regexp = "^(.+)@(\\S+)$",message="Bạn phải nhập vào dữ liệu là email")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "không được để trống!")
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public enum Type{
        EMPLOYEE,MANAGER,ADMIN
    }

}
