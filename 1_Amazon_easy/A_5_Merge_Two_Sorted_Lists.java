import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class A_5_Merge_Two_Sorted_Lists {

    // Create linked list from array
    static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int value : arr) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }

    // Merge two sorted linked lists
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } 
            else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            tail.next = list1;
        } 
        else {
            tail.next = list2;
        }

        return dummy.next;
    }

    // Print linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size of first list
        int n = sc.nextInt();

        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input size of second list
        int m = sc.nextInt();

        int[] arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        // Create linked lists
        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        // Merge
        ListNode result = mergeTwoLists(list1, list2);

        // Output
        printList(result);

        sc.close();
    }
}