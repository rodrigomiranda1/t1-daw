package pe.edu.cibertec.appwebventas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private String password;
    private String email;
    private Boolean activo;
    @ManyToMany(cascade = CascadeType.MERGE,
    fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
    joinColumns = @JoinColumn(name = "idusuario"),
    inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles;

}
