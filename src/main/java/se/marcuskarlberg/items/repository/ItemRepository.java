package se.marcuskarlberg.items.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.marcuskarlberg.items.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
