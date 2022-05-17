package org.example;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Create Default takes token and creates the bot
    Event listener listen to user commands
    Token is grabbed from env.txt file created in form of key:value, a map
*/
public  class DiscordBot {
    public static void main(String[] args) throws LoginException, FileNotFoundException {

        //open env text file and extract specific token that is requested
        File tokenFile = new File("env.txt");
        Scanner fileReader = new Scanner(tokenFile);
        String data,Name,TOKEN = null;
        while(fileReader.hasNextLine()){
            data = fileReader.nextLine();
            Name = data.substring(0,data.indexOf(':'));
            TOKEN =data.substring((data.indexOf(':') + 1));
            if(Name == "testbottoken"){
                break;
            }
        }

        JDA bot = JDABuilder.createDefault(TOKEN)
                .setActivity(Activity.playing("Slots #Gamba Addiction"))
                .build();
        System.out.println("Bot is up and running!");
        bot.addEventListener(new Commands());
    }
}

