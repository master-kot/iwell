package ru.auheal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Главный контроллер. Обеспечивает работоспособность фронтенд части web-приложения
 */
@ApiOperation(value = "Главный контроллер")
@Controller
@RequiredArgsConstructor
public class MainController {

    /**
     * Перехват запроса главной страницы
     */
    @GetMapping("")
    public String getHomePage() {
        return "index";
    }
}
