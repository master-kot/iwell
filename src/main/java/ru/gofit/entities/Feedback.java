package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Сущность Данные обратной связи
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // Имя
    @Column(name = "name", length = 50)
    private String name;

    // Телефон
    @Column(name = "phone", length = 20)
    private String phone;

    // E-mail
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    // Текст сообщения
    @Column(name = "message", nullable = false, length = 500)
    private String message;

    // Предпочитаемый способ связи: Телефон
    @Column(name = "prefer_phone")
    private boolean preferPhone;

    // Предпочитаемый способ связи: E-mail
    @Column(name = "prefer_email")
    private boolean preferEmail;

    // Предпочитаемый способ связи: Whatsapp
    @Column(name = "prefer_whatsapp")
    private boolean preferWhatsapp;

    // Предпочитаемый способ связи: Telegram
    @Column(name = "prefer_telegram")
    private boolean preferTelegram;
}
