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
    ListNode* oddEvenList(ListNode* head) {
        ListNode *curr = head;
        ListNode oddNode(0);
        ListNode *odd = &oddNode;
        ListNode *oddHead = &oddNode;
        ListNode evenNode(0);
        ListNode *even = &evenNode;
        ListNode *evenHead = &evenNode;
        bool flag = true;
        while(curr != nullptr) {
            if(flag) {
                odd->next = curr;
                odd = odd->next;
            }
            else{
                even->next = curr;
                even = even->next;
            }
            curr = curr->next;
            flag = !flag;
        }
        oddHead = oddHead->next;
        evenHead = evenHead->next;
        odd->next = evenHead;
        even->next = nullptr;
        return oddHead;
    }
};