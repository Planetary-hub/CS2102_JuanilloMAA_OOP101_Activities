import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] itemNames = {"Chicken Burger", "Pizza Marinara", "Fettucine", "Egg Sandwich", "Cold Brew Coffee"};
        double[] itemPrices = {80.00, 150.00, 100.00, 55.00, 75.00};
        int menuSize = itemNames.length;

        int totalQuantity = 0;
        double totalBeforeDiscount = 0.0;
        double totalDiscount = 0.0;
        double finalAmount = 0.0;

        System.out.println("= = = = = = = = = = = = = = =");
        System.out.println(" = = = =  M E N U  = = = = = ");
        System.out.println("= = = = = = = = = = = = = = =");
        for (int i = 0; i < menuSize; i++) {
            System.out.printf("%d. %-10s- $%.2f%n", i + 1, itemNames[i], itemPrices[i]);
        }

        String orderAgain = "Y";

        while (orderAgain.equalsIgnoreCase("Y")) {
            System.out.println();
            System.out.print("Enter item number: ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            String studentAnswer = scanner.next();
            boolean isStudent = studentAnswer.equalsIgnoreCase("Y");

            boolean validItem = (itemNumber >= 1 && itemNumber <= menuSize);
            boolean validQuantity = (quantity >= 1 && quantity <= 10);

            if (!validItem || !validQuantity) {
                System.out.println();
                System.out.println("Invalid order! Please enter a valid item and quantity.");
            } else {
                double price = itemPrices[itemNumber - 1];
                double subtotal = price * quantity;

                double discountRate;
                if (isStudent && subtotal >= 500) {
                    discountRate = 0.15;
                } else if (isStudent) {
                    discountRate = 0.10;
                } else if (subtotal >= 500) {
                    discountRate = 0.05;
                } else {
                    discountRate = 0.0;
                }

                double discount = subtotal * discountRate;
                double orderTotal = subtotal - discount;

                System.out.println();
                System.out.printf("Subtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discount);
                System.out.printf("Order total: $%.2f%n", orderTotal);

                totalQuantity += quantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += discount;
                finalAmount += orderTotal;
            }

            System.out.println();
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next();
        }

        System.out.println();
        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalQuantity);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}