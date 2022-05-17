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
        JDA bot = JDABuilder.createDefault("OTc1ODM2ODQyODc4NDU1ODU4.GlnaDp.xm9gyf8auSeeHCEE1P2yZG9LiYOhk1bVQWbaHQ")
                .setActivity(Activity.playing("Slots #Gamba Addiction"))
                .build();
        System.out.println("Bot is up and running!");
        bot.addEventListener(new Commands());
    }
}

