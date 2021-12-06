package HomeWork3;


public class Homework3 {

    public static void main(String[] args) {
        // Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
        // Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.

        System.out.println(checkArray(generateArray(100000000)));

    }

    public static int[] generateArray (int size){
        int[] array = new int[size];
        int randomI = (int) (Math.random()*(size-1));
        for (int i = 0; i <size; i++) {
            if (i<randomI){
                array[i] = i+1;
            }
            if (i>=randomI) {
                array[i] = i+2;
            }
        }
        return array;
    }

    public static int checkArray (int [] array){
        if (array[0] != 1) return 1;
        if (array[array.length-2]== array.length-1) return array.length;
        int start = 1;
        int end = array.length-2;
        while (end >= start){
            int pivot = (start+end)/2;
            if (array[pivot]-pivot == 1){
                start = pivot+1;
            }else end = pivot-1;
        }
        return start+1;
    }
}
