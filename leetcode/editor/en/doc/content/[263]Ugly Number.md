<p>An <strong>ugly number</strong> is a <em>positive</em> integer which does not have a prime factor other than 2, 3, and 5.</p>

<p>Given an integer <code>n</code>, return <code>true</code> <em>if</em> <code>n</code> <em>is an <strong>ugly number</strong></em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 6
<strong>Output:</strong> true
<strong>Explanation:</strong> 6 = 2 × 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> 1 has no prime factors.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 14
<strong>Output:</strong> false
<strong>Explanation:</strong> 14 is not ugly since it includes the prime factor 7.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Math</details><br>

<div>👍 3586, 👎 1755<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/frequency-interview/ugly-number-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题其实很简单，主要考察你算术基本定理（正整数唯一分解定理），即：**任意一个大于 1 的自然数，要么它本身就是质数，要么它可以分解为若干质数的乘积**。

那么题目所说的丑数当然也可以被分解成若干质数的乘积，且这些质数只包括 2, 3, 5。那么解题思路就很显然了，只要判断 `n` 是不是只有这三种质因子即可。

**详细题解**：
  - [一文秒杀所有丑数系列问题](https://labuladong.online/algo/frequency-interview/ugly-number-summary/)

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
    bool isUgly(int n) {
        if (n <= 0) return false;
        // 如果 n 是丑数，分解因子应该只有 2, 3, 5
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isUgly(self, n: int) -> bool:
        if n <= 0:
            return False
        # 如果 n 是丑数，分解因子应该只有 2, 3, 5
        while n % 2 == 0:
            n //= 2
        while n % 3 == 0:
            n //= 3
        while n % 5 == 0:
            n //= 5
        return n == 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        // 如果 n 是丑数，分解因子应该只有 2, 3, 5
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isUgly(n int) bool {
    if n <= 0 {
        return false
    }
    // 如果 n 是丑数，分解因子应该只有 2, 3, 5
    for n % 2 == 0 {
        n /= 2
    }
    for n % 3 == 0 {
        n /= 3
    }
    for n % 5 == 0 {
        n /= 5
    }
    return n == 1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isUgly = function(n) {
    if (n <= 0) return false;
    // 如果 n 是丑数，分解因子应该只有 2, 3, 5
    while (n % 2 === 0) n /= 2;
    while (n % 3 === 0) n /= 3;
    while (n % 5 === 0) n /= 5;
    return n === 1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_ugly-number" data="G+IWAKwLuLldQSho8sVqleDRg+VFBSP4QrUI8mKp7lZy5YdkcF7IdfNBJOpgnak+HY0Jihda3GblmClbW17IXZLC+AoNDwj10nNN91/VZl71z4PErnTrlMAiGoHYzAVINTn5/e+X9qwKoCurFzdxPX5lAEusWxmym5k7+4oA8/8rswIKgjKVdabCRhhV2cdwtWBX+WIMFsiLV/v9u7sx7+ivm749MykYUp1+x8CpLlMQigieLPnXYe8iQcLHBbNNthuCjQfx97/lsgbW/jIIwdu3TDwKgS1b2I7tAB/Wn8qfccvIJoTs/NeV1xDa2ZYJE5ganE2NbWfJMtej/NX452C3BLtsfnNbIk8kXDe+fRHVgdX3bOMZIOcO7W7XXzeqvQyTbSMdzrAc4fHX5Ft6aSbFwhqpnYz8cKZnEhhHytpgBDaJ5h0qA3xMBY7JFIJ1d8gPeTPLsUMGn4Xo2B6trDXtGawSbWXj4RUtzw8jriYuCWcDnkwXGHYPiZShSgZmzsWQWmzrvO9vMfrblWg7gvCkFx2hgl5mI+ARZtA/h6BqU5pNuj3tAEji/k/CVeE68xH357xKPFr0XIut+2lVP43rPau0Ga6KbGS0HA/4LMOVzDFSTsYqzf+caDGSfWk2aaBMCpS4/21VlDq35wT346ophSUmEyjNYY/zTI5t//ikko2vDrXCJzwDVcPCWp+gzS6WhO2dgKRECDjxU2Uw+yarw2v8uAizUJkYcA5S9I1wpLHe//N9S+ZGmDAgKBbaK79T9rjYRhueF1NDtDtp+lMifkGwvkuRNSyG8TqzlMOJu0TwXjA8s6kwz9dNv//jjz814x/MfX+TOp+ZwR6zLJw5iepC8Wx3sqvKPoEzc7dvy6LMhK08XWm3jToeJQ7NNwf56s0VeQ3TFYVdEuRokqiEs8i0oYPZ0qVr1ol1ho3QUdtR5MqSyBfPJsnqtnzlE8vhugyWeUts05HjYzf05KfkgUUgfiSokdM2HcW4Som6X82GhE1jy1YaZkdpItprvbmmL5rOZkBlwAZot8glMfMwQGnL3extheLQqJxdRGwtFIdB8pSaifFJ3EBx0RZ5RUhcd8pzOW+0+GrM7IjFtX6xnE2OAxIzGeJTnW8ZAk1lNIZ1BMaRGLTzxRZLSWRyv+qFsph9y1JTXUxZrZ4VKYGYEws+e8wpGL4G7HRyqs2OibmfNB2+tH1MhtFip2qaAngVaofiea+7lxBKi3SVcT9OjuDi5QwUh1oKXdgNzxah88IWBJtcS1uWFFQhQN+en1mYQGCSkFmGbb5R+/jATst08A3tcW+BYnJGsckSq2EMwmGlm5btdv6gMhl8Imjr7Mi2kBdbsKNw+pGyEVk0yM9dMKt71O9poXLCc/BDB6OdQc5pDeqmp6M9Fn4oNpGprbQO8khAozFvffQzfQNJcUvGr1uDOueDn98yjEUtB9SLt3QzHU21O/vJbyK5PXZuKjeRMsZO6MPMjli0Nr/6ExFcfYFnpaVxpNgphbYd1lfrmBJwKoNd205XWbiQbMjHrtpG09MqBnn1mmVYWF5surSRDRVuh5cJZOhe2l09GA34DA7ZHMPVYvZ3z11H20KW88OuuYjg1mYZVZGIvSqscFo1WifaOkyW/RZSvCggFoFGHGBewTcrMiGRRYv6jpCHe7+7X7FCEOQgK+ahMtcY6lMV5wJZ9aOfFmj7g2v1C6a+zbjz/woC274mLhgM9T7+59+TNvEkgik4j603srpWrwW77JMmvBGJ9dfZkkUVsyiKpa+m/SgIET9773UPFanBie/PQyXXEqu0y3PpyI00OZZfMZbxvOz/pbnb4SEXolppkffAXQ6XnFNlsEh2o7fJtd1wzba3CbM/DTiIRJd+BxHbTIrcXv9WBCKOoj9WyW7jmT/Z+fJlqcjUzHmEqyh9d/yFCML8R1ZRsAMr4WRU6OjY1lYnsgcvCWKtsUJafww/B84AecLjq9U8A+U3vlIcsb4qmHiUlp4lYITrH5EZ/Wwu+rQ9Q/EKoID8KPlCedFigPtKgFygraWWno37ksfDPgDAAA==" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ugly-number"></div></div>
</details><hr /><br />

</div>
</details>
</div>



