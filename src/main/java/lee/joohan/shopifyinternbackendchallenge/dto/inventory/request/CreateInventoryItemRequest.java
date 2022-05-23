package lee.joohan.shopifyinternbackendchallenge.dto.inventory.request;


import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateInventoryItemRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
