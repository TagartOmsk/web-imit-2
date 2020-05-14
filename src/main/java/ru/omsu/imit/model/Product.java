package ru.omsu.imit.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
public class Product {
    @Id
    private ObjectId id;
    @Indexed(unique=true)
    @Field(value="barcode")
    private long barcode;
    @Field(value="productName")
    private String productName;
    @Field(value="brandName")
    private String brandName;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barcode=" + barcode +
                ", productName='" + productName + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
