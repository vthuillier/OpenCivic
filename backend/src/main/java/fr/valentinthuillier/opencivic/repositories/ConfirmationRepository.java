package fr.valentinthuillier.opencivic.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.valentinthuillier.opencivic.models.Confirmation;

public interface ConfirmationRepository extends JpaRepository<Confirmation, UUID> {

    long countByReportId(UUID reportId);

    boolean existsByReportIdAndUserId(UUID reportId, UUID userId);

}