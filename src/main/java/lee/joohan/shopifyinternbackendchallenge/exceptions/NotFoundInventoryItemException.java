package lee.joohan.shopifyinternbackendchallenge.exceptions;

public class NotFoundInventoryItemException extends RuntimeException {
    public NotFoundInventoryItemException(long id) {
        super(String.format("The inventory Item [id: %s] is not found.", id));
    }
}
