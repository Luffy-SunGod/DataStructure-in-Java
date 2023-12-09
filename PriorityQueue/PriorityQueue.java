package PriorityQueue;

import java.util.*;

public class PriorityQueue{
    private ArrayList<Integer> list;
    public PriorityQueue(){
        list=new ArrayList<>();
    }

    public void add(int val){
        list.add(val);
        int ci=this.list.size()-1;
        upHeapfiy(ci);
    
    }

    private void upHeapfiy(int ci){
        int pi=(ci-1)/2;
        if(this.list.get(pi) > this.list.get(ci)){
            swap(pi,ci);
            upHeapfiy(pi);
        }
    }

    public int remove(){
        int x=this.list.get(0);
        swap(0,this.list.size()-1);
        list.remove(this.list.size()-1);
        downHeapify(0);
        return x;
    }

    private void downHeapify(int pi) {
        int c1=pi*2+1;
        int c2=pi*2+2;

        int mini=pi;
        if(c1<this.list.size()&&this.list.get(c1)<this.list.get(mini)){
            mini=c1;
        }
        if(c2<this.list.size()&&this.list.get(c2)<this.list.get(mini)){
            mini=c2;
        }

        if(mini!=pi){
            swap(pi,mini);
            downHeapify(mini);
        }

    }

    private void swap(int i,int j){
        int ith=this.list.get(i);
        int jth=this.list.get(j);

        list.set(i, jth);
        list.set(j, ith);

    }
    public int size(){
        return this.list.size();
    }
    public boolean isEmpty(){
        return list.size()==0;
    }
    
}
