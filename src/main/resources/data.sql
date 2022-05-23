CREATE TABLE inventory_item
(
    id          BIGINT NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_inventoryitem PRIMARY KEY (id)
);

CREATE TABLE inventory_item_comment
(
    id          BIGINT NOT NULL,
    content     VARCHAR(255),
    author_name VARCHAR(255),
    visible     BOOLEAN,
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    item_id     BIGINT,
    CONSTRAINT pk_inventoryitemcomment PRIMARY KEY (id)
);

ALTER TABLE inventory_item_comment
    ADD CONSTRAINT FK_INVENTORYITEMCOMMENT_ON_ITEM FOREIGN KEY (item_id) REFERENCES inventory_item (id);
