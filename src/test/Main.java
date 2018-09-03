import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * All index start from 0;
 * -1 when getting input
 * use crates
 * 
 * 
 * @author reobj_
 *
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);
        
//        height = consoleIn.nextInt();
//        width = consoleIn.nextInt();
//        Plane2D<Character> map = new Plane2D<Character>(width, height);
//        
//        for(int y = 0; y < height; y++) {
//            String input = consoleIn.next();
//            
//            for(int x = 0; x < width; x++) {
//                map.set(x, y, input.charAt(x));
//            }
//        }
        
        int length = consoleIn.nextInt();
        Plane2D<Point>map = new Plane2D<Point>(length, length);
        List<EnumSide> path = new ArrayList<EnumSide>(length * length);
        gcdHistory = new HashMap< Pair<Integer, Integer>, Integer >();
        
        for(int y = 0; y < length; y++) {
            for(int x = 0; x < length; x++) {
                map.set(x, y, new Point(x, y, consoleIn.nextInt()) );
            }
        }
        
        Queue< Pair<Integer, Integer> > process = new LinkedList< Pair<Integer, Integer> >();
        process.add( Pair.of(0, 0) );
        map.get(0, 0).isMarked = true;;
        
        while(!process.isEmpty()) {
            int x = process.peek().getLeft();
            int y = process.peek().getRight();
            int current = map.get(x, y).n;
            process.remove();
            
            if(x == length-1 && y == length-1) {
                int ix = x;
                int iy = y;
                while(ix > 0 || iy > 0) {
                    EnumSide d = map.get(ix, iy).parentFromSide;
                    path.add( map.get(ix, iy).parentCameFrom );
                    ix += d.offsetX;
                    iy += d.offsetY;
                }
                
                Collections.reverse(path);
                for(EnumSide s : path) {
                    System.out.println(s.initial == 'R' ? 'L' :
                                       s.initial == 'L' ? 'R' : s.initial);
                }
                
//                System.out.println("done");
                break;
            }
            
            for(EnumSide direction : EnumSide.side4Sides) {
                int dx = x + direction.offsetX;
                int dy = y + direction.offsetY;
                
                // Bound check
                if(!map.isXInBound(dx) || !map.isYInBound(dy)) {
                    continue;
                }
                
                Point child = map.get(dx, dy);
                
                // The place is already visited
                if(child.n < 0) {
                    continue;
                }
                
                if( gcd(current, child.n ) == 1 ) {
                    child.isMarked = true;
                    child.parentX = x;
                    child.parentY = y;
                    child.parentCameFrom = direction;
                    child.parentFromSide = EnumSide.getOppoiste(direction);
                    process.add( Pair.of(dx, dy) );
                    
                    System.out.println(direction.initial + "  " + dx + ", " + dy);
                }
            }
        }
        
        consoleIn.close();
    }
    
//    private static final int[] DX = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};
//    private static final int[] DY = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
//    private static final int[] DX = new int[] {0, 1, 0, -1};
//    private static final int[] DY = new int[] {-1, 0, 1, 0};
    
    
    private static Map< Pair<Integer, Integer>, Integer > gcdHistory;
    
    private static int gcd(int a, int b) {
        if(a == 0 || b == 0) {
            return 0;
        }
        
        if(Math.abs(a - b) == 1) 
            return 1;
        if(a == b)
            return a;
        
        Pair<Integer, Integer> p = Pair.of(a, b);
        if(gcdHistory.containsKey(p)) {
            return gcdHistory.get(p);
        }
        
        int n = Math.abs(a);
        int m = Math.abs(b);
        
        while(n != m) {
            if(n > m) {
                n -= m;
            } else {
                m -= n;
            }
        }
        
        gcdHistory.put( Pair.of(a, b), n);
        
        return n;
    }
    
}




class Point {
    
    int x;
    int y;
    int n;
    int parentX;
    int parentY;
    EnumSide parentFromSide;
    EnumSide parentCameFrom;
    boolean isMarked;
    
    public Point(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }
    
    @Override
    public String toString() {
        if(this.parentCameFrom == null) return "none";
        
        return this.parentCameFrom.toString();
    }
    
}





class Pair<L,R> {
    
    private final L left;
    private final R right;

    public static <L,R> Pair<L,R> of(L left, R right) {
        return new Pair<L,R>(left, right);
    }

    private Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return this.left; }
    public R getRight() { return this.right; }

    @Override
    public int hashCode() { return this.left.hashCode() ^ this.right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        
        Pair<?,?> pairo = (Pair<?,?>) o;
        return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
    }
    
    @Override
    public String toString() {
        return "(" + this.left + ", " + this.right + ")";
    }
    
}

class Plane2D<T> {
    
    private T[][] plane;
    
    private int width;
    private int height;
    
