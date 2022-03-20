import citystructure.City;
import citystructure.Intersection;
import citystructure.Street;
import com.github.javafaker.Faker;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;

import java.util.*;

import java.util.stream.IntStream;

public class Compulsory{
    public static List<Street> initializeStreets(Set<Intersection> intersectionSet){
        List<Street> temp=new LinkedList<>();
        Iterator<Intersection> itr=intersectionSet.iterator();
        List<Intersection> listOfIntersections= new ArrayList<>(intersectionSet);
        int index=0;
        Faker faker= new Faker();
        Street str1=new Street(faker.address().streetAddress(),2,listOfIntersections.get(0),listOfIntersections.get(1));
        Street str2=new Street(faker.address().streetAddress(),2,listOfIntersections.get(0),listOfIntersections.get(2));
        Street str3=new Street(faker.address().streetAddress(),2,listOfIntersections.get(0),listOfIntersections.get(3));

        Street str4=new Street(faker.address().streetAddress(),2,listOfIntersections.get(1),listOfIntersections.get(2));
        Street str5=new Street(faker.address().streetAddress(),1,listOfIntersections.get(2),listOfIntersections.get(3));

        Street str6=new Street(faker.address().streetAddress(),3,listOfIntersections.get(1),listOfIntersections.get(4));
        Street str7=new Street(faker.address().streetAddress(),2,listOfIntersections.get(2),listOfIntersections.get(6));
        Street str8=new Street(faker.address().streetAddress(),2,listOfIntersections.get(2),listOfIntersections.get(5));
        Street str9=new Street(faker.address().streetAddress(),3,listOfIntersections.get(3),listOfIntersections.get(5));

        Street str10=new Street(faker.address().streetAddress(),1,listOfIntersections.get(4),listOfIntersections.get(5));


        Street str11=new Street(faker.address().streetAddress(),1,listOfIntersections.get(4),listOfIntersections.get(7));
        Street str12=new Street(faker.address().streetAddress(),2,listOfIntersections.get(4),listOfIntersections.get(8));

        Street str13=new Street(faker.address().streetAddress(),1,listOfIntersections.get(6),listOfIntersections.get(7));
        Street str14=new Street(faker.address().streetAddress(),1,listOfIntersections.get(6),listOfIntersections.get(8));
        Street str15=new Street(faker.address().streetAddress(),3,listOfIntersections.get(5),listOfIntersections.get(8));

        Street str16=new Street(faker.address().streetAddress(),1,listOfIntersections.get(7),listOfIntersections.get(8));


        temp.add(str1);
        temp.add(str2);
        temp.add(str3);
        temp.add(str4);
        temp.add(str5);
        temp.add(str6);
        temp.add(str7);
        temp.add(str8);
        temp.add(str9);
        temp.add(str10);
        temp.add(str11);
        temp.add(str12);
        temp.add(str13);
        temp.add(str14);
        temp.add(str15);
        temp.add(str16);

        temp.sort(Street::compareTo);


        return temp  ;
    }



    /*public static HashSet<citystructure.Intersection> initializeIntersections()
    {
        city.intersectionList = Arrays.stream(IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new citystructure.Intersection("v" + i))
                .toArray(citystructure.Intersection[]::new)).toList();
        for( int i=0;i<city.intersectionList.size();i++)
            System.out.println(city.intersectionList.get(i));

    }*/
    public static Set<Intersection>  initializeIntersectionsSet()
    {
        Faker faker=new Faker();
       var nodes=IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection(faker.name().fullName()))
               .toArray(Intersection[]::new);
        Set<Intersection> temp=new HashSet<>(List.of(nodes));
       // temp=Set.of(nodes);
       return temp;
    }

    public static void main(String[] args) {
    City<Intersection,Street> city=new City<>();
    city.setIntersectionSet(initializeIntersectionsSet());
    city.setStreetList(initializeStreets(city.getIntersectionSet()));

   city.getStreetList().sort(Comparator.comparing(Street::getLength));

        System.out.println(city);
        System.out.println();
        city.selectStreets(3);
        System.out.println();
      /*  KruskalMinimumSpanningTree kruskalMinimumSpanningTree= new KruskalMinimumSpanningTree(city);
         System.out.println(kruskalMinimumSpanningTree.getSpanningTree().getEdges());*/
        System.out.println("Prim:");
         PrimMinimumSpanningTree primMinimumSpanningTree=new PrimMinimumSpanningTree(city);
        System.out.println(primMinimumSpanningTree.getSpanningTree());
        System.out.println(primMinimumSpanningTree.getSpanningTree().getWeight());
        System.out.println();

        //System.out.println(city);

      //  System.out.println(city.getVecinityStreeets(city.streetList.get(0)));

   // streetList.add(0,str1);
    }
    }
