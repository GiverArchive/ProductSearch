package me.giverplay.productsearch.product;

public class Product {

  private final String description;
  private final String barcode;

  private final int reference;
  private final double price;

  public Product(int reference, String description, String barcode, double price) {
    this.reference = reference;
    this.description = description;
    this.barcode = barcode;
    this.price = price;
  }

  public Product(int reference, String description, float price) {
    this(reference, description, null, price);
  }

  public String getDescription() {
    return description;
  }

  public String getBarcode() {
    return barcode;
  }

  public int getReference() {
    return reference;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return String.format("Reference: %d\nDescription: %s\nBarcode: %s\nPrice: %.2f", reference, description, barcode, price);
  }
}
