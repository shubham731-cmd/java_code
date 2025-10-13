class MyArray {
    int[] arr;
    int size = 0;


    MyArray() {
        arr = new int[5]; 
    }

    int get(int index){
        return arr[index];
    }

    void add(int element) {
        if (size == arr.length) {
          
            int[] newArr = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size] = element;
        size++;
    }

    int size() {
        return size;
    }
}

public class AddElements {
    public static void main(String[] args) {
        MyArray ar = new MyArray();  
        ar.add(10);
        ar.add(20);

        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));  
        }

        System.out.println(ar.size());
    }
}
