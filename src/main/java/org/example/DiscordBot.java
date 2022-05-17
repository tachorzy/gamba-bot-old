package org.example;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

/*
    Create Default takes token and creates the bot
    Event listener listen to user commands
*/
public  class DiscordBot {
    public static void main(String[] args) throws LoginException {
        JDA bot = JDABuilder.createDefault("")
                .setActivity(Activity.playing("Slots #Gamba Addiction"))
                .build();
        System.out.println("Bot is up and running!");
        bot.addEventListener(new Commands());
    }
}

