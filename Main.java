package numbers;
import java.util.Scanner;
public class Main {
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        maker();
    }
    protected static void maker () {
        String property = "";
        String secProperty = "";
        String thirdProperty="";
        String fourthProperty="";
        String fifthProperty= "";
        String[] arrayProperty = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY",
                "JUMPING","SAD","HAPPY"};
        Output.rules();
        while (true) {
            System.out.println();
            System.out.println("Enter a request:");
            String inputIntegers = scanner.nextLine();
            String[] inpArray = inputIntegers.split(" ");
            int len = inpArray[0].length();
            int arLen = inpArray.length;
            for(int i =2;i<arLen;i++){
                inpArray[i]=inpArray[i].toUpperCase();
            }
            if (arLen >= 3) property = inpArray[2];
            if (arLen >= 4) secProperty = inpArray[3];
            if (arLen >= 5) thirdProperty = inpArray[4];
            if(arLen>=6)fourthProperty=inpArray[5];
            if (arLen >= 7) fifthProperty = inpArray[6];
            if(Exceptions.general(inpArray, property, secProperty, arrayProperty, arLen,thirdProperty,fourthProperty,fifthProperty)){
                Output.printException(inpArray, property, secProperty, arrayProperty, arLen,thirdProperty,fourthProperty,fifthProperty);
            }else {
                if (inputIntegers.equals("0")) {
                    System.out.println("Goodbye!");
                    break;
                }
                if (arLen == 1) {
                    Output.printOneNum(Long.parseLong(inpArray[0]), len, inputIntegers);
                } else if (arLen == 2) {
                    twoNum(inpArray);
                } else {
                    twoNumWithProperty(inpArray, arrayProperty, property, secProperty,thirdProperty,fourthProperty,
                            fifthProperty,arLen);
                }
            }

        }
    }
    protected static void twoNum(String[] inpArray){
        long firstNum=Long.parseLong(inpArray[0]);
        long secondNum = Long.parseLong(inpArray[1]);
        for(int i=0;i<secondNum;){
            long inputIntegers = firstNum + i;
            String toStringIntegers=String.valueOf(inputIntegers);
            int len =toStringIntegers.length();
            Output.printTwoNum(toStringIntegers, inputIntegers, len);
            i++;
        }
    }
    protected static void twoNumWithProperty(String[] inpArray,String[] arrayProperty,String property,String secProperty,
                                                 String thirdProperty,String fourthProperty,String fifthProperty ,int arLen) {
        boolean condition1 = false, condition2 = false, condition3 = false, condition4 = false;
        boolean condition5=false;
        long firstNum = Long.parseLong(inpArray[0]);
        long secondNum = Long.parseLong(inpArray[1]);
        int i = 0, count = 0;
        while (count < secondNum) {
            long inputIntegers = firstNum + i;
            String toStringIntegers = String.valueOf(inputIntegers);
            int len = toStringIntegers.length();
            if (arLen >= 3) condition1 = Conditions.Condition(arrayProperty, property, condition1, inputIntegers, toStringIntegers, len);
            if (arLen >= 4) condition2 = Conditions.Condition(arrayProperty, secProperty, condition2, inputIntegers, toStringIntegers, len);
            if (arLen >= 5) condition3 = Conditions.Condition(arrayProperty, thirdProperty, condition3, inputIntegers, toStringIntegers, len);
            if (arLen >= 6) condition4 = Conditions.Condition(arrayProperty, fourthProperty, condition4, inputIntegers, toStringIntegers, len);
            if(arLen>=7) condition5=Conditions.Condition(arrayProperty, fifthProperty, condition5, inputIntegers, toStringIntegers, len);
            if(arLen >= 3&&property.charAt(0)=='-')condition1=!condition1;
            if(arLen >= 4&&secProperty.charAt(0)=='-')condition2=!condition2;
            if(arLen >= 5&&thirdProperty.charAt(0)=='-')condition3=!condition3;
            if(arLen >= 6&&fourthProperty.charAt(0)=='-')condition4=!condition4;
            if(arLen >= 7&&fifthProperty.charAt(0)=='-')condition5=!condition5;
            if (condition1 && condition2 && condition3 && condition4&&condition5&&arLen==7) {
                 Output.printTwoNum(toStringIntegers, inputIntegers, len);
                 count++;
            }else if (condition1 && condition2 && condition3 && condition4&&arLen==6) {
                Output.printTwoNum(toStringIntegers, inputIntegers, len);
                count++;
            } else if (condition1 && condition2 && condition3&&arLen==5) {
                Output.printTwoNum(toStringIntegers, inputIntegers, len);
                count++;
            } else if (condition1 && condition2&&arLen==4) {
                Output.printTwoNum(toStringIntegers, inputIntegers, len);
                count++;
            } else if (condition1&&arLen==3) {
                Output.printTwoNum(toStringIntegers, inputIntegers, len);
                count++;
            }
            i++;
        }
    }
}


