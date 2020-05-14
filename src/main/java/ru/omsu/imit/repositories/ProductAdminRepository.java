package ru.omsu.imit.repositories;

import ru.omsu.imit.model.Product;

public interface ProductAdminRepository {

    long updateProduct(Product product);

    long removeProduct(long barcode);
}
