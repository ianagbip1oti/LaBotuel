package com.github.lana.labotuel;

import com.github.princesslana.eriscasper.ErisCasper;
import com.github.princesslana.eriscasper.robot.Robot;

public class LaBotuel {
  public static void main(String[] args) throws Exception {
    Robot r = Robot.from(ErisCasper.create());

    r.respond("ping", ctx -> ctx.reply("pong"));
    r.respond("echo (.*)", ctx -> ctx.reply(ctx.getGroup(1)));
  }
}
