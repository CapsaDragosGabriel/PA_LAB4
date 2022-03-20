package citystructure;

public class Street implements Comparable<Street> {
   private String name;
   private int length;
   private Intersection pointA;
   private  Intersection pointB;

    public Street(String name, int length, Intersection pointA, Intersection pointB) {
        this.name = name;
        this.length = length;
        this.pointA = pointA;
        this.pointB = pointB;
    }
    public Street(){}

    public Intersection getPointA() {
        return pointA;
    }

    public void setPointA(Intersection pointA) {
        this.pointA = pointA;
    }

    public Intersection getPointB() {
        return pointB;
    }

    public void setPointB(Intersection pointB) {
        this.pointB = pointB;
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
        return "citystructure.Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                "}\n";
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
