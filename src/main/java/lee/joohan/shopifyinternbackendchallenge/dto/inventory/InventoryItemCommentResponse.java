package lee.joohan.shopifyinternbackendchallenge.dto.inventory;


import lee.joohan.shopifyinternbackendchallenge.model.InventoryItemComment;
import lombok.Getter;

@Getter
public class InventoryItemCommentResponse {
    private String author;
    private String content;
    private long id;

    public InventoryItemCommentResponse(InventoryItemComment comment) {
        author = comment.getAuthorName();
        content = comment.getContent();
        id = comment.getId();
    }
}
