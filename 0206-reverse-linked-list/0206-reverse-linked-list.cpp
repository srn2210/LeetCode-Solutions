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
    ListNode* ans = nullptr;
    ListNode* helper(ListNode* node) {
        if(node == nullptr || node->next == nullptr) {
            ans = node;
            return node;
        }
        ListNode* curr = helper(node->next);
        curr->next = node;
        node->next = nullptr;
        return node;
    }
    ListNode* reverseList(ListNode* head) {
        helper(head);
        return ans;
    }
};