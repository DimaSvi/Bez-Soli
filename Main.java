import java.util.*;

class CafeOrder {
    private Map<String, Double> menu = new HashMap<>();
    private Map<String, Integer> order = new HashMap<>();

    public CafeOrder() {
        menu.put("Кава", 50.0);
        menu.put("Чай", 30.0);
        menu.put("Торт", 70.0);
    }

    public void addItem(String name, int quantity) {
        if (!menu.containsKey(name)) {
            System.out.println("Такої страви немає: " + name);
            return;
        }

        order.put(name, order.getOrDefault(name, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0;

        for (String item : order.keySet()) {
            total += menu.get(item) * order.get(item);
        }

        if (total > 200) {
            total *= 0.9;
        }

        return total;
    }

    public void printReceipt() {
        System.out.println("ЧЕК:");

        for (String item : order.keySet()) {
            System.out.println(item + " x" + order.get(item));
        }

        System.out.println("Сума: " + calculateTotal());
    }
}

public class Main {
    public static void main(String[] args) {
        CafeOrder order = new CafeOrder();

        order.addItem("Кава", 2);
        order.addItem("Торт", 3);

        order.printReceipt();
    }
}