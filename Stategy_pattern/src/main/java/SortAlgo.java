public interface SortAlgo {
    public void sort (NumList numList);
}

class BubbleSort implements SortAlgo {
    public void sort(NumList numList) {
        double[] arr = numList.getNumList();
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}

class QuickSort implements SortAlgo {
    public void sort(NumList numList) {
        double[] arr = numList.getNumList();
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        double temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

class NumList {
    private SortAlgo sortAlgorithm;
    private double [] listOfNumber;

    public NumList(SortAlgo sortAlgorithm, double[] listOfNumber) {
        this.sortAlgorithm = sortAlgorithm;
        this.listOfNumber = listOfNumber;
    }

    public void add(double number) {
        double[] newList = new double[listOfNumber.length + 1];
        for (int i = 0; i < listOfNumber.length; i++) {
            newList[i] = listOfNumber[i];
        }
        newList[listOfNumber.length] = number;
        listOfNumber = newList;
    }
    public double[] getNumList() {
        return listOfNumber;
    }
    public void setBubbleSort() {
        sortAlgorithm = new BubbleSort();
    }

    public void setQuickSort() {
        sortAlgorithm = new QuickSort();
    }
    public void setOrder() {
        sortAlgorithm.sort(this);
    }
}

