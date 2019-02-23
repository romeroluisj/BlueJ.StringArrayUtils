import java.util.Arrays;
import java.lang.StringBuilder;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean found = false;
        
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(value)) {
                found = true;
                break;
            }
        }
        
        return found;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reverseArray = new String[array.length];
        int num = 0;
        
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[num] = array[i];
            num++;
        }
        
        return reverseArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        boolean isPalindromic = true;
        
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            if (array[left].equals(array[right])) {
                left++;
                right--;
            } else {
                isPalindromic = false;
                break;
            }
        }
       
        return isPalindromic;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String arrayAsOneStringInLowerCase = String.join("", array).toLowerCase();
        String[] arrayWithEachCharAsAnElement = arrayAsOneStringInLowerCase.split("");
        //System.out.println(Arrays.toString(arrayWithEachCharAsAnElement));
        
        String valueToRemove = " ";
        String[] arrayOfOnlyLettersNoSpaces = removeValue(arrayWithEachCharAsAnElement, valueToRemove);
        //System.out.println(Arrays.toString(arrayOfOnlyLettersNoSpaces));
        
        // need to sort array in order to be able to remove consecutive duplicates
        // in the next method
        Arrays.sort(arrayOfOnlyLettersNoSpaces);
        //System.out.println(Arrays.toString(arrayOfOnlyLettersNoSpaces));
        
        // the English alphabet contains 26 letters
        String[] finalArrayShouldHaveLengthOf26 = removeConsecutiveDuplicates(arrayOfOnlyLettersNoSpaces);
        //System.out.println(Arrays.toString(finalArrayShouldHaveLengthOf26));
        
        return (finalArrayShouldHaveLengthOf26.length == 26);
        
        /* This code works, but I don't have to actually provide the whole alphabet
         * 
        boolean isPangramic = true;
        String arrayAsStringJoinedLowerCase = String.join("", array).toLowerCase();
        String[] eachCharArray = arrayAsStringJoinedLowerCase.split("");
        
        String[] alphabetArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                                  "n","o","p","q","r","s","t","u","v","w","x","y","z"};

        for (int i = 0; i < alphabetArray.length; i++) {
            if (!contains(eachCharArray, alphabetArray[i])) {
                isPangramic = false;
                break;
            }
        }

        return isPangramic;
        */
       
       
        /* This code works, but it's longer than necessary
         * 
        // keep count with a number
        int count = 0;
        for (int i = 0; i < alphabetArray.length; i++) {
            if (contains(eachCharArray, alphabetArray[i])) {
                count++;
            } else {
                isPangramic = false;
                break;
            }
        }
        
        // if count = 26, return true
        // else return false
        if (count == 26) {
            isPangramic = true;
        }
        
        return isPangramic;
        */
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int numberOfOccurrences = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                numberOfOccurrences++;
            }
        }
        
        return numberOfOccurrences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int numberOfOccurrencesOfValueToRemove = getNumberOfOccurrences(array, valueToRemove);
        String[] newArray = new String[array.length - numberOfOccurrencesOfValueToRemove];
        
        // loop through array
        // if array[i].equals(valueToRemove), do not add to newArray
        
        // valueToRemove: e
        // array[i]:     a b e d c
        // newArray[j]:  a b d c
        
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                newArray[j] = array[i];
                j++;
            }
        }
        
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        /*
         * String[] array = {"aba", "aba", "baa", "bab", "bba", "bba", "bba", "bba", "bbb", "bbb"};
         * String[] expected = {"aba", "baa", "bab", "bba", "bbb"};
         */
        
        String valueToRemove = ",";
        StringBuilder sb = new StringBuilder();
        
        sb.append(array[0]);
        for (int i = 0; i < array.length - 1; i++) {
            if (!array[i].equals(array[i + 1])) {
                sb.append(valueToRemove);
                sb.append(array[i + 1]);
            }
        }
        
        String[] finalArray = sb.toString().split(valueToRemove);
        return finalArray;
        
        /* The code below works
         * but it's better to avoid nested for loops
        // array[i]
        // expected[j]
        String valueToRemove = "";
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = valueToRemove;
                } else {
                    i = j - 1;
                    j = array.length;
                }
            }
        }
       
        String[] finalArray = removeValue(array, valueToRemove);
        */
        // System.out.println(Arrays.toString(finalArray));
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) { 
        /*
         * String[] array = {"a", "a", "a", "b", "c", "c", "a", "a", "d"};
         * String[] expected = {"aaa", "b", "cc", "aa", "d"};

         * String[] array = {"t", "t", "q", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e"};
         * String[] expected = {"tt", "q", "aaa", "b", "cc", "aa", "d", "eee"};
         */
        
        String valueToRemove = ",";
        StringBuilder sb = new StringBuilder();
        
        // simple solution
        sb.append(array[0]);
        for (int i = 0; i < array.length - 1; i++) {
            if (!array[i].equals(array[i + 1])) {
                sb.append(valueToRemove);
            }
            sb.append(array[i + 1]);
        }
        
        String[] finalArray = sb.toString().split(valueToRemove);
        
        return finalArray;
        
        /*
         * The code below works
         * but it's too difficult to grasp
         * (too many reassignments from string to string)
        String valueToRemove = "";
        String temp = "";
        
        for (int i = 0; i < array.length - 1; i++) {
            temp = array[i];
            
            for (int j = i + 1; j < array.length; j++) {
                if (temp.equals(array[j])) {
                    array[i] = array[i].concat(array[j]);
                    temp = array[j];
                    array[j] = valueToRemove;
                } else {
                    i = j - 1;
                    j = array.length;
                }
            }
        }
        
        String[] finalArray = removeValue(array, valueToRemove);
        System.out.println(Arrays.toString(finalArray));
        return finalArray;
        */
    }


}
