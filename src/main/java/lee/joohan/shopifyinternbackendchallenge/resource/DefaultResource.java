package lee.joohan.shopifyinternbackendchallenge.resource;

import lee.joohan.shopifyinternbackendchallenge.dto.inventory.response.GetInventoryItemsResponse;
import lee.joohan.shopifyinternbackendchallenge.model.InventoryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class DefaultResource {
    @GetMapping
    public ResponseEntity entry() {
        return ResponseEntity.ok("Check README.md for API instructions");
    }

}
