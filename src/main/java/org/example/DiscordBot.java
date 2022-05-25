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
    Data about the database and the bot is obtained from env.txt file
*/
public  class DiscordBot {
    public static void main(String[] args) throws LoginException, FileNotFoundException {

        //open env text file and extract specific token that is requested such as the discord api token and mongodb token
        File tokenFile = new File("env.txt");
        Scanner fileReader = new Scanner(tokenFile);
        String data,dataValue,Name;
        String collectionName = null;
        String databaseName = null;
        String DISCORDTOKEN = null;
        String DBTOKEN = null;

        while(fileReader.hasNextLine()){
            data = fileReader.nextLine();
            dataValue = data.substring((data.indexOf(':') + 1));
            
            Name = data.substring(0,data.indexOf(':'));

            switch(Name){
                case "testbottoken":
                    DISCORDTOKEN = dataValue;
                    break;
                case "dbtoken":
                    DBTOKEN = dataValue;
                    break;
                case "testcollection":
                    collectionName = dataValue;
                    break;
                case "database":
                    databaseName =  dataValue;
                    break;
                default:
                    break;
            }
        }

        //connect the database and pass it to commands constructor
        Database dbInfo = new Database(DBTOKEN,databaseName,collectionName);

        JDA bot = JDABuilder.createDefault(DISCORDTOKEN)
                .setActivity(Activity.playing("Slots #Gamba Addiction"))
                .build();
        bot.addEventListener(new Commands(dbInfo));
        System.out.println("Bot is up and running!");

    }
}

