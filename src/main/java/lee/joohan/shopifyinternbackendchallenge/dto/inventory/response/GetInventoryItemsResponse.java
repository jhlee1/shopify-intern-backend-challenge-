package lee.joohan.shopifyinternbackendchallenge.dto.inventory.response;

import lee.joohan.shopifyinternbackendchallenge.dto.inventory.InventoryItemResponse;
import lee.joohan.shopifyinternbackendchallenge.model.InventoryItem;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetInventoryItemsResponse {
    private List<InventoryItemResponse> items;

    public GetInventoryItemsResponse(List<InventoryItem> items) {
        this.items = items.stream()
                .map(InventoryItemResponse::new)
                .collect(Collectors.toList());
    }
}
