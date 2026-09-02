package com.example._SPRING.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name ="Usuarios")
@Data
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min =2,max =20)
    @Column(unique = true, nullable = false)
    @NotBlank(message = "El mensaje es obligatorio")
    private String nombre;

    @Email
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @Column(name = "Edad" , nullable = false)
    @Min(18)
    private Integer edad;





}