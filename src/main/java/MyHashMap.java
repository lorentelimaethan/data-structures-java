import java.util.LinkedList;

public class MyHashMap<K,V>{
       
       static class Entity<K, V> {
           private K key;
           private V value;
           
           public Entity(K key, V value){
               this.key = key; 
               this.value = value; 
           }
           
           public V getValue() {
               return value;
           }
           
           public K getKey(){
               return key; 
           }
       }
       
   
       private LinkedList<Entity<K,V>>[] entities = new LinkedList[15];
       
       public void put(K key, V value){ 
           int index = getIndex(key);
                       
           if(entities[index] == null){
               entities[index] = new LinkedList<>();
               entities[index].add(new Entity<>(key, value)); 
               return;
           }
           
           if(get(key) == null) {
               entities[index].add(new Entity<>(key, value));
           } else {
               System.out.println("Key " + key + " already exist");
           }
       }
       
       public V get(K key){
           int index = getIndex(key); 
           
           if (entities[index] != null) {
               for(Entity<K,V> e : entities[index]) {
                   if(e.getKey() == key){
                       return e.getValue();
                   }  
               }
           }
           
           return null;
       }
       
       private int getIndex(K key) {
           if(key == null) return -1;
           return (key.hashCode() & 0x7fffffff) % entities.length;
       }
}
