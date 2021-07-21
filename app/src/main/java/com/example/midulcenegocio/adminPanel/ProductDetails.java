package com.example.midulcenegocio.adminPanel;
//Class with product information
public class ProductDetails {

    public String Product,Category,Price,ImageURL,RandomUID,Adminid;
    // Alt+insert

    public ProductDetails(String product, String category, String price, String imageURL, String randomUID, String adminid) {
        Product = product;
        Category = category;
        Price = price;
        ImageURL = imageURL;
        RandomUID = randomUID;
        Adminid = adminid;
    }
}
