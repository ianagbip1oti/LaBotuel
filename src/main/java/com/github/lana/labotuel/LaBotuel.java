package com.github.lana.labotuel;

import com.github.lana.eriscasper.ErisCasper;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class LaBotuel {
  public static void main(String[] args) throws Exception {
    ErisCasper.create()
        .events()
        .ofType(MessageReceivedEvent.class)
        .filter(e -> e instanceof MessageReceivedEvent)
        .map(e -> (MessageReceivedEvent) e)
        .filter(e -> e.getMessage().getContentRaw().startsWith("!ping"))
        .subscribe(
            e ->
                e.getTextChannel()
                    .sendMessage(new MessageBuilder().append("pong").build())
                    .queue());
  }
}
