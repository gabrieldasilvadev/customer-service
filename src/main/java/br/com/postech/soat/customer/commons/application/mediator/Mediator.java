package br.com.postech.soat.commons.application.mediator;

import br.com.postech.soat.commons.application.command.Command;
import br.com.postech.soat.commons.application.query.Query;

public interface Mediator {

    <C extends Command, R> R send(C command);

    void sendUnit(Command command);

    <Q extends Query, R> R send(Q query);
}
