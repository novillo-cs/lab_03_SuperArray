public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
        this.data = new String[10];
    }

    public SuperArray(int initialCapacity){
        this.data = new String[initialCapacity];
    }

    public int size(){
        return size;
    }



    public boolean add (String input){
        int initialCapacity = data.length;
        if (size() < initialCapacity){
            set(size(), input);
            size += 1;
            return true;
        }
        else{
            resize();
            set(size(), input);
            size += 1;
            return true;
        }
    }

    public String toString(){
        String finalString = "[";
        for (int i = 0; i < size; i++){
            if (i != size-1){
                finalString += data[i];
                finalString += ", ";
            }
            else {
                finalString += data[i];
            }
        }
        finalString += "]";
        return finalString;
    }

    public String get(int index){
        if (index < 0 || index >= size()){
            System.out.print("index error: ");
            return null;
        }
        else {
            return data[index];
        }
    }

    public String set(int index, String newValue){
        if (index < 0 || index >= data.length){
            System.out.print("index error: ");
            return null;
        }
        else{
            if (index > size()){
                size += 1;
            }
            String tempData = data[index];
            data[index] = newValue;
            return tempData;
        }
    }
    

    public String remove(int index){
        if (index < 0 || index >= size()){
            System.out.print("index error: ");
            return null;
        }
        else{
            for (int i = index; i < size()-1; i++){
                data[i] = data[i+1];
            }
        }
        size -= 1;
        return data[index];
    }

    public boolean remove(String target){
        int targetIndex = -1;
        for (int i = 0; i < size(); i++){
            if (data[i].equals(target)){
                targetIndex = i;
                break;
            }
        }
        if (targetIndex == -1){
            return false;
        }
        else{
            for (int i = targetIndex; i < size(); i++){
                data[i] = data[i+1];
            }
            size -= 1;
            return true;
        }
    }


    public void resize(){
        int newLength = (data.length * 2) + 1;
        String[] newArray = new String[newLength];
        for (int i = 0; i < size; i++){
            newArray[i] = data[i];
        }
        data = newArray;
    }

    public int indexOf(String target){
        for (int i = 0; i < size(); i++){
            if (data[i].equals(target)){
                return i;
            }
        }
            return -1;
        }

    public int lastIndexOf(String target){
        int largestIndex = -1;
        for (int i = 0; i < size(); i++){
            if (data[i].equals(target)){
                largestIndex = i;
            }
        }
        return largestIndex;
    }

    public void add(int index, String value){
        if (index < 0 || index > size){
            System.out.println("index error");
            return;
        }
        if (size == data.length){
            resize();
        }
        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }
}
