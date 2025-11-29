import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PolicyManagementApp {
    static class PolicyHolder {
        private String policyId;
        private String name;
        private double investmentAmount;
        private int yearsInForce;
        public PolicyHolder(String policyId, String name, double investmentAmount, int yearsInForce) {
            this.policyId = policyId;
            this.name = name;
            this.investmentAmount = investmentAmount;
            this.yearsInForce = yearsInForce;
        }
        public String getPolicyId() { return policyId; }
        public void setPolicyId(String policyId) { this.policyId = policyId; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public double getInvestmentAmount() { return investmentAmount; }
        public void setInvestmentAmount(double investmentAmount) { this.investmentAmount = investmentAmount; }

        public int getYearsInForce() { return yearsInForce; }
        public void setYearsInForce(int yearsInForce) { this.yearsInForce = yearsInForce; }

        @Override
        public String toString() {
            return "Policy ID: " + policyId +
                   ", Name: " + name +
                   ", Investment: " + investmentAmount +
                   ", Years In Force: " + yearsInForce;
        }
    }
    static List<PolicyHolder> policyList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== POLICY HOLDER MANAGEMENT =====");
            System.out.println("1. Add Policy Holder");
            System.out.println("2. View All Policy Holders");
            System.out.println("3. Calculate Maturity Value");
            System.out.println("4. Find Policy Holders (Investment > 100000)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addPolicyHolder();
                case 2 -> viewPolicyHolders();
                case 3 -> calculateMaturityMenu();
                case 4 -> findListPolicyHolders();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }
    public static void addPolicyHolder() {
        sc.nextLine(); 

        System.out.print("Enter Policy ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Investment Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Years In Force: ");
        int years = sc.nextInt();

        policyList.add(new PolicyHolder(id, name, amount, years));
        System.out.println("Policy Holder Added Successfully!");
    }
    public static void viewPolicyHolders() {
        if (policyList.isEmpty()) {
            System.out.println("No policy holders found!");
            return;
        }
        System.out.println("\n--- LIST OF POLICY HOLDERS ---");
        for (PolicyHolder ph : policyList) {
            System.out.println(ph);
        }
    }
    public static double calculateMaturityValue(double investmentAmount, int yearsInForce) {
        return investmentAmount * Math.pow((1 + 0.08), yearsInForce);
    }
    public static void calculateMaturityMenu() {
        System.out.print("Enter Investment Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Years In Force: ");
        int years = sc.nextInt();

        double maturity = calculateMaturityValue(amount, years);
        System.out.println("Maturity Value = " + maturity);
    }
    public static void findListPolicyHolders() {
        System.out.println("\n--- POLICY HOLDERS WITH INVESTMENT > 100000 ---");

        boolean found = false;

        for (PolicyHolder ph : policyList) {
            if (ph.getInvestmentAmount() > 100000) {
                System.out.println(ph);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Policy Holder Found With Investment > 100000");
        }
    }
}

/*
 INSTRUCTIONS TO COMPILE & RUN 

1. Save the file with name:
   PolicyManagementApp.java

2. Open terminal/command prompt and navigate to the folder
   containing the .java file.

3. Compile the Java file using:
   javac PolicyManagementApp.java

4. Run the program using:
   java PolicyManagementApp

*/