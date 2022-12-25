package numbers;
import java.util.Arrays;
public class Output {
    protected static void printOneNum(long inputIntegers,int len,String toStringIntegers){
        System.out.printf("Properties of %d",inputIntegers);
        System.out.printf("\n\tbuzz: %b%n", Property.buzz(inputIntegers,toStringIntegers,len));
        System.out.printf("\tduck: %b%n",Property.duck(toStringIntegers,len));
        System.out.printf("palindromic: %b%n", Property.palindromic(toStringIntegers,len));
        System.out.printf("\tgapful: %b%n",Property.gapful(len , toStringIntegers,inputIntegers));
        System.out.printf("\teven: %b%n",Property.even(inputIntegers));
        System.out.printf("\todd: %b%n",Property.odd(inputIntegers));
        System.out.printf("\tspy: %b%n",Property.spy(toStringIntegers,len));
        System.out.printf("\tsquare: %b%n",Property.square(inputIntegers));
        System.out.printf("\tsunny: %b%n",Property.sunny(inputIntegers));
        System.out.printf("\tjumping: %b%n",Property.jumping(toStringIntegers,len));
        System.out.printf("\tsad: %b%n",!Property.happy(inputIntegers));
        System.out.printf("\thappy: %b%n",Property.happy(inputIntegers));
    }
    protected static void printTwoNum(String toStringIntegers,long inputIntegers,int len){
        StringBuilder result=new StringBuilder();
        if(Property.spy(toStringIntegers,len))result.append(" spy");
        if(Property.even(inputIntegers))result.append(" even");
        if(Property.odd(inputIntegers))result.append(" odd");
        if(Property.buzz(inputIntegers,toStringIntegers,len))result.append(" buzz");
        if(Property.duck(toStringIntegers,len))result.append(" duck");
        if(Property.palindromic(toStringIntegers,len))result.append(" palindromic");
        if(Property.gapful( len ,  toStringIntegers,inputIntegers))result.append(" gapful");
        if(Property.square(inputIntegers))result.append(" square");
        if(Property.sunny(inputIntegers))result.append(" sunny");
        if(Property.jumping(toStringIntegers,len))result.append(" jumping");
        if(!Property.happy(inputIntegers))result.append(" sad");
        if(Property.happy(inputIntegers))result.append(" happy");

        System.out.println();
        System.out.printf("%d is%s", inputIntegers,result);
    }
    protected static void allProperties(String[] arrayProperty){
        System.out.printf("\nAvailable properties: %s", Arrays.toString(arrayProperty));
    }
    protected static void rules(){
        System.out.println("""
                Welcome to Amazing Numbers!
                \nSupported requests:
                 - enter a natural number to know its properties;
                 - enter two natural numbers to obtain the properties of the list:
                   * the first parameter represents a starting number;
                   * the second parameter shows how many consecutive numbers are to be printed;
                 - two natural numbers and properties to search for;
                 - a property preceded by minus must not be present in numbers;
                 - separate the parameters with one space;
                 - enter 0 to exit.""");
    }
    protected static void printException(String [] inpArray,String property,String secProperty,String[] arrayProperty,
                                         int arLen,String thirdProperty,String fourthProperty,String fifthProperty) {
        if(arLen>=3)property=Exceptions.negative(property);
        if(arLen>=4)secProperty=Exceptions.negative(secProperty);
        if(arLen>=5)thirdProperty=Exceptions.negative(thirdProperty);
        if(arLen>=6)fourthProperty=Exceptions.negative(fourthProperty);
        if(arLen>=7)fifthProperty=Exceptions.negative(fifthProperty);
        if (Exceptions.firstException(inpArray)) {
            System.out.println("The first parameter should be a natural number or zero.");
        } else if (arLen >= 2 && Exceptions.secondException(inpArray)) {
            System.out.println("The second parameter should be a natural number.");
        } else if (arLen >= 4 && Exceptions.excWithPar(arrayProperty,property) && Exceptions.excWithPar(arrayProperty,secProperty )) {
            System.out.printf("The properties [%s, %s] are wrong.", property, secProperty);
            allProperties(arrayProperty);
        } else if (arLen >= 3 && Exceptions.excWithPar(arrayProperty,property)) {
            System.out.printf("The property [%s] is wrong.", property);
            allProperties(arrayProperty);
        } else if (arLen >= 4 && Exceptions.excWithPar(arrayProperty,secProperty)) {
            System.out.printf("The property [%s] is wrong.", secProperty);
            allProperties(arrayProperty);
        }else if(arLen >= 5 && Exceptions.excWithPar(arrayProperty,thirdProperty)){
            System.out.printf("The property [%s] is wrong.", thirdProperty);
            allProperties(arrayProperty);
        } else if (arLen >= 6 && Exceptions.excWithPar(arrayProperty,fourthProperty)) {
            System.out.printf("The property [%s] is wrong.", fourthProperty);
            allProperties(arrayProperty);
        }else if(arLen >= 7 && Exceptions.excWithPar(arrayProperty,fifthProperty)){
            System.out.printf("The property [%s] is wrong.", fifthProperty);
            allProperties(arrayProperty);
        } else if (arLen >= 4 && Exceptions.mutuallyExc(inpArray,arLen)) {
            System.out.println("The request contains mutually exclusive properties!!!");
            System.out.println("There are no numbers with these properties.");
        }
    }
}
