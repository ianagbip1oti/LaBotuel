package com.github.lana.labotuel;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class LaBotuel implements EventListener {
  public static void main(String[] args) throws Exception {
    JDA jda = new JDABuilder(AccountType.BOT).setToken(System.getenv("BOT_TOKEN")).buildBlocking();
    jda.addEventListener(new LaBotuel());
  }

  @Override
  public void onEvent(Event event) {
    System.out.println(event);
    if (event instanceof MessageReceivedEvent) {
      onMessageReceived((MessageReceivedEvent) event);
    }
  }

  private void onMessageReceived(MessageReceivedEvent e) {
    System.out.println(e.getMessage().getContentRaw());
    if (e.getMessage().getContentRaw().startsWith("!ping")) {
      e.getTextChannel().sendMessage(new MessageBuilder().append("pong").build()).queue();
    }
  }
}
