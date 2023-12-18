package users.javersExample;

import java.util.*;

public class tobeDeleted {

    public static void main(String[] args) {
//        int[] numbers = {4,3,1};
//
//        Arrays.sort(numbers);
//
//        for (int ele : sortArr(numbers)){
//            System.out.println(ele);
//        }
//        List<Integer> ids = new ArrayList<>(Arrays.asList(2,7,5,3,1,45));
//        Collections.sort(ids);
//        for (int ele : ids){
//            System.out.println(ele);
//        }
        System.out.println(reverse("Hello world!"));
        reverseArr(new String[]{"Foden", "ThanhVinh", "QAAutomation"});
        int[] test = new int[]{3,4,2};
    }

    public static int[] sortArr(int[] numbers){
        for (int i = 0; i < numbers.length - 1; i++){
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        return numbers;
    }

    public static String reverse(String str){
        String outputStr = "";
        for (int i = 0; i < str.length(); i++){
            outputStr += str.charAt(str.length() - i - 1);
        }
        return outputStr;
    }

    public static String[] reverseArr(String[] strArr){
        for (int i = 0; i < strArr.length/2; i++) {
            String temp = strArr[i];
            strArr[i] = strArr[strArr.length - i - 1];
            strArr[strArr.length - i - 1] = temp;
        }
        return strArr;
    }

    public static <T> void reverseArr(List<T> arrList){
        for (int i = 0; i < arrList.size()/2; i++){

        }
    }
}
