/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* fast = head;
        ListNode* slow = nullptr;
        int cnt = 0;
        while(fast->next != nullptr) {
            fast = fast->next;
            cnt++;
            if(cnt == n) slow = head;
            if(cnt > n) slow = slow->next;
        }
        if(slow == nullptr) return head->next;
        slow->next = slow->next->next;
        return head;
    }
};