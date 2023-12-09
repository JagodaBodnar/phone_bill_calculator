import java.util.Scanner;

public class PhoneBillCalculator {
    static double taxRate = .15;
    static double overageMinutesFee = .25;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double planFee = getPlanFee();
        double overageMinutes = getOverageMinutes();
        scanner.close();

        double overage = calculateOverageFees(overageMinutes);
        double tax = calculateTax(planFee, overage);
        double totalFee = calculateTotalFee(tax, planFee, overage);
        printItemizedBill(planFee, overage, tax, totalFee);

    }

    public static double getPlanFee() {
        System.out.println("Enter plan fee:");
        return scanner.nextDouble();
    }

    public static double getOverageMinutes() {
        System.out.println("Enter overage minutes:");
        return scanner.nextDouble();
    }

    public static double calculateOverageFees(double overageMinutes) {
        return overageMinutes * overageMinutesFee;
    }

    public static double calculateTax(double planFee, double overage) {
        return (planFee + overage) * taxRate;
    }

    public static double calculateTotalFee(double tax, double planFee, double overage) {
        return tax + planFee + overage;
    }

    public static void printItemizedBill(double planFee, double overage, double tax, double total) {
        System.out.printf("Phone bill statement: %nPlan: $%.2f %nOverage: $%.2f %nTax: $%.2f %nTotal: $%.2f %n", planFee, overage, tax, total);
    }

}
