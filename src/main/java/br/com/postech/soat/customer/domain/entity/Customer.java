package br.com.postech.soat.customer.domain.entity;

import br.com.postech.soat.customer.domain.valueobject.CPF;
import br.com.postech.soat.customer.domain.valueobject.CustomerId;
import br.com.postech.soat.customer.domain.valueobject.Email;
import br.com.postech.soat.customer.domain.valueobject.Name;
import br.com.postech.soat.customer.domain.valueobject.Phone;

public class Customer {
    private final CustomerId id;
    private final Name name;
    private final CPF cpf;
    private final Email email;
    private final Phone phone;

    public Customer(CustomerId id, Name name, CPF cpf, Email email, Phone phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    public CustomerId getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public CPF getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public Phone getPhone() {
        return phone;
    }

    public static Customer create(Name name, Email email, CPF cpf, Phone phone) {
        return new Customer(
            CustomerId.generate(),
            name,
            cpf,
            email,
            phone
        );
    }

    public static Customer reconstitute(CustomerId id, Name name, CPF cpf, Email email, Phone phone) {
        return new Customer(id, name, cpf, email, phone);
    }
}
