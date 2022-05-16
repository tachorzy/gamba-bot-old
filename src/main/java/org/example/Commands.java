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
            event.getChannel().sendMessage("<@242075681046003743>").queue();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.red);
            eb.setTitle("At the Crib");


            event.getChannel().sendMessageEmbeds(eb.build()).queue();
            eb.clear();
        }
    }
}
