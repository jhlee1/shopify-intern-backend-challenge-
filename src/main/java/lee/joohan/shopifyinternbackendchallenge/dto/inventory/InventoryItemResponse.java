package lee.joohan.shopifyinternbackendchallenge.dto.inventory;

import lee.joohan.shopifyinternbackendchallenge.model.InventoryItem;
import lee.joohan.shopifyinternbackendchallenge.model.InventoryItemComment;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class InventoryItemResponse {
    private long id;
    private String name;
    private String description;
    private List<InventoryItemCommentResponse> comments;

    public InventoryItemResponse(InventoryItem inventoryItem) {
        id = inventoryItem.getId();
        name = inventoryItem.getName();
        description = inventoryItem.getDescription();
        comments = inventoryItem.getComments().stream()
                .filter(InventoryItemComment::isVisible)
                .map(InventoryItemCommentResponse::new)
                .collect(Collectors.toList());
    }

}
