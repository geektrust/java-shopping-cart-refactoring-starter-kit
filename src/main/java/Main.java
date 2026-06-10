public class Main {
    
    public static void main(String[] args) {

        /*
        ***********************************************
        * This is the driver code. Don't change it!!!
        ***********************************************
        */
        String[] orders = {
            "Regular Electronics:100:2 Books:20:1",
            "Member Clothing:50:4",
            "VIP Electronics:100:1 Clothing:50:2",
            "Gold Books:20:1",
            "Regular Toys:30:2"
        };
        
        if (args.length == 0) {
            System.out.println("Arguments are required to run the program.");
            return;
        }

        String input = args[0].trim();

        for (String order : orders) {
            if (order.equals(input)) {
                ShoppingCart.handle(order);
                return;
            }

        }
    }
}
