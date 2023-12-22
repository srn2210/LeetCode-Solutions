class Solution {
public:
    int maxScore(string s) {
        int ls,rs;
        ls=0;
        rs=0;
        int maxval,ind;
        maxval=INT_MIN;
        int i;
        int c0=0,c1=0,t0=0;
        for(i=0;i<s.length();i++) {
            if(s[i]=='0') {
                ls++;
                t0++;
            }
            else {
                ls--;
                c1++;
            }
            cout<<ls<<" ";
            if(ls>maxval) {
                maxval=ls;
                c0=t0;
                ind=i;
                c1=0;
            }
            cout<<"count 0="<<c0<<" count 1="<<c1<<endl;
        }
        cout<<maxval<<" "<<ind<<endl;
        cout<<c0<<" "<<c1<<endl;
        if(ind==s.length()-1) return c0+c1-1;
        return c0+c1;
    }
};