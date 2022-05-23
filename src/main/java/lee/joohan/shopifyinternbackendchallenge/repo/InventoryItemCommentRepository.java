package lee.joohan.shopifyinternbackendchallenge.repo;


import lee.joohan.shopifyinternbackendchallenge.model.InventoryItemComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemCommentRepository extends CrudRepository<InventoryItemComment, Long> {
}
