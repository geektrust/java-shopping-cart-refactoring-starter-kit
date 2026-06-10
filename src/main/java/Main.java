public class Main {
    /*
    ***********************************************
    * This is the driver code. Don't change it!!!
    ***********************************************
    */
    public static void main(String[] args) {
        String[] orders = {
            "Regular Electronics:100:2 Books:20:1",
            "Member Clothing:50:4",
            "VIP Electronics:100:1 Clothing:50:2",
            "Gold Books:20:1",
            "Regular Toys:30:2"
        };

        for (String order : orders) {
            ShoppingCart.handle(order);
        }
    }
}