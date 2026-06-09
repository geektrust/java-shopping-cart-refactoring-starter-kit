public class Main {
    /*
    ***********************************************
    * This is the driver code. Don't change it!!!
    ***********************************************
    */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(
                "Please provide input: <customerType> <category:price:quantity> ..."
            );
            return;
        }

        handle(args[0]);
    }

    private static void handle(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println(
                "Invalid input. Format: <customerType> <category:price:quantity> ..."
            );
            return;
        }

        // Forward the complete input string to ShoppingCart
        String[] shoppingCartArgs = { input.trim() };
        ShoppingCart.main(shoppingCartArgs);
    }
}