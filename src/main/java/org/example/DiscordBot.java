package org.example;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public  class DiscordBot {
    public static void main(String[] args) throws LoginException {
        JDA bot = JDABuilder.createDefault("OTc1MjcwNzk3NDk1MTM2MzE2.GB8dgr.iwA6VMVsq8AJH9T9frwDLO_kiST2RUeD3w2Yus")
                .setActivity(Activity.playing("pop pop"))
                .build();
        System.out.println("Bot is up and running!");
        bot.addEventListener(new Commands());
    }
}

