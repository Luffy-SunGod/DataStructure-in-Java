package LinearDataStructure;

import java.util.Scanner;

public class TestLinkedList {
    static Scanner s=new Scanner(System.in);
    public static void main(String[] args) {
        int n=s.nextInt();
        ListNode head=createLinkedList(n);
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;

        }
        System.out.print("null");
    }

    public static ListNode createLinkedList(int size){
        int val=s.nextInt();
        ListNode head=new ListNode(val);
        size--;
        ListNode tail=head;
        while(size-->0){
            val=s.nextInt();
            ListNode nn=new ListNode(val);
            tail.next=nn;
            tail=nn;
        }
        return head;
    }
}
