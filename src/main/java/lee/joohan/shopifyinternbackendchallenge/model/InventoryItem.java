package lee.joohan.shopifyinternbackendchallenge.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Entity
@NoArgsConstructor
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "inventoryItem")
    private List<InventoryItemComment> comments;

    @Builder
    public InventoryItem(String name, String description) {
        this.name = name;
        this.description = description;
        comments = new ArrayList<>();
    }

    public void addComment(InventoryItemComment comment) {
        comments.add(comment);
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeDescription(String description) {
        this.description = description;
    }
}
