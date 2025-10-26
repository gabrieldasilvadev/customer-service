package br.com.postech.soat.commons.application.query;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}
