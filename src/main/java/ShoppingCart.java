import java.util.*;

public class ShoppingCart {

    private static final Map<String, Double> SHIPPING_COST_PER_ITEM = new HashMap<>();
    private static final Map<String, Double> DISCOUNT_RATE = new HashMap<>();

    static {
        SHIPPING_COST_PER_ITEM.put("Electronics", 10.0);
        SHIPPING_COST_PER_ITEM.put("Books", 0.0);
        SHIPPING_COST_PER_ITEM.put("Clothing", 5.0);

        DISCOUNT_RATE.put("Regular", 0.0);
        DISCOUNT_RATE.put("Member", 0.10);
        DISCOUNT_RATE.put("VIP", 0.20);
    }

    public static void main(String[] args) {
        /*
         * Format:
         * <CustomerType> <Category:Price:Quantity> ...
         *
         * Example:
         * Regular Electronics:100:2 Books:20:1
         */
        handle(args[0]);
    }

    private static void handle(String input) {
        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            System.out.println(
                "Invalid input. Format: <customerType> <category:price:quantity> ..."
            );
            return;
        }

        String customerType = parts[0];

        if (!DISCOUNT_RATE.containsKey(customerType)) {
            System.out.println("INVALID CUSTOMER TYPE");
            return;
        }

        double itemTotal = 0;
        double shipping = 0;

        for (int i = 1; i < parts.length; i++) {
            String[] fields = parts[i].split(":");

            if (fields.length != 3) {
                System.out.println("INVALID ITEM");
                return;
            }

            String category = fields[0];
            double price = Double.parseDouble(fields[1]);
            int quantity = Integer.parseInt(fields[2]);

            if (!SHIPPING_COST_PER_ITEM.containsKey(category)) {
                System.out.println("INVALID CATEGORY");
                return;
            }

            itemTotal += price * quantity;
            shipping += SHIPPING_COST_PER_ITEM.get(category) * quantity;
        }

        itemTotal *= (1 - DISCOUNT_RATE.get(customerType));

        if (customerType.equals("VIP")) {
            shipping = 0;
        }

        double total = itemTotal + shipping;

        System.out.printf("Order Total: %.2f%n", total);
    }
}