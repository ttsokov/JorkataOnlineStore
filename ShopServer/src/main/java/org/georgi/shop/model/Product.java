package org.georgi.shop.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends AbstractTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "price", nullable = false)
    private double price;

    @Transient
    private MultipartFile image;

    @ManyToOne
    @JoinColumn(name = "cart_element_id")
    private CartElement cartElement;

    public Product() {}

    public Product(String productName, String productDescription, Category category, double price, MultipartFile image) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public Product(String productName, String productDescription, Category category, double price, MultipartFile image, CartElement cartElement) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.category = category;
        this.price = price;
        this.image = image;
        this.cartElement = cartElement;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public CartElement getCartElement() {
        return cartElement;
    }

    public void setCartElement(CartElement cartElement) {
        this.cartElement = cartElement;
    }
}
