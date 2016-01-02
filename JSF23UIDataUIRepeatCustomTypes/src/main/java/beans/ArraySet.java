package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<T> implements Cloneable, Serializable {

    private ArrayList list;

    public ArraySet() {
        list = new ArrayList();
    }

    public ArraySet(Collection collection) {
        list = new ArrayList();

        Iterator iterator = collection.iterator();
        if (collection instanceof Set) {
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        } else {
            while (iterator.hasNext()) {
                add(iterator.next());
            }
        }
    }

    public Iterator iterator() {
        return list.iterator();
    }

    public int size() {
        return list.size();
    }

    public final boolean add(Object element) {
        boolean modified;
        if (modified = !list.contains(element)) {
            list.add(element);
        }
        return modified;
    }

    public boolean remove(Object element) {
        return list.remove(element);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object element) {
        return list.contains(element);
    }

    public void clear() {
        list.clear();
    }

    public Object get(int index) {
        return list.get(index);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            ArraySet newSet = (ArraySet) super.clone();
            newSet.list = (ArrayList) list.clone();
            return newSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
