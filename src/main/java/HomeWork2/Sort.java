package HomeWork2;



public class Sort {
    public static void main(String[] args) {
        Laptop [] arr = createRandomArray(99);
        sortLaptops(arr);
    }

    public static Laptop[] createRandomArray (int arraySize){
        Laptop[] arr = new Laptop[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = new Laptop();
        }
        return arr;
    }

    public static void sortLaptops(Laptop[]arr){
        sortLaptopsByPrice(arr,0, arr.length-1);
        sortLaptopsByRam(arr,0);
        sortLaptopsByManufacturer(arr,0);
    }

    public static void sortLaptopsByPrice(Laptop[] arr, int leftBorder, int rightBorder) {  // Сортируем массив по цене с помощью быстрой сортировки
        int left = leftBorder;
        int right = rightBorder;
        int pivotInd = (left + right) / 2;
        do {
            while (arr[left].getPrice() < arr[pivotInd].getPrice()) {
                left++;
            }
            while (arr[right].getPrice() > arr[pivotInd].getPrice()) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    Laptop temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);
        if (left < rightBorder) {
            sortLaptopsByPrice(arr, left, arr.length - 1);
        }
        if (leftBorder < right) {
            sortLaptopsByPrice(arr, leftBorder, right);
        }
    }

    public static void sortLaptopsByRam(Laptop[] arr, int begin) {
        int pointer = begin;
        if (arr[pointer].getPrice() == arr[pointer + 1].getPrice()) {              // Проверяем есть ли оинаковые значение
            while (arr[pointer].getPrice() == arr[pointer + 1].getPrice()) {       // Определяем последнее одинаковое значение
                pointer++;
                if (pointer == arr.length-1){                                       // проверяем, что не вышли за пределы массива
                    break;
                }
            }
            Laptop[] tempArray = new Laptop[pointer + 1];                         // Создаем временный массив для сортировки
            for (int i = begin; i <= pointer; i++) {
                tempArray[i] = arr[i];
            }
            sortTempArrayByRAM(tempArray, begin, pointer);                        // сортируем временный массив
            for (int i = begin; i <= pointer; i++) {                              // перезаписываем отсортированные данне в исходный массив
                arr[i] = tempArray[i];
            }
        }
        begin = pointer + 1;                                                      // задаем начало следующего подмассива
        if (begin<arr.length-1){                                                  // проверяем, осталось ли что-нибудь для сортировки
            sortLaptopsByRam(arr,begin);                                          // вызываем сортировку заново
        }
    }

    public static void sortTempArrayByRAM(Laptop[] tempArray, int leftBorder, int rightBorder) {
        int left = leftBorder;
        int right = rightBorder;
        int pivotInd = (left + right) / 2;
        do {
            while (tempArray[left].getRam() < tempArray[pivotInd].getRam()) {
                left++;
            }
            while (tempArray[right].getRam() > tempArray[pivotInd].getRam()) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    Laptop temp = tempArray[left];
                    tempArray[left] = tempArray[right];
                    tempArray[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);
        if (left < rightBorder) {
            sortLaptopsByPrice(tempArray, left, tempArray.length - 1);
        }
        if (leftBorder < right) {
            sortLaptopsByPrice(tempArray, leftBorder, right);
        }
    }

    public static void sortLaptopsByManufacturer(Laptop[] arr, int begin) {
        int pointer = begin;
        if (arr[pointer].getRam() == arr[pointer + 1].getRam()) {                  // Проверяем есть ли одинаковые значение
            while (arr[pointer].getRam() == arr[pointer + 1].getRam()) {           // Определяем последнее одинаковое значение
                pointer++;
                if (pointer == arr.length-1){                                      // проверяем, что не вышли за пределы массива
                    break;
                }
            }
            Laptop[] tempArray = new Laptop[pointer + 1];                         // Создаем временный массив для сортировки
            for (int i = begin; i <= pointer; i++) {
                tempArray[i] = arr[i];
            }
            sortTempArrayByManufacturer(tempArray, begin, pointer);               // сортируем временный массив
            for (int i = begin; i <= pointer; i++) {                              // перезаписываем отсортированные данные в исходный массив
                arr[i] = tempArray[i];
            }
        }
        begin = pointer + 1;                                                      // задаем начало следующего под-массива
        if (begin<arr.length-1){                                                  // проверяем, осталось ли что-нибудь для сортировки
            sortLaptopsByManufacturer(arr,begin);                                 // вызываем сортировку заново
        }

    }

    public static void sortTempArrayByManufacturer(Laptop[] tempArray, int leftBorder, int rightBorder) {
        int left = leftBorder;
        int right = rightBorder;
        int pivotInd = (left + right) / 2;
        do {
            while (tempArray[left].getManufacturer().ordinal() < tempArray[pivotInd].getManufacturer().ordinal()) {
                left++;
            }
            while (tempArray[right].getManufacturer().ordinal() > tempArray[pivotInd].getManufacturer().ordinal()) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    Laptop temp = tempArray[left];
                    tempArray[left] = tempArray[right];
                    tempArray[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);
        if (left < rightBorder) {
            sortLaptopsByPrice(tempArray, left, tempArray.length - 1);
        }
        if (leftBorder < right) {
            sortLaptopsByPrice(tempArray, leftBorder, right);
        }
    }
}

