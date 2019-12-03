import java.util.ArrayList;
import java.util.Iterator;

public class Pyramid <T> {
    private ArrayList<T> values;
    private ArrayList<Integer> emptyInd;

    Pyramid(){
        emptyInd = new ArrayList<>();
        values = new ArrayList<>();
    }

    public void insert(T elem){}

    public T findByIndex(int index){
        T item = null;
        return item;
    }

    public void removeByIndex(int index){}

    public class PyramidIterator implements Iterator{

        public T next(){
            T item = null;
            return item;
        }

        public boolean hasNext(){
            return true;
        }

        public void forEach(){

        }
    }
}
