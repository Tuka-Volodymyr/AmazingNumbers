package numbers;
public class Property {
    protected static boolean even(long inputIntegers) {
        return inputIntegers % 2 == 0;
    }
    protected static boolean odd(long inputIntegers) {
        return inputIntegers % 2 != 0;
    }
    protected static boolean buzz(long inputIntegers, String toStringIntegers, int len) {
        return inputIntegers % 7 == 0 || toStringIntegers.charAt(len - 1) == '7';
    }
    protected static boolean duck(String toStringIntegers, int len) {
        boolean duck = false;
        for (int i = 1; i < len; i++) {
            if (toStringIntegers.charAt(i) == '0') {
                duck = true;
                break;
            }
        }
        return duck;
    }
    protected static boolean palindromic(String toStringIntegers, int len) {
        boolean palindromic = false;
        String toStingIntegerPalindromic = "";
        for (int i = len - 1; i >= 0; i--) {
            toStingIntegerPalindromic += toStringIntegers.charAt(i);
        }
        if (toStringIntegers.equals(toStingIntegerPalindromic)) palindromic = true;
        return palindromic;
    }
    protected static boolean gapful(int len, String toStringIntegers, long inputIntegers) {
        boolean gapful = false;
        if (len >= 3) {
            String strDivider = "" + toStringIntegers.charAt(0) + toStringIntegers.charAt(len - 1);
            int divider = Integer.parseInt(strDivider);
            if (inputIntegers % divider == 0) gapful = true;
        }
        return gapful;
    }
    protected static boolean spy(String toStringIntegers, int len) {
        int suma = 0, product = 1;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.parseInt(String.valueOf(toStringIntegers.charAt(i)));
        }
        for (int i = 0; i < len; i++) {
            suma += array[i];
            product *= array[i];
        }
        return suma == product;
    }
    protected static boolean square(long inputInteger) {
        double squareDouble = Math.sqrt(inputInteger);
        long squareLong = (long) squareDouble;
        return squareDouble == squareLong;
    }
    protected static boolean sunny(long inputInteger) {
        double squareDouble = Math.sqrt(inputInteger + 1);
        long squareLong = (long) squareDouble;
        return squareDouble == squareLong;
    }
    protected static boolean jumping(String toStringIntegers,int len){
        boolean jumping = false;
        int count=0,j;
        if(len==1)jumping=true;
        for(int i=0;i<len-1;i++){
            j=i+1;
            int num1=(int) toStringIntegers.charAt(i);
            int num2=(int) toStringIntegers.charAt(j);
            if(num1-1==num2||num1+1==num2) {
                count++;
                if (count == len-1) jumping = true;
            }
        }
        return jumping;
    }
    protected static boolean happy(long inputInteger){
        if (inputInteger == 1 || inputInteger == 7)
            return true;
        long sum = inputInteger, x = inputInteger;
        while(sum > 9) {
            sum = 0;
            while (x > 0) {
                long d = x%10;
                sum += d*d;
                x/=10;
            }
            if (sum == 1)
                return true;
            x = sum;
        }
        if(sum == 7)
            return true;
        return false;
    }

}
