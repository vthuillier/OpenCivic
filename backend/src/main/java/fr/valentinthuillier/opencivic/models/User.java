package fr.valentinthuillier.opencivic.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * Classe User : Représentation d'un utilisateur en BDD
     * @ id : UUID de l'utilisateur, généré automatiquement par Hibernate
     * @ email : Email de l'utilisateur (unique, obligatoire)
     * @ password : Mot de passe hashé de l'utilisateur (hash fait en amont, dans le
     * service)
     * @ username : Pseudo de l'utilisateur (optionnel, "Anonymous" par défaut)
     * @ role : Rôle de l'utilisateur (CITIZEN par défaut)
     * @ prePersist : Si le pseudo est null ou vide, il est remplacé par "Anonymous"
     */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Role role = Role.CITIZEN;

    @PrePersist
    private void prePersist() {
        if (this.username == null || this.username.isBlank()) {
            this.username = "Anonymous";
        }
    }

}