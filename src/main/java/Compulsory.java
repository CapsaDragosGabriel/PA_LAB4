import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Compulsory{
    public static void main(String[] args) {
        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);
    for( int i=0;i<nodes.length;i++)
    System.out.println(nodes[i]);

    List<Street> streetList=new LinkedList<>();
    Street str1=new Street("s1",4);
    Street str2=new Street("s2",7);
    Street str3=new Street("s3",5);
    streetList.add(0,str1);
    streetList.add(1,str2);
    streetList.add(2,str3);
    streetList.sort(Street::compareTo);
        System.out.println(streetList);
   // streetList.add(0,str1);

    }
    }
