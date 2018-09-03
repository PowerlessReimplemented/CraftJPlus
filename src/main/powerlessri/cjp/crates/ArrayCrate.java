package powerlessri.cjp.crates;

import java.lang.reflect.Array;

public class ArrayCrate<T> {
    
    private final int capacity;
    
    T[] content;
    
    @SuppressWarnings("unchecked")
    public ArrayCrate(Class<T> c, int capacity) {
        this.capacity = capacity;
        this.content = (T[]) Array.newInstance(c, capacity);
    }
    
    public T at(int index) {
        return content[index];
    }
    
}
