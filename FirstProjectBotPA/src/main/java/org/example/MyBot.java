package org.example;

import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public MyBot() {
        super("6874191171:AAGMiAq4rIWNC7Rba-jc4K_70bxIVyJQmgU");
    }

    @Override
    public void onUpdateReceived(Update update) {
        var chatId = update.getMessage().getChatId();
        var text = update.getMessage().getText();
        try {
            var message = new SendMessage();
            message.setChatId(chatId);

            if (text.equals("/start")) {
                message.setText("Hello!");
            } else if (text.equals("btc")) {
                var price = CryptoPrice.spotPrice("BTC");
                message.setText("BTC price: " + price.getAmount().doubleValue());
            } else if (text.equals("eth")) {
                var price = CryptoPrice.spotPrice("ETH");
                message.setText("ETH price: " + price.getAmount().doubleValue());
            } else if (text.equals("bnb")) {
                var price = CryptoPrice.spotPrice("BNB");
                message.setText("BNB price: " + price.getAmount().doubleValue());
            }  else if (text.equals("doge")) {
                var price = CryptoPrice.spotPrice("DOGE");
                message.setText("DOGE price: " + price.getAmount().doubleValue());
            } else if (text.equals("/all")) {
                var price = CryptoPrice.spotPrice("BTC");
                var price1 = CryptoPrice.spotPrice("ETH");
                var price2 = CryptoPrice.spotPrice("BNB");
                var price3 = CryptoPrice.spotPrice("DOGE");
                message.setText("All prices - " + "BTC price: " + price.getAmount().doubleValue() +
                    ", ETH price: " + price1.getAmount().doubleValue() + ", BNB price: " + price2.getAmount().doubleValue()
                        + ", DOGE price: " + price3.getAmount().doubleValue());
            } else if (text.equals("btc,eth")) {
                var price = CryptoPrice.spotPrice("BTC");
                var price1 = CryptoPrice.spotPrice("ETH");
                message.setText("BTC price: " + price.getAmount().doubleValue() +
                        ", ETH price: " + price1.getAmount().doubleValue());
            } else if (text.equals("eth,btc,doge")) {
                var price = CryptoPrice.spotPrice("ETH");
                var price1 = CryptoPrice.spotPrice("BTC");
                var price2 = CryptoPrice.spotPrice("DOGE");
                message.setText("ETH price: " + price.getAmount().doubleValue()
                        + ", BTC price: " + price1.getAmount().doubleValue()
                        + ", DOGE price: " + price2.getAmount().doubleValue());
            } else {
                message.setText("Unknown command!");
            }

            execute(message);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    @Override
    public String getBotUsername() {
        return "YevheniiaSh_HW_Bot";
    }
}

// 6874191171:AAGMiAq4rIWNC7Rba-jc4K_70bxIVyJQmgU
// YevheniiaSh_HW_Bot