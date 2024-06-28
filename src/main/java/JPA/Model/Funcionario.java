package JPA.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Funcionario {
    @Id
    @Column(name = "id_func", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nome;
    @ToString.Exclude
    private Double salario;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Departamento departamento;

    public Funcionario(String nome) {
        this.nome = nome;
    }
}
