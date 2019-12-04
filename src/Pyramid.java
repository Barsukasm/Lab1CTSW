import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Pyramid <T>{
    private Object[] values;
    private int[] emptyIndexes;

    Pyramid(){
        this.values = new Object[10];
        this.emptyIndexes = new int[10];
        Arrays.fill(emptyIndexes,0);
    }

    public void grow(){
        this.values = Arrays.copyOf(this.values, this.values.length*2);
    }
    public void insert(T elem){

    }

    public T get(int index){
        T item = null;
        return item;
    }

    public int size(){ return this.values.length; }

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
