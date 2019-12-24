import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class List <T extends Comparable> {
    private Elem head = null;
    private Elem tail = null;
    private int length = 0;

    private class Elem{
        Elem next = null;
        T data;

        Elem(){}

        Elem(T d){
            data = d;
        }
    }

    List(){}

    List(List<T> list){
        Elem cur = list.head;
        for (int i = 0; i < list.length; ++i, cur = cur.next){
            pushBack(cur.data);
        }
    }

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public int length(){
        return length;
    }

    private Elem getElemByIndex(int ind){
        Elem cur = head;
        while (ind-- != 0){
            cur = cur.next;
        }
        return cur;
    }

    public boolean pushFront(T elem){
        Elem element = new Elem(elem);
        ++length;
        if (isEmpty()){
            head = tail = element;
            return true;
        }
        element.next = head;
        head = element;
        return true;
    }

    public boolean pushBack(T elem){
        Elem element = new Elem(elem);
        ++length;
        if(isEmpty()){
            head = tail = element;
            return true;
        }
        tail.next = element;
        tail = element;
        return true;
    }

    public T getValueByIndex(int ind){
        if(ind >= length || ind < 0) throw new IndexOutOfBoundsException();
        Elem cur = getElemByIndex(ind);
        return cur.data;
    }

    public T remove(int ind){
        if(ind >= length || ind < 0) throw new IndexOutOfBoundsException();
        Elem cur = getElemByIndex(ind);
        Elem prev = getElemByIndex(ind-1);
        prev.next = prev.next.next;
        cur.next = null;
        --length;
        return cur.data;
    }

    public boolean insert(T el, int ind){
        if(ind > length || ind < 0) throw new IndexOutOfBoundsException();
        Elem elem = new Elem(el);
        ++length;
        if (isEmpty()){
            head = elem;
            return true;
        }

        Elem prev = getElemByIndex(ind - 1);
        elem.next = prev.next;
        prev.next = elem;
        if (ind == 0){
            head = elem;
        }
        return true;
    }

    public T popBack(){
        if(isEmpty()) throw new NoSuchElementException();
        Elem ret = head;
        head = head.next;
        ret.next = null;
        --length;
        return ret.data;
    }

    public T popFront(){
        if(isEmpty()) throw new NoSuchElementException();
        Elem ret = tail;
        tail = getElemByIndex(length - 1);
        tail.next = null;
        --length;
        return ret.data;
    }

    public void forEach(Consumer<T> action){
        Elem cur =  head;
        for (int i = 0; i < length; i++){
            action.accept(cur.data);
            cur = cur.next;
        }
    }

    private void swap(Elem el1, Elem el2){
        T data = el1.data;
        el1.data = el2.data;
        el2.data = data;
    }

    public void sort(Comparator<T> comparator){
        if (isEmpty()) return;

        boolean flag = true;

        while (flag){
            Elem cur = head;
            flag = false;

            while (cur != tail){
                if (comparator.compare(cur.data, cur.next.data) > 0){
                    swap(cur, cur.next);
                    flag = true;
                }
                cur = cur.next;
            }
        }
    }
}
