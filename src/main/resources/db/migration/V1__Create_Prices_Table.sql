CREATE TABLE BRANDS (
   ID BIGINT NOT NULL,
   NAME CHARACTER VARYING(255)
);

CREATE TABLE PRICES (
   ID BIGINT NOT NULL,
   BRAND_ID BIGINT,
   START_DATE TIMESTAMP,
   END_DATE TIMESTAMP,
   PRICE_LIST INTEGER,
   PRODUCT_ID BIGINT,
   PRIORITY INTEGER,
   PRICE NUMERIC(19, 2),
   CURR CHARACTER VARYING(255),
   FOREIGN KEY (BRAND_ID) REFERENCES BRANDS(ID)
);