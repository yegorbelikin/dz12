package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product item1 = new Product(123, "Чай", 100);
    Product item2 = new Product(456, "Кофе", 200);
    Product item3 = new Product(789, "Какао", 150);
    Product item4 = new Product(321, "Сено", 50);

    ShopRepository repo = new ShopRepository();


    @Test
    public void removeById() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        Product[] expected = {item2, item3, item4};
        Product[] actual = repo.removeById(123);


    }

    @Test
    public void removeNotFoundId() {

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        Assertions.assertThrows(NotFoundException.class, () -> {repo.removeById(12);});


    }
}
