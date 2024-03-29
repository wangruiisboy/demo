### leetcode 390周赛第一道
### 暴力 or 滑动窗口


###暴力
``` java
class Solution {

    public int maximumLengthSubstring(String s) {
        
        int ans = 0;
        int n = s.length();
        //暴力,枚举开始和结束
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                var cur = s.substring(i,j+1);
                boolean flag = false;
                int []cnt = new int[30];

                for(var c:cur.toCharArray()){
                    cnt[c-'a']+=1;
                    if(cnt[c-'a']>2){
                        flag = true;
                    }
                }

                if(flag){
                    continue;
                }

                //更新答案
                ans = Math.max(ans,j-i+1);
            }
        }

        return ans;

    }
}

```


###滑动窗口，好久没写了

``` java
    class Solution {

    public int maximumLengthSubstring(String s) {
        
        int ans = 0;
        int n = s.length();
        int left = 0 ,right = 0;
        
        //转换为字符出数组，不想用charAt方法，代码太长
        var t = s.toCharArray();
        int []cnt = new int[26];
        while(right < n){
            cnt[t[right]-'a']+=1;
            
            //不满足缩小左边窗口
            while(cnt[t[right]-'a'] > 2){
                
                cnt[t[left]-'a']-=1;
                left += 1;
            }

            //先更新答案
            ans = Math.max(ans,right - left + 1);

            //然后更新right
            right +=1;
            

        }
        return ans;

    }
}

```