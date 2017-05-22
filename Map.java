import java.util.*;

public class Map<K, V>
{
    public  ArrayList<hashData<K, V>> bucketArray;

    public static int numBuckets;

    public static int size;

    public Map()
    {
        bucketArray = new ArrayList<>();
        numBuckets = 10;

        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }


    public int getIndex(K key)
    {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        return index;
    }

    public V get(K key)
    {

        int bucketIndex = getIndex(key);
        hashData<K, V> head = bucketArray.get(bucketIndex);


        if (head != null)
        {
            if (head.key.equals(key))
                return head.value;
        }
        return null;
    }

    public  void add(K key, V value)
    {
        int bucketIndex = getIndex(key);
        hashData<K, V> head = bucketArray.get(bucketIndex);

        if (head != null)
        {
            head.value = value;
        }
        hashData<K, V> newNode = new hashData<K, V>(key, value);
        bucketArray.set(bucketIndex, newNode);
    }

    public static void main(String[] args)
    {
        Map<String, Integer>map = new Map<String,Integer>();
        map.add("maulik",1 );
        map.add("mohib",2 );
        map.add("movie",9 );

        System.out.println(map.get("maulik"));

    }
}
class hashData<K, V>
{
    K key;
    V value;
    public hashData(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}
