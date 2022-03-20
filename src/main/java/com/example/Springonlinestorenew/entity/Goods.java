package com.example.Springonlinestorenew.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Category should not be blank!")
    private String category;
    @NotBlank(message = "Goods Code should not be blank!")
    private String goodsCode;
    @NotBlank(message = "Color should not be blank!")
    private String color;
    @NotNull(message = "Price should not be null!")
    private Double price;
    @Column(nullable = true, length = 64)
    private String photos;
    private String image;



    public Goods() {
    }

    public Goods(Long id, String category, String goodsCode, String color, Double price) {
        this.id = id;
        this.category = category;
        this.goodsCode = goodsCode;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public void setImage(String image) {
        this.image= image;
    }


//    public String getPhotosImagePath() {
//        if (photos == null || id == null) return null;
//
//        return "/user-photos/" + id + "/" + photos;
//    }


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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
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
