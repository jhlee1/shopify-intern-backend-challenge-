package lee.joohan.shopifyinternbackendchallenge.dto.inventory.request;


import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class EditInventoryItemRequest {
    private String name;
    private String description;
}