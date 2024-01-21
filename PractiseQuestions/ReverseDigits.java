package PractiseQuestions;

public class ReverseDigits {
    public static int reverseNumber(int num){
        int rev_num = 0;
        while (num>0){
            rev_num = rev_num * 10 + num % 10;
            num = num/10;
//            System.out.println("rev_num: "+rev_num);
//            System.out.println("num: "+num);
        }
        return rev_num;
    }

    public static void main(String[] args) {
        int num = 2345;
        System.out.println("Reversed num: "+reverseNumber(num));
    }
}
