package br.com.postech.soat.commons.application.command;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
