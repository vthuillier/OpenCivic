package fr.valentinthuillier.opencivic.models;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "confirmations", uniqueConstraints = @UniqueConstraint(columnNames = { "report_id", "user_id" }))
public class Confirmation {
    /**
     * Classe Confirmation : "Moi aussi j'ai le problème" - Vote
     * Relation unidirectionnelle : Confirmation connaît Report et User,
     * mais ni Report ni User ne chargent de collection en retour.
     * @ id : UUID de la confirmation
     * @ report : Signalement confirmé
     * @ user : Utilisateur ayant confirmé
     * @ createdAt : Horodatage de la confirmation
     */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}
