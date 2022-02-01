package me.giverplay.productsearch;

import me.giverplay.productsearch.product.Product;
import me.giverplay.productsearch.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProductSearch {

  private final List<Product> products = new ArrayList<>();

  public ProductSearch() {
    try {
      loadProducts();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  private void loadProducts() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/products.txt")));
    String line;

    while((line = reader.readLine()) != null) {
      String[] productEntry = line.split(";");

      int reference = Integer.parseInt(productEntry[0]);

      String description = productEntry[1];
      String barcode = null;

      try {
        Integer.parseInt(productEntry[2]);
        barcode = productEntry[2];
      } catch (NumberFormatException ignore) { }

      double price = Double.parseDouble(productEntry[3]);

      products.add(new Product(reference, description, barcode, price));
    }
  }

  public List<Product> search(String term) {
    Pattern pattern = StringUtils.toRegex(term);

    return products
      .stream()
      .filter(product -> pattern
        .matcher(product.getDescription())
        .find())
      .collect(Collectors.toList());
  }
}
