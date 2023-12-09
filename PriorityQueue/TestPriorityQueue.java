package PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue pq=new PriorityQueue();
        pq.add(1);
        pq.add(21);
        pq.add(12);
        pq.add(13);
        pq.add(131);
        pq.add(12);
        pq.add(21);


        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }

    }
}
