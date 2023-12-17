class Solution {
    String add(String first, String second) {
        int len = Math.max(first.length(), second.length());
        StringBuilder f = new StringBuilder(first);
        StringBuilder s = new StringBuilder(second);
        f.reverse();
        while(len > f.length()) {
            f.append('0');
        }
        f.reverse();
        s.reverse();
        while(len > s.length()) {
            s.append('0');
        }
        s.reverse();
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=len-1; i>=0; i--) {
            int fi = f.charAt(i)-'0';
            int sc = s.charAt(i)-'0';
            int res = fi + sc + carry;
            ans.append(res%10);
            carry = res / 10;
        }
        if(carry != 0) ans.append(carry);
        return ans.reverse().toString();
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        var list = new LinkedList<String>();
        for(int i=m-1; i>=0; i--) {
            StringBuilder curr = new StringBuilder();
            int carry = 0;
            int num = num1.charAt(i)-'0';
            for(int j=n-1; j>=0; j--) {
                int currNum = num2.charAt(j)-'0';
                int res = num * currNum;
                res += carry;
                curr.append(res%10);
                carry = res / 10;
            }
            if(carry != 0) curr.append(carry);
            curr = curr.reverse();
            for(int k=m-1; k>i; k--) curr.append('0');
            list.add(curr.toString());
        }
        // System.out.println(list);
        while(list.size() > 1) {
            String first = list.poll();
            String second = list.poll();
            list.addFirst(add(first, second));
        }
        return list.poll();
    }
}