    /**
     * Create a empty Plane2D object with specified width and height
     * 
     * @param width The specified width of plane
     * @param height the specified height of plane
     */
    @SuppressWarnings("unchecked")
    public Plane2D(int width, int height) {
        this( (T[][]) new Object[height][width], width, height);
    }
    
    /**
     * Create a Plane2D object with an existing 2d array
     * This constructor assumes all the array in the parameter have the same length
     * 
     * @param plane The existing 2d array
     */
    public Plane2D(T[][] plane) {
        this(plane, plane[0].length, plane.length);
    }
    
    /**
     * Internal base construct without size check
     */
    private Plane2D(T[][] plane, int width, int height) {
        this.plane = plane;
        this.width = width;
        this.height = height;
    }
    
    
    
    public int size() {
        return this.width * this.height;
    }
    
    public int width() { return this.width; }
    public int height() { return this.height; }
    
    
    public T get(int x, int y) {
        boundaryCheck(x, y);
        
        return plane[y][x];
    }
    
    /**
     * Replace the value at (x, y) with a value, return
     * the old value in the slot.
     * 
     * @param value Replacement value
     * @return The old value at (x, y)
     */
    public T set(int x, int y, T value) {
        boundaryCheck(x, y);
        
        T oldVal = this.plane[y][x];
        this.plane[y][x] = value;
        
        return oldVal;
    }
    
    /**
     * Replace the value only if the predicate returns true.
     * Will return the old value in (x, y)
     * 
     * @param value Replacement value
     * @param condition Filter condition
     * @return The old value at (x, y)
     */
    public T set(int x, int y, T value, IComparePrediacte<T, T> condition) {
        boundaryCheck(x, y);
        
        if(condition.accpet(this.plane[y][x], value)) {
            return this.set(x, y, value);
        }
        return this.get(x, y);
    }
    
    /**
     * Fill the whole plane with the new value
     * 
     * @param v Replacement value
     */
    public void fillWith(T v) {
        for(int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.height; j++) {
                this.plane[j][i] = v;
            }
        }
    }
    
    /**
     * Update every value in the plane with the given expression.
     * 
     * @param lambd Expression which receive the old value, output the new value
     */
    public void map(IFunction<T, T> lambd) {
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                this.plane[y][x] = lambd.accept( this.plane[y][x] );
            }
        }
    }
    
    /**
     * Leave only element that matches the condition get kepted, rest
     * got thrown away (become null)
     * 
     * @param lambd Expression gives the value should be kept or not
     */
    public void filter(IPredicate<T> lambd) {
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                // If the lambda don't accepts the value
                if(!lambd.accept( this.plane[y][x] )) {
                    this.plane[y][x] = null;
                }
            }
        }
    }
    
    
    private void boundaryCheck(int x, int y) {
        if(!isInBound(x, y))
            throw new ArrayIndexOutOfBoundsException("Index out of bound"); 
    }
    
    
    public boolean isInBound(int x, int y) {
        if(!this.isXInBound(x) || !this.isYInBound(y)) {
            return false;
        }
        return true;
    }
    
    public boolean isXInBound(int x) {
        return !(x < 0 || x >= this.width);
    }
    public boolean isYInBound(int y) {
        return !(y < 0 || y >= this.height);
    }
    
    
    
    @Override
    public Plane2D<T> clone() {
        return new Plane2D<T>( Arrays.copyOf(this.plane, this.plane.length) );
    }
    
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(this.height * 2);
        
        for(int i = 0; i < this.height; i++) {
            out.append(Arrays.toString(this.plane[i]));
            out.append("\n");
        }
        
        return out.toString();
    }
    
}


enum EnumSide {
    
    RIGHT('R', "right", 1, 0),
    DOWN('D', "down", 0, 1),
    LEFT('L', "left", -1, 0),
    UP('U', "up", 0, -1);
    
    int offsetX;
    int offsetY;
    char initial;
    String fullName;
    
    private EnumSide(char initial, String name, int ox, int oy) {
        this.initial = initial;
        this.fullName = name;
        this.offsetX = ox;
        this.offsetY = oy;
    }
    
    public static EnumSide getOppoiste(EnumSide s) {
        switch(s) {
            case UP: return DOWN;
            case DOWN: return UP;
            case RIGHT: return LEFT;
            case LEFT: return RIGHT;
        }
        
        return EnumSide.values()[0];
    }
    
    
    @Override
    public String toString() {
        return this.fullName;
    }
    
    static EnumSide[] side4Sides = Arrays.copyOf(EnumSide.values(), 4);
    static EnumSide[] side8Sides = Arrays.copyOf(EnumSide.values(), 8);
    
}


interface IComparePrediacte<I1,I2> {
    
    boolean accpet(I1 oldVal, I2 newVal);
    
}

interface IFunction<I,R> {
    
    R accept(I in);
    
}

interface IPredicate<I> {
    
    boolean accept(I in);
    
}
