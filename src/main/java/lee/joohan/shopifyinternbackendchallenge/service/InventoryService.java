package lee.joohan.shopifyinternbackendchallenge.service;

import lee.joohan.shopifyinternbackendchallenge.exceptions.NotFoundInventoryItemException;
import lee.joohan.shopifyinternbackendchallenge.model.InventoryItem;
import lee.joohan.shopifyinternbackendchallenge.model.InventoryItemComment;
import lee.joohan.shopifyinternbackendchallenge.repo.InventoryItemCommentRepository;
import lee.joohan.shopifyinternbackendchallenge.repo.InventoryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryItemRepository inventoryItemRepository;
    private final InventoryItemCommentRepository inventoryItemCommentRepository;

    public List<InventoryItem> getItems() {
        return StreamSupport.stream(inventoryItemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public InventoryItem createItem(String name, String description) {
        InventoryItem item = InventoryItem.builder()
                .name(name)
                .description(description)
                .build();

        return inventoryItemRepository.save(item);
    }


    @Transactional
    public InventoryItem editItem(long id, String name, String description) {
        InventoryItem item = inventoryItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundInventoryItemException(id));

        Optional.ofNullable(name)
                .filter(s -> !s.isBlank())
                .ifPresent(item::changeName);

        Optional.ofNullable(description)
                .filter(s -> !s.isBlank())
                .ifPresent(item::changeDescription);

        return inventoryItemRepository.save(item);
    }

    @Transactional
    public void deleteItem(long id) {
        InventoryItem item = inventoryItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundInventoryItemException(id));


        inventoryItemRepository.delete(item);
    }


    @Transactional
    public InventoryItem addComment(long itemId, String authorName, String content) {
        InventoryItem item = inventoryItemRepository.findById(itemId)
                .orElseThrow(() -> new NotFoundInventoryItemException(itemId));

        InventoryItemComment comment = InventoryItemComment.builder()
                .authorName(authorName)
                .content(content)
                .inventoryItem(item)
                .build();

        item.addComment(comment);

        inventoryItemCommentRepository.save(comment);
        return inventoryItemRepository.save(item);
    }



    public InventoryItem changeCommentVisibility(long commentId, boolean visible) {
        InventoryItemComment comment = inventoryItemCommentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundInventoryItemException(commentId));

        comment.setVisible(visible);

        return inventoryItemCommentRepository.save(comment).getInventoryItem();
    }

}
