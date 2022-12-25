package numbers;
public class Conditions {
    public static boolean Condition(String[] arrayProperty, String property, boolean condition, long inputIntegers,
                                    String toStringIntegers, int len) {
        property=Exceptions.negative(property);
        if (property.equals(arrayProperty[0])) condition = Property.even(inputIntegers);
        if (property.equals(arrayProperty[1])) condition = Property.odd(inputIntegers);
        if (property.equals(arrayProperty[2])) condition = Property.buzz(inputIntegers, toStringIntegers, len);
        if (property.equals(arrayProperty[3])) condition = Property.duck(toStringIntegers, len);
        if (property.equals(arrayProperty[4])) condition = Property.palindromic(toStringIntegers, len);
        if (property.equals(arrayProperty[5])) condition = Property.gapful(len, toStringIntegers, inputIntegers);
        if (property.equals(arrayProperty[6])) condition = Property.spy(toStringIntegers, len);
        if (property.equals(arrayProperty[7])) condition = Property.square(inputIntegers);
        if (property.equals(arrayProperty[8])) condition = Property.sunny(inputIntegers);
        if (property.equals(arrayProperty[9])) condition = Property.jumping(toStringIntegers, len);
        if (property.equals(arrayProperty[10])) condition = !Property.happy(inputIntegers);
        if (property.equals(arrayProperty[11])) condition = Property.happy(inputIntegers);
        return condition;
    }
}
