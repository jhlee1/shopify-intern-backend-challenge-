package lee.joohan.shopifyinternbackendchallenge.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class InventoryItemComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String content;
    private String authorName;
    private boolean visible;
    @CreatedDate
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(targetEntity=InventoryItem.class, fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private InventoryItem inventoryItem;

    @Builder
    public InventoryItemComment(String content, String authorName, InventoryItem inventoryItem) {
        this.content = content;
        this.authorName = authorName;
        this.visible = true;
        this.inventoryItem = inventoryItem;
    }

    public void setVisible(boolean isVisible) {
        visible = isVisible;
    }
}
