package lee.joohan.shopifyinternbackendchallenge.common;

import lee.joohan.shopifyinternbackendchallenge.exceptions.NotFoundInventoryItemCommentException;
import lee.joohan.shopifyinternbackendchallenge.exceptions.NotFoundInventoryItemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionResponseHandler {

    // 400
    @ExceptionHandler({
            NotFoundInventoryItemCommentException.class,
            NotFoundInventoryItemException.class
    })
    public ResponseEntity<Object> BadRequestException(final RuntimeException exception) {
        log.warn("ERROR", exception);
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}