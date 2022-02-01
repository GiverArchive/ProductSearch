package me.giverplay.productsearch;

import me.giverplay.productsearch.product.Product;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    ProductSearch search = new ProductSearch();
    printSearch(search, "arruela");
    printSearch(search, "parafuso");
    printSearch(search, "10%parafuso");
  }

  private static void printSearch(ProductSearch search, String term) {
    System.out.println("\nSearching for '" + term + "'");

    List<Product> result = search.search(term);

    if(result.isEmpty()) {
      System.out.println("Search '" + term + "' returned no results");
    } else {
      result.forEach(product -> System.out.println("\n" + product));
    }
  }
}
