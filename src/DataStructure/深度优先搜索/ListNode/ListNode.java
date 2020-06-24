package DataStructure.深度优先搜索.ListNode;

public class ListNode {

    int val;
    ListNode next;
    ListNode head;
    ListNode tail;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        int x=Integer.MAX_VALUE;
        int y=10;
        Byte a=new Byte("11");
        System.out.println (-y);

//        if(isOverFlow (x,1)){
//            System.out.println ("溢出");
//        }
//        else{
//            System.out.println ("正常");
//        }
    }
    public static boolean isOverFlow(int x,int y){
        return x+y<x;
    }
}
