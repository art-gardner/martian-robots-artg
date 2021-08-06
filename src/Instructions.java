import java.util.Iterator;

class Instructions implements Iterator<Character> {

    private final String str;
    private int pos = 0;

    public Instructions(String str) {
        this.str = str;
    }

    public boolean hasNext() {
        return pos < str.length();
    }

    public Character next() {
        return str.charAt(pos++);
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}