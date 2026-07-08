package fr.valentinthuillier.opencivic.models;

public enum Role {
    /**
     * Enum Role : Représentation des rôles possibles en BDD
     * CITIZEN : Utilisateur standard (défaut)
     * MODERATOR : Utilisateur avec permissions de modération
     * ADMIN : Utilisateur avec permissions d'administration
     */
    CITIZEN,
    MODERATOR,
    ADMIN
}