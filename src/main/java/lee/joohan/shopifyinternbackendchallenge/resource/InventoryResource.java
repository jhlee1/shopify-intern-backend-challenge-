package lee.joohan.shopifyinternbackendchallenge.resource;

import lee.joohan.shopifyinternbackendchallenge.dto.inventory.InventoryItemCommentResponse;
import lee.joohan.shopifyinternbackendchallenge.dto.inventory.InventoryItemResponse;
import lee.joohan.shopifyinternbackendchallenge.dto.inventory.request.CreateInventoryItemCommentRequest;
import lee.joohan.shopifyinternbackendchallenge.dto.inventory.request.CreateInventoryItemRequest;
import lee.joohan.shopifyinternbackendchallenge.dto.inventory.request.EditInventoryItemRequest;
import lee.joohan.shopifyinternbackendchallenge.dto.inventory.response.GetInventoryItemsResponse;
import lee.joohan.shopifyinternbackendchallenge.model.InventoryItem;
import lee.joohan.shopifyinternbackendchallenge.model.InventoryItemComment;
import lee.joohan.shopifyinternbackendchallenge.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("inventory")
public class InventoryResource {
    private final InventoryService inventoryService;


    @GetMapping("items")
    public ResponseEntity getItems() {
        List<InventoryItem> items = inventoryService.getItems();

        return ResponseEntity.ok(new GetInventoryItemsResponse(items));
    }

    @PostMapping("items")
    public ResponseEntity createItems(@RequestBody @Valid CreateInventoryItemRequest request) {
        InventoryItem item = inventoryService.createItem(request.getName(), request.getDescription());

        return ResponseEntity.ok(new InventoryItemResponse(item));
    }

    @PutMapping("items/{itemId}")
    public ResponseEntity editItems(@PathVariable long itemId, @RequestBody EditInventoryItemRequest request) {
        InventoryItem item = inventoryService.editItem(itemId, request.getName(), request.getDescription());

        return ResponseEntity.ok(new InventoryItemResponse(item));
    }

    @DeleteMapping("items/{itemId}")
    public ResponseEntity deleteItems(@PathVariable long itemId) {
        inventoryService.deleteItem(itemId);

        return ResponseEntity.ok().build();
    }

    @PostMapping("items/addComment/{itemId}")
    public ResponseEntity addComment(@PathVariable long itemId, @RequestBody CreateInventoryItemCommentRequest request) {
        InventoryItem item = inventoryService.addComment(itemId, request.getAuthorName(), request.getContent());

        return ResponseEntity.ok(new InventoryItemResponse(item));
    }

    @PutMapping("items/deleteComment/{commentId}")
    public ResponseEntity deleteComment(@PathVariable long commentId) {
        InventoryItem item = inventoryService.changeCommentVisibility(commentId, false);

        return ResponseEntity.ok(new InventoryItemResponse(item));
    }

    @PutMapping("items/unDeleteComment/{commentId}")
    public ResponseEntity unDeleteComment(@PathVariable long commentId) {
        InventoryItem item = inventoryService.changeCommentVisibility(commentId, true);

        return ResponseEntity.ok(new InventoryItemResponse(item));
    }
}