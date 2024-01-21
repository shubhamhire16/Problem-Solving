//153
//1*1*1 + 5*5*5 + 3*3*3 = 153

package PractiseQuestions;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int n = 153;
        int temp = n;
        int rem, sum=0;
        while(n>0){
            rem = n % 10;
            n = n/10;
            sum = sum + (rem*rem*rem);
        }
        if (sum==temp){
            System.out.println("Armstrong Number");
        }else{
            System.out.println("Not an Armstrong Number");
        }
    }
}
