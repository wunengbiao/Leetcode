package Design;

import java.util.*;

/**
 * Created by wunengbiao on 2017/4/9.
 */
public class LFUCache {

    class Cache{
        int key;
        int value;
        int time_stamp;

        Cache(int key,int value,int time_stamp){
            this.key=key;
            this.value=value;
            this.time_stamp=time_stamp;
        }
        @Override
        public boolean equals(Object obj) {
            return this.key==((Cache)obj).key;
        }
    }

    int cur_time;
    int capacity;

    Map<Integer,Integer> values;
//    Map<Integer,Integer> time_stamp;

    Map<Integer,Integer> cache=new HashMap<>();
    PriorityQueue<Cache> heap;

    public LFUCache(int capacity) {
        this.cur_time=0;
        this.capacity=capacity;
        heap=new PriorityQueue<>(capacity, new Comparator<Cache>() {
            @Override
            public int compare(Cache o1, Cache o2) {
                return o1.time_stamp-o2.time_stamp;
            }
        });
        values=new HashMap<>();
//        time_stamp=new HashMap<>();
    }

    public int get(int key) {
        cur_time++;
        if(values.containsKey(key)){
//            time_stamp.put(key,cur_time);
            Cache cache=new Cache(key,values.get(key),cur_time);
            heap.remove(cache);
            heap.add(cache);
            return values.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        cur_time++;
        if(values.containsKey(key)){
            values.put(key,value);
//            time_stamp.put(key,cur_time);
            Cache cache=new Cache(key,value,cur_time);
            heap.remove(cache);
            heap.add(cache);
        }else{
            if(heap.size()<capacity){
                values.put(key,value);
//                time_stamp.put(key,cur_time);
                heap.add(new Cache(key,value,cur_time));
            }else{
                Cache cache=heap.poll();
                values.remove(cache.key);
//                time_stamp.remove(cache.key);
//                time_stamp.remove(cache.time_stamp);
                values.put(key,value);

//                time_stamp.put(key,cur_time);
                heap.add(new Cache(key,value,cur_time));
            }
        }
    }

    public static void main(String[] args){
        LFUCache cache=new LFUCache(2);
//        cache.set(1,1);
//        cache.set(2,2);
//        System.out.println(cache.get(1));
//        cache.set(3,3);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//        cache.set(4,4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
        cache.put(0,0);
        System.out.println(cache.get(0));
    }
}
