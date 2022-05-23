package lee.joohan.shopifyinternbackendchallenge.dto.inventory.request;


import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateInventoryItemCommentRequest {
    @NotBlank
    private String authorName;
    @NotBlank
    private String content;

}
