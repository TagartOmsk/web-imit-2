package ru.omsu.imit.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.omsu.imit.model.Product;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    Product getByBarcode(long barcode);

    List<Product> getByBrandName(String brandName);

    List<Product> findByProductName(String name);
}
