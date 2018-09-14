package org.georgi.shop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart_elements")
public class CartElement extends AbstractTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long cartElementId;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @OneToMany(mappedBy = "cartElement", fetch = FetchType.EAGER)
    private Set<Product> productSetForElement;

    //Maybe other properties

    public CartElement() {}

    public CartElement(Cart cart) {
        this.cart = cart;
    }

    public long getCartElementId() {
        return cartElementId;
    }

    public void setCartElementId(long cartElementId) {
        this.cartElementId = cartElementId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<Product> getProductSetForElement() {
        return productSetForElement;
    }

    public void setProductSetForElement(Set<Product> productSetForElement) {
        this.productSetForElement = productSetForElement;
    }
}
