package study;

import java.util.regex.Pattern;

public class StringCalculator {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.stringCalculationLogic(initInputData());
    }

    private static String[] initInputData() {
        return "2 + 3 * 4 / 2".split(" ");
    }

    public void inputValidation(String[] values) {
        try {
            for(int i=0; i<values.length; i++){
                if(i%2 == 0){
                    isNumberType(values[i]);
                    continue;
                }
                isOperationType(values[i]);
            }
        }catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }
    }

    public boolean isNumberType(String value) {
        Pattern numberPattern = Pattern.compile("^\\d+$+");
        if(!numberPattern.matcher(value).find()){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isOperationType(String value) {
        Pattern operatorPattern = Pattern.compile("[+\\-*/]");
        if(!operatorPattern.matcher(value).find()){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int stringCalculation(String operationSymbol, int inputA, int inputB) {
        int result = 0;
        switch (operationSymbol){
            case "+" :
                result = inputA + inputB;
                break;
            case "-" :
                result = inputA - inputB;
                break;
            case "*" :
                result = inputA * inputB;
                break;
            case "/" :
                result = inputA / inputB;
                break;
        }
        return result;
    }

    int stringCalculationLogic(String[] values){

        inputValidation(values);

        int currentValue = Integer.parseInt(values[0]);
        for (int i = 0; i < values.length; i++) {
            //연산기호인지 확인
            if (isOperationType(values[i])) {
                currentValue = stringCalculation(values[i], currentValue, Integer.parseInt(values[i + 1]));
            }
        }
        return currentValue;
    }
}
