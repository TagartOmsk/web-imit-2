package ru.omsu.imit.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertProductRequest {

    private long barcode;
    private String productName;
    private String brandName;

    @JsonCreator
    public InsertProductRequest(
            @JsonProperty("barcode") long barcode,
            @JsonProperty("name") final String productName,
            @JsonProperty("brand") final String brandName){
        this.barcode = barcode;
        this.productName = productName;
        this.brandName = brandName;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }
}
