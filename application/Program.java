package application;

//Bibliotecas padrão
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//importando a entities
import entities.Product;
import entities.ImportedProduct;
import entities.UsedProduct;

public class Program{
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    
    List<Product> list = new ArrayList<>();

    System.out.println("Enter the number of products: ");
    int n = sc.nextInt();

    for(int i = 1; i<n; i++){
      System.out.println("Product #" + i + " data");
      System.out.println("Common,used or imported(c/u/i)? ");
      char ch = sc.next().charAt(0);
      System.out.println("Name: ");
      sc.nextLine();
      String name = sc.nextLine();
      System.out.println("Price: ");
      double price = sc.nextDouble();

      if(ch == 'c'){
        list.add(new Product(name,price));
      }
      else if(ch == 'u'){
        System.out.println("Manufacture day (DD/MM/YYYY)");
        LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        list.add(new UsedProduct(name,price,date));
      }
      else{
        System.out.println("CustomFee: ");
        double customsFee = sc.nextDouble();
        list.add(new ImportedProduct(name,price,customsFee));
      }
      System.out.println();
      System.out.println("ETIQUETAS DE PREÇO: ");
      for(Product prod : list){
        System.out.println(prod.priceTag());
      }
    }


    sc.close();
  }
}