# 5.最長回文字串

### 題目：


回文串就是正着读和反着读都一样的字符串。比如说字符串 aba 和 abba 都是回文串，因为它们对称，反过来还是和本身一样；反之，字符串 abac 就不是回文串。

Input: s = "babad"  
Output: "bab"  
Explanation: "aba" is also a valid answer. 

现在你应该能感觉到回文串问题和左右指针肯定有密切的联系，比如让你判断一个字符串是不是回文串,可以用下面程式

```java
boolean isPalindrome(String s) {
    // 一左一右两个指针相向而行
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

```

### 解題
- 用雙指針從s的中間往左右展開跑
- 如果s的長度是單數,兩個指針起點都是中間那個字
- 如果s是雙數,會有兩個中心字

ex:babad
中間是b

```text
step1:
    babad
      l
      r
s.charAt(l) = b
s.charAt(r) = b

step2:
    babad
     l
       r
s.charAt(l) = a
s.charAt(r) = a

step3:
    babad
    l    
        r
s.charAt(l) = b
s.charAt(r) = d 
跳出while迴圈
return s.substring(1,4)
substring(beginIndex, endIndex)
begin包括
end不包括
ex : s=babad , substring(1,4) = aba
```

    