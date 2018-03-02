package com.github.lana.labotuel;

import com.github.lana.eriscasper.ErisCasper;
import com.github.lana.eriscasper.Message;

public class LaBotuel {
  public static void main(String[] args) throws Exception {
    ErisCasper ec = ErisCasper.create();

    Message.from(ec)
        .filter(m -> m.getContent().startsWith("+ping"))
        .subscribe(m -> m.reply("pong").subscribe());

    Message.from(ec)
        .filter(m -> m.getContent().startsWith("+echo"))
        .subscribe(m -> m.reply(m.getContent().substring(5)).subscribe());
  }
}
