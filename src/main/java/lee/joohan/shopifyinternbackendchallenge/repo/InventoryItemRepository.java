package lee.joohan.shopifyinternbackendchallenge.repo;

import lee.joohan.shopifyinternbackendchallenge.model.InventoryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryItemRepository extends CrudRepository<InventoryItem, Long> {
}
