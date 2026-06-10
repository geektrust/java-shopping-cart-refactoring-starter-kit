
public class ShoppingCart {

    public static void handle(String input) {
    String[] parts = input.split(" ");

    String customer = parts[0];

    double discount = 0;
    if (customer.equals("Regular")) {
        discount = 0;
    } else if (customer.equals("Member")) {
        discount = 10;
    } else if (customer.equals("VIP")) {
        discount = 20;
    } else {
        System.out.println("INVALID CUSTOMER TYPE");
        return;
    }

    double total = 0;
    int shipping = 0;

    for (int i = 1; i < parts.length; i++) {
        String[] item = parts[i].split(":");

        String category = item[0];
        int price = Integer.parseInt(item[1]);
        int quantity = Integer.parseInt(item[2]);

        total += price * quantity;

        if (category.equals("Electronics")) {
            shipping += 10 * quantity;
        } else if (category.equals("Books")) {
            shipping += 0;
        } else if (category.equals("Clothing")) {
            shipping += 5 * quantity;
        } else {
            System.out.println("INVALID CATEGORY");
            return;
        }
    }

    if (!customer.equals("VIP")) {
        total += shipping;
    }

    total = total - (total * discount / 100);

    System.out.printf("Order Total: %.2f\n", total);
}
}