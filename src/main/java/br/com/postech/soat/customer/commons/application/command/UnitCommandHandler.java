package br.com.postech.soat.commons.application.command;

public interface UnitCommandHandler<C extends Command> {
    void handle(C command);
}
