package ru.auheal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

/**
 * Сущность Пользователь
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // Логин
    @Column(name = "user_name", nullable = false, unique = true, length = 50)
    private String username;

    // Пароль
    @Column(name = "password", nullable = false, length = 150)
    private String password;

    // Пользователь активен (true) или заблокирован (false)
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    // Список ролей (ROLE_USER, ROLE_ADMIN, ROLE_COUCH)
    @ManyToMany(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_authorities",
            // Внешний ключ для User в в таблице users_authorities
            joinColumns = @JoinColumn(name = "user_id"),
            // Внешний ключ для другой стороны, User в таблице users_authorities
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities = new ArrayList<>();

    // Имя
    @Column(name = "first_name", length = 50)
    private String firstName;

    // Фамилия
    @Column(name = "last_name", length = 50)
    private String lastName;

    // Адрес
    @Column(name = "address", length = 100)
    private String address;

    // Номер телефона
    @Column(name = "phone", length = 20)
    private String phone;

    // Дата рождения
    @Column(name = "birthday_date")
    private LocalDate birthdayDate;

    // Пол
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    // Ссылка на фото
    @Column(name = "photo_link", length = 100)
    private String photoLink;
}
