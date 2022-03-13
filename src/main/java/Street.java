public class Street implements Comparable<Street> {
    String name;
    int length;

    public Street(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        length = length;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }

    @Override
    public int compareTo(Street o) {
        if (this.length<o.length)
        return -1;
        if (this.length==o.length)
            return 0;

            return 1;

    }
}
