package ru.omsu.imit.repositories;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ru.omsu.imit.model.Product;

@Repository
public class ProductAdminRepositoryImpl implements ProductAdminRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public long updateProduct(Product product) {
        Query query = new Query(Criteria.where("barcode").is(product.getBarcode()));
        Update update = new Update();
        update.set("name", product.getProductName());
        update.set("brand", product.getBrandName());

        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Product.class);

        if (result != null) {
            return result.getModifiedCount();
        }

        return 0;
    }

    @Override
    public long removeProduct(long barcode) {

        Query query = new Query(Criteria.where("barcode").is(barcode));

        DeleteResult result = mongoTemplate.remove(query, Product.class);

        if (result != null) {
            return result.getDeletedCount();
        }
        return 0;
    }
}
