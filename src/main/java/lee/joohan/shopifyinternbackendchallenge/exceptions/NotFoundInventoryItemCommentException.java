package lee.joohan.shopifyinternbackendchallenge.exceptions;

public class NotFoundInventoryItemCommentException extends RuntimeException {
    public NotFoundInventoryItemCommentException(long id) {
        super(String.format("The comment [id: %s] is not found.", id));
    }

}
