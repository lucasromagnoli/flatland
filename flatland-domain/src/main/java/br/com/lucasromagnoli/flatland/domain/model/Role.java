package br.com.lucasromagnoli.flatland.domain.model;

import br.com.lucasromagnoli.javaee.underpinning.domain.model.RoleSystem;

import javax.persistence.*;

/**
 * @author github.com/lucasromagnoli
 * @since 15/02/2020
 */
@Entity
@Table(name = "UND_SYSTEM_ROLES")
public class Role implements RoleSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SYSTEM_ROLES")
    private Long id;

    @Column(name = "NAME")
    private String authority;

    @Column(name = "DESCRIPTION")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
