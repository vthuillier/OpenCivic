package fr.valentinthuillier.opencivic.repositories;

import java.io.ObjectInputFilter.Status;
import java.util.List;
import java.util.UUID;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.valentinthuillier.opencivic.models.Report;

public interface ReportRepository extends JpaRepository<Report, UUID> {
   
    List<Report> findByStatus(Status status);
    
    List<Report> findByCategory(Category category);

    List<Report> findByCategoryAndStatus(Category category, Status status);

    List<Report> findByAuthorId(UUID id);
    
    
}
