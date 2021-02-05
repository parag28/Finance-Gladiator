package com.development.demo.DTO;

public class PurchaseProductDTO {
  private int productId;
  private String userName;
  private int quantity;
  private int numberOfEmis;

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getNumberOfEmis() {
    return numberOfEmis;
  }

  public void setNumberOfEmis(int numberOfEmis) {
    this.numberOfEmis = numberOfEmis;
  }
}
