package ru.netology.service;

public class ShopRepository {
    private Product[] products = new Product[0];

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current — массив, в который мы хотим добавить элемент
     * @param product — элемент, который мы хотим добавить
     * @return — возвращает новый массив, который выглядит, как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }


    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    /**
     * Метод добавления товара в репозиторий
     *
     * @param product — добавляемый товар
     */
    public void add(Product product) {
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }


    public Product[] removeById(int id) {
        Product remID = findById(id);
        if (remID == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        } else {
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;
        }
        return null;
    }
}