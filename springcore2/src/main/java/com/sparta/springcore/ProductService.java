package com.sparta.springcore;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class ProductService {

    private static ProductRepository productRepository;

    public  ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public static Product createProduct(ProductRequestDto requestDto) throws SQLException {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);


        productRepository.creatProduct(product);

        return product;

    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = ProductRepository.getProduct(id);
         if (product==null){
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }

         productRepository.updateMyprice(id, requestDto.getMyprice());

         return product;

//// DB 연결
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
//
//// DB Query 작성
//        PreparedStatement ps = connection.prepareStatement("select * from product where id = ?");
//        ps.setLong(1, id);
//
//// DB Query 실행
//        ResultSet rs = ps.executeQuery();
//        if (rs.next()) {
//            product.setId(rs.getLong("id"));
//            product.setImage(rs.getString("image"));
//            product.setLink(rs.getString("link"));
//            product.setLprice(rs.getInt("lprice"));
//            product.setMyprice(rs.getInt("myprice"));
//            product.setTitle(rs.getString("title"));
//        }

//// DB Query 작성
//        ps = connection.prepareStatement("update product set myprice = ? where id = ?");
//        ps.setInt(1, requestDto.getMyprice());
//        ps.setLong(2, product.getId());
//
//// DB Query 실행
//        ps.executeUpdate();
//
//// DB 연결 해제
//        rs.close();
//        ps.close();
//        connection.close
    }

    public List<Product> getProducts() throws SQLException {
        List<Product> products = productRepository.getProducts();

        return products;






    }
}
