package br.com.postech.soat.customer.infrastructure.persistence;

import br.com.postech.soat.commons.infrastructure.util.MaskUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false, length = 11, name = "document_identifier")
    private String cpf;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
            "id=" + id +
            ", cpf='" + MaskUtil.maskCpf(cpf) + '\'' +
            ", name='" + name + '\'' +
            ", email='" + MaskUtil.maskEmail(email) + '\'' +
            ", phone='" + MaskUtil.maskPhone(phone) + '\'' +
            '}';
    }
}