import java.util.HashMap;
import java.util.Set;

public class MapTest{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Banana", "The split");
        trackList.put("Strawberry", "On the top");
        trackList.put("Taco", "Meat and the cheese and the salsa");
        trackList.put("Flan", "Yummy yum yum in my tummy tum tum");

        System.out.println(trackList.get("Flan"));

        Set<String> keys = trackList.keySet();
        for(String key : keys){
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}