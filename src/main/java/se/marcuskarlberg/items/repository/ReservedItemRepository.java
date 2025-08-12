package se.marcuskarlberg.items.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.marcuskarlberg.items.model.ReservedItem;

@Repository
public interface ReservedItemRepository extends JpaRepository<ReservedItem, Long> {
}
