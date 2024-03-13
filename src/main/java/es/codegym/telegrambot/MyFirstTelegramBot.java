package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "jmontoyaBot";
    public static final String TOKEN = "6351553874:AAHNQG4Vlh-aSoF2RlwzRD-b5ELVxdL9u_c";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        //TODO: Main operation here
        if (getMessageText().equals("/start")){
            sendTextMessageAsync("Hi, future programmer");
        }
        if (getMessageText().toLowerCase().contains("hi")) {
            sendTextMessageAsync("Hi, what's your name?");
        }
        if (getMessageText().toLowerCase().contains("my name is")){
            sendTextMessageAsync("Nice to meet you, I am *Cat*");
        }
    }
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}