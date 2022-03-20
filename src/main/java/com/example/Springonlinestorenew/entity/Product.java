package com.example.Springonlinestorenew.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Category should not be blank!")
    private String category;
    @NotBlank(message = "Goods Code should not be blank!")
    private String code;
    @NotBlank(message = "Color should not be blank!")
    private String color;
    @NotNull(message = "Price should not be null!")
    private Double price;
    @Column(nullable = true, length = 64)
    private String photos;
    private String image;



    public Product() {
    }

    public Product(Long id, String category, String code, String color, Double price) {
        this.id = id;
        this.category = category;
        this.code = code;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", code='" + code + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public void setImage(String image) {
        this.image= image;
    }

    public String getImage() {
        return this.image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
