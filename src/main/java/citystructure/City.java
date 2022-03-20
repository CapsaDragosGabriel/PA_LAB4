package citystructure;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;
import org.jgrapht.*;
public class City<V,E> implements Graph<V,E>  {
    List<Street> streetList=new LinkedList<>();
    Set<Intersection> intersectionSet=new HashSet<>();

    public City(List<Street> streetList, Set<Intersection> intersectionSet) {

        this.intersectionSet = intersectionSet;
        this.streetList = streetList;
    }
    public City(){}

    public List<Street> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<Street> streetList) {
        this.streetList = streetList;
    }

    public Set<Intersection> getIntersectionSet() {
        return intersectionSet;
    }

    public void setIntersectionSet(Set<Intersection> intersectionSet) {
        this.intersectionSet = intersectionSet;
    }

    /*public int getStreetsIntersection(citystructure.Intersection intersection)
    {
        int nrStreets=0;
        Iterator<citystructure.Intersection> itr =intersectionSet.iterator();
        for (citystructure.Street street : streetList)
        {
            if (street.getPointA()==intersection||street.getPointB()==intersection)
                nrStreets++;
        }

        return nrStreets;
    }*/
    public int getVecinityStreeets(Street street)
    {int nrStreets=0;
        for (Street str : streetList)
        {
            if (str.getPointA()==street.getPointA()||str.getPointA()==street.getPointB()||str.getPointB()==street.getPointA() ||str.getPointB()==street.getPointB())
                nrStreets++;
        }
        nrStreets-=1;//not  including the same street
        return nrStreets;
    }
    public void selectStreets(int minLength)
    {
                streetList.stream()
                        .filter(str->str.getLength()>=minLength && this.getVecinityStreeets(str)>=3)
                        .map(strname->strname.getName())
                        .forEach(System.out::println);

    }
    @Override
    public String toString() {
        return "citystructure.City{\n" +
                "streetList=\n" + streetList +
                "\n intersectionSet=" + intersectionSet +
                "\n}";
    }

    @Override
    public Set<E> getAllEdges(V v, V v1) {
        for (Street street:streetList)
        {
            if (street.getPointA().equals(v)&&street.getPointB().equals(v1)||
                    street.getPointB().equals(v)&&street.getPointA().equals(v1))
                return (Set<E>) Set.of(street);
        }
        return null;
    }

    @Override
    public E getEdge(V v, V v1) {
        for (Street street:streetList)
        {
            if (street.getPointA().equals(v)&&street.getPointB().equals(v1)||
                    street.getPointB().equals(v)&&street.getPointA().equals(v1))
                return (E) street;
        }
        return null;
    }

    @Override
    public Supplier<V> getVertexSupplier() {
        return null;
    }

    @Override
    public Supplier<E> getEdgeSupplier() {
        return null;
    }

    @Override
    public E addEdge(V v, V v1) {
        Street str=new Street();
        for (Intersection intersection:intersectionSet)
        {
            if (v.equals(intersection))
                str.setPointA(intersection);
            if(v1.equals(intersection))
                str.setPointB(intersection);
        }
        str.setLength(0);
        str.setName("");
        streetList.add(str);
        return (E) str;
    }

    @Override
    public boolean addEdge(V v, V v1, E e) {
        Faker faker=new Faker();

        for (Intersection intersection:intersectionSet)
        {
            if (v.equals(intersection))
                ((Street)e).setPointA(intersection);
            if(v1.equals(intersection))
                ((Street)e).setPointB(intersection);
        }


        streetList.add((Street)e);
        return false;
    }

    @Override
    public V addVertex() {
       Intersection v=new Intersection("");
        intersectionSet.add(v);
        return (V)v;

    }

    @Override
    public boolean addVertex(V v) {
        intersectionSet.add((Intersection) v);
        return true;
    }

    @Override
    public boolean containsEdge(V v, V v1) {
        for(Street street : streetList) {
            if (street.getPointA().equals(v) && street.getPointB().equals(v1) ||
                    street.getPointB().equals(v) && street.getPointA().equals(v1))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsEdge(E e) {
        for(Street street : streetList) {
            if (street.equals((Street)e))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsVertex(V v) {
        for (Intersection intersection : intersectionSet)
        {
            if (intersection.equals((Intersection) v))
                return true;
        }
        return false;
    }

    @Override
    public Set<E> edgeSet() {
        Set<Street> temp=new HashSet<>();
        for(Street street : streetList)
            temp.add(street);
        return (Set<E>) temp;
    }

    @Override
    public int degreeOf(V v) {
        int deg=0;
        for (Street street : streetList)
        {
            if (street.getPointA().equals((Intersection) v)||street.getPointB().equals((Intersection) v))
                deg++;

        }
        return deg;
    }

    @Override
    public Set<E> edgesOf(V v) {
        Set<E> incidentStreets=new HashSet<>();
        for (Street street : streetList)
        {
            if (street.getPointA().equals((Intersection) v)||street.getPointB().equals((Intersection) v))
                incidentStreets.add((E) street);
        }
        return incidentStreets;

    }

    @Override
    public int inDegreeOf(V v) {
        return degreeOf(v);
    }

    @Override
    public Set<E> incomingEdgesOf(V v) {
        return edgesOf(v);
    }

    @Override
    public int outDegreeOf(V v) {
        return degreeOf(v);
    }

    @Override
    public Set<E> outgoingEdgesOf(V v) {
        return edgesOf(v);
    }

    @Override
    public boolean removeAllEdges(Collection<? extends E> collection) {
        streetList.removeAll(collection);
        return true;
    }

    @Override
    public Set<E> removeAllEdges(V v, V v1) {
        Set<E> toRemove = new HashSet<>();
        for (Street street:streetList)
        {
            if (street.getPointA().equals((Intersection)v)&&street.getPointA().equals((Intersection)v1)||
                    street.getPointB().equals((Intersection)v)&&street.getPointA().equals((Intersection)v1))
                toRemove.add((E)street);
        }
        streetList.removeAll(toRemove);
        return toRemove;
    }

    @Override
    public boolean removeAllVertices(Collection<? extends V> collection) {
        intersectionSet.removeAll(collection);
        return true;
    }

    @Override
    public E removeEdge(V v, V v1) {
        Street toRemove=new Street();
        for (Street street:streetList)
        {
            if (street.getPointA().equals((Intersection) v)&&street.getPointA().equals((Intersection)v1)||
                    street.getPointB().equals((Intersection)v)&&street.getPointA().equals((Intersection)v1))
            {
                toRemove=street;
                break;
            }
        }
        streetList.remove(toRemove);
        return (E) toRemove;
    }

    @Override
    public boolean removeEdge(E e) {
        if (streetList.contains(e))
        {
            streetList.remove(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVertex(V v) {
        if (intersectionSet.contains(v))
        {
            intersectionSet.remove(v);
            return true;
        }
        return false;
    }

    @Override
    public Set<V> vertexSet() {
        return (Set<V>)intersectionSet;
    }

    @Override
    public V getEdgeSource(E e) {
        if (!streetList.contains(e))
           return null;
        int index=streetList.indexOf(e);
      return (V)streetList.get(index).getPointA();
    }

    @Override
    public V getEdgeTarget(E e) {
        if (!streetList.contains(e))
            return null;
        int index=streetList.indexOf(e);
        return (V)streetList.get(index).getPointB();
    }

    @Override
    public GraphType getType() {
        return null;
    }

    @Override
    public double getEdgeWeight(E e) {
        for(Street street : streetList)
        {
            if(e.equals(street))
                return street.getLength();
        }
        return 0;
    }

    @Override
    public void setEdgeWeight(E e, double v) {
    for (Street street : streetList)
     {
         if(e.equals(streetList))
             street.setLength((int) v);
     }
    }

    @Override
    public void setEdgeWeight(V sourceVertex, V targetVertex, double weight) {
      for (Street street : streetList)
      {
          if(street.getPointA().equals(sourceVertex)&&street.getPointA().equals(targetVertex)||
                  street.getPointB().equals(sourceVertex)&&street.getPointA().equals(targetVertex))
          {
              street.setLength((int) weight);
              break;
          }
      }

    }

    @Override
    public GraphIterables<V, E> iterables() {
        return Graph.super.iterables();
    }
}
