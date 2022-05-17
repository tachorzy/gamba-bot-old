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
    arg[0] is the command rest is parameters

    note there is a bug where it finds * and another character when you sys out
    not sure if it leads into issues atm so far its fine
*/
public class Commands extends ListenerAdapter {
    public char PREFIX = '&';

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].charAt(0) == PREFIX){
            switch(args[0]){
                case "&fishpog":
                    try{
                        event.getChannel().sendMessage("https://c.tenor.com/p4MNhgEwIGwAAAAC/poggers-fish-lol.gif").queue();
                    }
                    catch(Exception er){
                        System.out.println(er);
                    }
                    break;
                case "&annoy":
                    try{
                        event.getChannel().sendMessage("<@694298455979327512>").queue();
                    }
                    catch(Exception er){
                        System.out.println(er);
                    }
                    break;
            }
        }

    }
}
