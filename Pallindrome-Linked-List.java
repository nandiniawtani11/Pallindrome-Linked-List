/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//First Solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public ListNode reverse(ListNode head1)
    {
         if(head1==null)
		{
			return head1;
		}
		ListNode current=head1;
		ListNode previous=null;
		ListNode next=null;
		while(current!=null)
		{
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		return previous;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode current=head;
        ListNode newlist=null;
        ListNode current1=newlist;
        while(current!=null)
        {
            ListNode newNode=new ListNode(current.val);
            if(newlist==null)
            {
                newlist=newNode;
                current1=newlist;
                newlist.next=null;
            }
            else
            {
                current1.next=newNode;
                current1=newNode;
            }
            current=current.next;
        }
        ListNode rev=reverse(head);
        while(rev!=null)
        {
            if(rev.val!=newlist.val)
                return false;
            newlist=newlist.next;
            rev=rev.next;
        }
        return true;
        
    }
}

//Second Solution
class Solution {
    //calculating length of list
    public int length(ListNode head) 
    {
        if(head==null)
        {
            return 0;
        }
        int count=0;
        ListNode current=head;
        while(current!=null)
        {
            count++;
            current=current.next;
        }
        return count;
    }
    //forming a new list to store the second half of the given list
     ListNode head1=null; ListNode tail=null;
    public void insert(int i)
    {
        if(head1==null || tail==null)
        {
            head1=new ListNode(i);
            tail=head1;
        }    
        else{
            ListNode newNode=new ListNode(i);
            tail.next=newNode;
            tail=newNode;
        }
    }   
    //reverse the second half of the list to check if it matches with the first half
    public ListNode reverse(ListNode head1)
    {
         if(head1==null)
		{
			return head1;
		}
		ListNode current=head1;
		ListNode previous=null;
		ListNode next=null;
		while(current!=null)
		{
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		return previous;
    }   
    public boolean isPalindrome(ListNode head) {
        int n=length(head);
        if(n==1)
            return true;
        ListNode fast=head;
        ListNode slow=head;
        int t=n/2;
        //if length of the list is odd removing the middle element
         for(int k=0;k<t;k++)
        {
             slow=fast;
             fast=fast.next; 
        }
        if(n%2!=0)
        {
            slow.next=fast.next;
            fast=fast.next;
        }
        // breaking the list in two half
        slow.next=null;
        //creating new list with second half of the ist 
        while(fast!=null)
        {
            insert(fast.val);
            fast=fast.next;
        }
        ListNode test=head;
        ListNode test1=reverse(head1);
        //while loop to check if each element of the two list match with one another
        while(test!=null)
        {
            if(test.val!=test1.val)// if one element also does not match it returns false
                return false;
            test=test.next;
            test1=test1.next;
        }
        return true;
    }
}


