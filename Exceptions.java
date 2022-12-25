package numbers;
public class Exceptions {
    protected static boolean firstException(String[] inpArray) {
        long firstNum = Long.parseLong(inpArray[0]);
        return firstNum < 0;
    }
    protected static boolean secondException(String[] inpArray) {
        long secondNum = Long.parseLong(inpArray[1]);
        return secondNum < 0;
    }
    protected static String negative(String property){
        if (property.charAt(0) == '-') {
            property=property.substring(1);

        }
        return property;
    }
    protected static boolean excWithPar(String[] arrayProperty, String property) {
        boolean exception = false;
        for (String s : arrayProperty) {
            if (property.equals(s)) {
                exception = false;
                break;
            } else {
                exception = true;
            }
        }
        return exception;
    }
    protected static boolean mutuallyExc(String[] inpArray,int arLen) {
        boolean exception = false;
        for(int i =2;i<arLen;i++){
            for (int j =3;j<arLen;j++){

                if(inpArray[i]!=negative(inpArray[i])&&inpArray[j]!=negative(inpArray[j])){
                    inpArray[i]=negative(inpArray[i]);
                    inpArray[j]=negative(inpArray[j]);
                }
                if(inpArray[i].equals("-ODD"))inpArray[i]="EVEN";
                if(inpArray[j].equals("-ODD"))inpArray[j]="EVEN";
                if(inpArray[i].equals("-EVEN"))inpArray[i]="ODD";
                if(inpArray[j].equals("-EVEN"))inpArray[j]="ODD";
                if(inpArray[i].equals("-DUCK"))inpArray[i]="SPY";
                if(inpArray[j].equals("-DUCK"))inpArray[j]="SPY";
                if(inpArray[i].equals("-SPY"))inpArray[i]="DUCK";
                if(inpArray[j].equals("-SPY"))inpArray[j]="DUCK";
                if(inpArray[i].equals("EVEN")&&inpArray[j].equals("ODD"))exception=true;
                if(inpArray[j].equals("EVEN")&&inpArray[i].equals("ODD"))exception=true;
                if(inpArray[i].equals("SPY")&&inpArray[j].equals("SQUARE"))exception=true;
                if(inpArray[j].equals("SPY")&&inpArray[i].equals("SQUARE"))exception=true;
                if(inpArray[i].equals("DUCK")&&inpArray[j].equals("SPY"))exception=true;
                if(inpArray[j].equals("DUCK")&&inpArray[i].equals("SPY"))exception=true;
                if(inpArray[i].equals("SUNNY")&&inpArray[j].equals("SQUARE"))exception=true;
                if(inpArray[j].equals("SUNNY")&&inpArray[i].equals("SQUARE"))exception=true;
                if(inpArray[j].equals("SUNNY")&&inpArray[i].equals("SPY"))exception=true;
                if(inpArray[i].equals("SUNNY")&&inpArray[j].equals("SPY"))exception=true;
            }
        }
        return exception;
    }
    protected static boolean general(String [] inpArray,String property,String secProperty,String[] arrayProperty,
                                     int arLen,String thirdProperty,String fourthProperty,String fifthProperty){
        boolean exception=false;
        if(arLen>=3)property=Exceptions.negative(property);
        if(arLen>=4)secProperty=Exceptions.negative(secProperty);
        if(arLen>=5)thirdProperty=Exceptions.negative(thirdProperty);
        if(arLen>=6)fourthProperty=Exceptions.negative(fourthProperty);
        if(arLen>=7)fifthProperty=Exceptions.negative(fifthProperty);
        if(Exceptions.firstException(inpArray)||arLen >= 2 && Exceptions.secondException(inpArray))exception=true;
        if(arLen >= 2 && Exceptions.secondException(inpArray))exception=true;
        if(arLen >= 3 && Exceptions.excWithPar(arrayProperty,property))exception=true;
        if(arLen >= 4 && Exceptions.excWithPar(arrayProperty,secProperty))exception=true;
        if(arLen >= 5 && Exceptions.excWithPar(arrayProperty,thirdProperty))exception=true;
        if(arLen >= 6 && Exceptions.excWithPar(arrayProperty,fourthProperty))exception=true;
        if(arLen >= 7 && Exceptions.excWithPar(arrayProperty,fifthProperty))exception=true;
        if(arLen >= 4 && Exceptions.mutuallyExc(inpArray,arLen))exception=true;
        return exception;
    }
}
