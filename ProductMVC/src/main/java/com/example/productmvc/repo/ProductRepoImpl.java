package com.example.productmvc.repo;

import com.example.productmvc.model.Product;
import com.example.productmvc.util.Constrain;
import com.example.productmvc.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductRepoImpl implements ProductRepo {
    LocalDate localDate = LocalDate.now();
//    private static List<Product> productList;
//    private static LocalDate date = LocalDate.now();
//
//    static {
//        productList = new ArrayList<>();
//        productList.add(new Product(1, "Laptop Dell N1440", 1, 12000000, date, "Good", "Laptop"));
//        productList.add(new Product(2, "Laptop Asus Zenbook", 2, 13000000, date, "Ok", "Laptop"));
//        productList.add(new Product(3, "Iphone 14 pro max", 3, 14000000, date, "Bad", "Smart Phone"));
//        productList.add(new Product(4, "Samsung ZFlip", 4, 15000000, date, "Not Good", "Smart Phone"));
//        productList.add(new Product(5, "LG Oled C2 48inch", 5, 16000000, date, "Good", "TiVi"));
//    }

    @Override
    public void add(Product product) {
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(Constrain.CREATE_PRODUCT);
                ) {
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setLong(4,product.getPrice());
            preparedStatement.setDate(5, Date.valueOf(product.getDateRelease()));
            preparedStatement.setString(6,product.getDescription());
            preparedStatement.setString(7,product.getCategory());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
//        productList.add(product);
    }

    @Override
    public void delete(Product product) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constrain.DELETE_PRODUCT_BY_ID);
        ){
            statement.setInt(1, product.getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
//        productList.remove(product);
    }

    @Override
    public Product findByName(String name) {
//        for (Product p : productList) {
//            if (p.getName().equals(name)) {
//                return p;
//            }
//        }
        return null;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(Constrain.FIND_PRODUCT_BY_ID);
        ) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                LocalDate date = resultSet.getDate("date_realease").toLocalDate();
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                product = new Product(id,name,quantity,price,date,description,category);
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
//        return productList;
        return product;
    }

    @Override
    public void update(Product product) {
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(Constrain.UPDATE_PRODUCT);
        ) {
            preparedStatement.setInt(7,product.getId());
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.setLong(3,product.getPrice());
            preparedStatement.setDate(4, Date.valueOf(product.getDateRelease()));
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setString(6,product.getCategory());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

//       productList.add(product);
//        for (Product p : productList) {
//            if (p.equals(product)) {
//                p.setCategory(product.getCategory());
//                p.setDescription(product.getDescription());
//                p.setDateRelease(product.getDateRelease());
//                p.setPrice(product.getPrice());
//                p.setQuantity(product.getQuantity());
//                p.setName(product.getName());
//            }
//        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try(
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(Constrain.FIND_ALL_PRODUCT);
            Product product;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                LocalDate date = resultSet.getDate("date_realease").toLocalDate();
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                product = new Product(id,name,quantity,price,date,description,category);
                products.add(product);
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
//        return productList;
        return products;
    }
}
