package org.example;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.awt.*;

/*
    When user sends a message it is an event
    We extract a command and split into words which is a string array args
    arg[0] is the command rest is parameters or options to the command
*/
public class Commands extends ListenerAdapter {
    //initialize the db object and the message prefix
    public char PREFIX = '&';
    public Database server;

    //initialize the server object to the db object we created
    public Commands(Database db){
        server = db;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        //if the bot is messaging then we ignore it
        if(event.getAuthor().isBot()){return;}

        //split the user message into an array
        String[] args = event.getMessage().getContentRaw().split(" ");

        //parse the command and check if its within our switch statement
        if(args[0].charAt(0) == PREFIX){
            switch(args[0].substring(1)){

                //registers the user into the database
                case "signup":
                    if((server.findUser(String.valueOf(event.getMember().getIdLong())))){
                        event.getChannel().sendMessage("You are already signed up can you not?").queue();
                    }
                    else{
                        server.insertDocument(String.valueOf(event.getMember().getIdLong()));
                        String message = "<@" + String.valueOf(event.getJDA().getSelfUser().getIdLong()) + ">" + " has bestowed you the lifestyle of gamba";
                        event.getChannel().sendMessage(message).queue();
                    }
                    break;
                //NOTE COMMAND IS JUST TESTING NOT REAL COMMAND!
                case "highorlow":
                    int creditVal = Integer.valueOf(server.obtainUserCredits("9999"));
                    creditVal += 100;
                    server.updateDocument("9999",String.valueOf(creditVal));
                    System.out.println("updated credits");
                    break;
                default:
                    break;
            }
        }
    }
}







