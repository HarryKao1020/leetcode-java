<p>An <strong>ugly number</strong> is a positive integer whose prime factors are limited to <code>2</code>, <code>3</code>, and <code>5</code>.</p>

<p>Given an integer <code>n</code>, return <em>the</em> <code>n<sup>th</sup></code> <em><strong>ugly number</strong></em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> 12
<strong>Explanation:</strong> [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
<strong>Explanation:</strong> 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 1690</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | Math | Dynamic Programming | Heap (Priority Queue)</details><br>

<div>👍 6670, 👎 422<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/frequency-interview/ugly-number-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题很精妙，你看着它好像是道数学题，实际上它却是一个合并多个有序链表的问题，同时用到了筛选素数的思路。

建议你先做一下 [链表双指针技巧汇总](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中讲到的 [21. 合并两个有序链表（简单）](/problems/merge-two-sorted-lists)，然后再做一下 [如何高效寻找素数](https://labuladong.online/algo/frequency-interview/print-prime-number/) 中讲的 [204. 计数质数（简单）](/problems/count-primes)，这样的话就能比较容易理解这道题的思路了。

**类似 [如何高效寻找素数](https://labuladong.online/algo/frequency-interview/print-prime-number/) 的思路：如果一个数 `x` 是丑数，那么 `x * 2, x * 3, x * 5` 都一定是丑数**。

我们把所有丑数想象成一个从小到大排序的链表，就是这个样子：

```java
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 8 -> ...
```

然后，我们可以把丑数分为三类：2 的倍数、3 的倍数、5 的倍数（按照题目的意思，1 算作特殊的丑数，放在开头），这三类丑数就好像三条有序链表，如下：

能被 2 整除的丑数：

```java
1 -> 1*2 -> 2*2 -> 3*2 -> 4*2 -> 5*2 -> 6*2 -> 8*2 ->...
```

能被 3 整除的丑数：

```java
1 -> 1*3 -> 2*3 -> 3*3 -> 4*3 -> 5*3 -> 6*3 -> 8*3 ->...
```

能被 5 整除的丑数：

```java
1 -> 1*5 -> 2*5 -> 3*5 -> 4*5 -> 5*5 -> 6*5 -> 8*5 ->...
```

我们其实就是想把这三条「有序链表」合并在一起并去重，合并的结果就是丑数的序列。然后求合并后的这条有序链表中第 `n` 个元素是什么。所以这里就和 [链表双指针技巧汇总](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中讲到的合并 `k` 条有序链表的思路基本一样了。

具体思路看注释吧，你也可以对照我在 [21. 合并两个有序链表（简单）](/problems/merge-two-sorted-lists) 中给出的思路代码来看本题的思路代码，就能轻松看懂本题的解法代码了。

**详细题解**：
  - [一文秒杀所有丑数系列问题](https://labuladong.online/algo/frequency-interview/ugly-number-summary/)
  - [【强化练习】链表双指针经典习题](https://labuladong.online/algo/problem-set/linkedlist-two-pointers/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution {
public:
    int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        vector<int> ugly(n + 1);
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int min = std::min({product2, product3, product5});
            // 接到结果链表上
            ugly[p] = min;
            p++;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # 可以理解为三个指向有序链表头结点的指针
        p2, p3, p5 = 1, 1, 1
        # 可以理解为三个有序链表的头节点的值
        product2, product3, product5 = 1, 1, 1
        # 可以理解为最终合并的有序链表（结果链表）
        ugly = [0] * (n + 1)
        # 可以理解为结果链表上的指针
        p = 1

        # 开始合并三个有序链表
        while p <= n:
            # 取三个链表的最小结点
            min_val = min(product2, product3, product5)
            # 接到结果链表上
            ugly[p] = min_val
            p += 1
            # 前进对应有序链表上的指针
            if min_val == product2:
                product2 = 2 * ugly[p2]
                p2 += 1
            if min_val == product3:
                product3 = 3 * ugly[p3]
                p3 += 1
            if min_val == product5:
                product5 = 5 * ugly[p5]
                p5 += 1
        
        # 返回第 n 个丑数
        return ugly[n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int min = Math.min(Math.min(product2, product3), product5);
            // 接到结果链表上
            ugly[p] = min;
            p++;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func nthUglyNumber(n int) int {
    // 可以理解为三个指向有序链表头结点的指针
    p2, p3, p5 := 1, 1, 1
    // 可以理解为三个有序链表的头节点的值
    product2, product3, product5 := 1, 1, 1
    // 可以理解为最终合并的有序链表（结果链表）
    ugly := make([]int, n+1)
    // 可以理解为结果链表上的指针
    p := 1

    // 开始合并三个有序链表
    for p <= n {
        // 取三个链表的最小结点
        min := min(min(product2, product3), product5)
        // 接到结果链表上
        ugly[p] = min
        p++
        // 前进对应有序链表上的指针
        if min == product2 {
            product2 = 2 * ugly[p2]
            p2++
        }
        if min == product3 {
            product3 = 3 * ugly[p3]
            p3++
        }
        if min == product5 {
            product5 = 5 * ugly[p5]
            p5++
        }
    }
    // 返回第 n 个丑数
    return ugly[n]
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var nthUglyNumber = function(n) {
    // 可以理解为三个指向有序链表头结点的指针
    let p2 = 1, p3 = 1, p5 = 1;
    // 可以理解为三个有序链表的头节点的值
    let product2 = 1, product3 = 1, product5 = 1;
    // 可以理解为最终合并的有序链表（结果链表）
    let ugly = new Array(n + 1);
    // 可以理解为结果链表上的指针
    let p = 1;

    // 开始合并三个有序链表
    while (p <= n) {
        // 取三个链表的最小结点
        let min = Math.min(Math.min(product2, product3), product5);
        // 接到结果链表上
        ugly[p] = min;
        p++;
        // 前进对应有序链表上的指针
        if (min == product2) {
            product2 = 2 * ugly[p2];
            p2++;
        }
        if (min == product3) {
            product3 = 3 * ugly[p3];
            p3++;
        }
        if (min == product5) {
            product5 = 5 * ugly[p5];
            p5++;
        }
    }
    // 返回第 n 个丑数
    return ugly[n];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_ugly-number-ii" data="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" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ugly-number-ii"></div></div>
</details><hr /><br />

</div>
</details>
</div>

