package org.example;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Log4j
public class TelegramBot extends TelegramLongPollingBot {

    public TelegramBot(String botToken) {
        super(botToken);
    }


    @Override
    public String getBotUsername() {
        return "super_simple_echo_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());

            try {
                execute(message);
                log.debug(update.getMessage().getChat().getUserName() + ": " + message.getText());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
