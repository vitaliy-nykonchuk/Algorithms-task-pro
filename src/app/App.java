package app;

import app.data.DataProvider;
import app.data.Product;
import app.services.DataService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        double priceSearch = getSearchValue();
        DataProvider provider = new DataProvider();
        List<Product> list = provider.getData();
        getOutput(list);
        DataService service = new DataService();
        int index = service.search(list, priceSearch);
        getOutput(list, priceSearch, index);
    }

    private static double getSearchValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter price value to search (x.xx): ");
        return Double.parseDouble(scanner.next());
    }

    private static void getOutput(List<Product> list) {
        System.out.println("Initial data:");

        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            System.out.println((i + 1) + ") " +
                    product.name() + ", USD " + product.price());
        }
    }

    private static void getOutput(List<Product> list, double priceSearch, int index) {
        System.out.println("------------------------");
        if (index == -1)
            System.out.println("No data.");
        else
            System.out.println("Product: " + list.get(index).name() +
                    ", USD " + priceSearch);
    }
}
