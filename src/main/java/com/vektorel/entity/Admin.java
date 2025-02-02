package com.vektorel.entity;

import jakarta.persistence.*;
import lombok.*;

// Anotasyon --> Annotation

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ADMINS")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ad alanı 100 karakter olmalı.
    @Column(length = 100)
    private String ad;

    @Column(
            name = "surname",
            insertable = true, // false ekleme yapamazsınız
            updatable = false // false yaparsanız güncelleme yapılamaz
    )
    private String soyad;

    @Column(length = 200,nullable = false,unique = true)
    private String email;
    private String password;

    // erkek,kadın
    @Enumerated(EnumType.STRING)
    private Gender gender;



//    public String ozellikGetir(){
//        String metin= "id: "+id+", ad: "+ad+", email: "+email+", sifre: "+ password;
//        return metin;
//    }


}
