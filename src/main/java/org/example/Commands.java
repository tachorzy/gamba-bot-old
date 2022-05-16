package org.example;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class Commands extends ListenerAdapter {
    public String prefix = "&";

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(prefix + "test")){
            event.getChannel().sendMessage("HEHE").queue();
            event.getChannel().sendMessage(event.getAuthor().getAvatarUrl()).queue();
        }
        else if(args[0].equalsIgnoreCase(prefix + "test2")){
            event.getChannel().sendMessage("<@970172253448843284>").queue();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.red);
            eb.setTitle("At the Crib");
            eb.setDescription("Partying with DJ POPCAT !FISHPOG");
            eb.addField("DRINKING TEARS FROM SUSSYBOI","HOLD L THERE IS NO HOPE THERE IS NO CURVE",false);
            eb.addField("QUOTE","RIP BOZO",false);


            event.getChannel().sendMessageEmbeds(eb.build()).queue();
            eb.clear();
        }
        else if(args[0].equalsIgnoreCase(prefix + "fishpog")){
            event.getChannel().sendMessage("https://c.tenor.com/p4MNhgEwIGwAAAAC/poggers-fish-lol.gif").queue();
        }
    }
}
