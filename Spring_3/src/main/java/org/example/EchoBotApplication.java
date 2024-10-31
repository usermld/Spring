package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class EchoBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(EchoBotApplication.class, args);

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            String botToken = "test";
            telegramBotsApi.registerBot(new TelegramBot(botToken));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
