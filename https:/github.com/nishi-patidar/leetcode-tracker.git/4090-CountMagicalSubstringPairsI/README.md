# 4090. Count Magical Substring Pairs I

**Difficulty:** Medium  
[View on LeetCode](https://leetcode.com/problems/count-magical-substring-pairs-i/)

---

You are given a string `s` of length `n` consisting of lowercase English letters.

For every triplet of indices `(i, j, k)` satisfying `0 <= i <= j < k < n`, define:

- `s1 = s[i..j]`
- `s2 = s[j + 1..k]`

A pair of **substrings** `(s1, s2)` is called **magical** if the number of **distinct** characters in `s1` is **equal** to the number of **distinct** characters in `s2`.

Return the number of **triplets** `(i, j, k)` for which `(s1, s2)` is a **magical** pair.

A **substring** is a contiguous **non-empty** sequence of characters within a string.

**Example 1:**

**Input:** s = "aba"

**Output:** 2

**Explanation:**

There are 2 valid triplets:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse;">
	<thead>
		<tr>
			<th scope="col" style="text-align:center;">No.</th>
			<th scope="col" style="text-align:center;"><code>(i, j, k)</code></th>
			<th scope="col" style="text-align:center;"><code>s1</code></th>
			<th scope="col" style="text-align:center;"><code>s2</code></th>
			<th scope="col" style="text-align:center;"><code>distinct(s1)</code></th>
			<th scope="col" style="text-align:center;"><code>distinct(s2)</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">(0, 0, 1)</td>
			<td style="text-align:center;">&quot;a&quot;</td>
			<td style="text-align:center;">&quot;b&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
		<tr>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">(1, 1, 2)</td>
			<td style="text-align:center;">&quot;b&quot;</td>
			<td style="text-align:center;">&quot;a&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
	</tbody>
</table>

**Example 2:**

**Input:** s = "kkk"

**Output:** 4

**Explanation:**

There are 4 valid triplets:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse;">
	<thead>
		<tr>
			<th scope="col" style="text-align:center;">No.</th>
			<th scope="col" style="text-align:center;"><code>(i, j, k)</code></th>
			<th scope="col" style="text-align:center;"><code>s1</code></th>
			<th scope="col" style="text-align:center;"><code>s2</code></th>
			<th scope="col" style="text-align:center;"><code>distinct(s1)</code></th>
			<th scope="col" style="text-align:center;"><code>distinct(s2)</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">(0, 0, 1)</td>
			<td style="text-align:center;">&quot;k&quot;</td>
			<td style="text-align:center;">&quot;k&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
		<tr>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">(0, 0, 2)</td>
			<td style="text-align:center;">&quot;k&quot;</td>
			<td style="text-align:center;">&quot;kk&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
		<tr>
			<td style="text-align:center;">3</td>
			<td style="text-align:center;">(0, 1, 2)</td>
			<td style="text-align:center;">&quot;kk&quot;</td>
			<td style="text-align:center;">&quot;k&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
		<tr>
			<td style="text-align:center;">4</td>
			<td style="text-align:center;">(1, 1, 2)</td>
			<td style="text-align:center;">&quot;k&quot;</td>
			<td style="text-align:center;">&quot;k&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
	</tbody>
</table>

**Example 3:**

**Input:** s = "abcac"

**Output:** 7

**Explanation:**

There are 7 valid triplets:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse;">
	<thead>
		<tr>
			<th scope="col" style="text-align:center;">No.</th>
			<th scope="col" style="text-align:center;"><code>(i, j, k)</code></th>
			<th scope="col" style="text-align:center;"><code>s1</code></th>
			<th scope="col" style="text-align:center;"><code>s2</code></th>
			<th scope="col" style="text-align:center;"><code>distinct(s1)</code></th>
			<th scope="col" style="text-align:center;"><code>distinct(s2)</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">(0, 0, 1)</td>
			<td style="text-align:center;">&quot;a&quot;</td>
			<td style="text-align:center;">&quot;b&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
		<tr>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">(1, 1, 2)</td>
			<td style="text-align:center;">&quot;b&quot;</td>
			<td style="text-align:center;">&quot;c&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
		<tr>
			<td style="text-align:center;">3</td>
			<td style="text-align:center;">(2, 2, 3)</td>
			<td style="text-align:center;">&quot;c&quot;</td>
			<td style="text-align:center;">&quot;a&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
		<tr>
			<td style="text-align:center;">4</td>
			<td style="text-align:center;">(3, 3, 4)</td>
			<td style="text-align:center;">&quot;a&quot;</td>
			<td style="text-align:center;">&quot;c&quot;</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">1</td>
		</tr>
		<tr>
			<td style="text-align:center;">5</td>
			<td style="text-align:center;">(0, 1, 3)</td>
			<td style="text-align:center;">&quot;ab&quot;</td>
			<td style="text-align:center;">&quot;ca&quot;</td>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">2</td>
		</tr>
		<tr>
			<td style="text-align:center;">6</td>
			<td style="text-align:center;">(0, 1, 4)</td>
			<td style="text-align:center;">&quot;ab&quot;</td>
			<td style="text-align:center;">&quot;cac&quot;</td>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">2</td>
		</tr>
		<tr>
			<td style="text-align:center;">7</td>
			<td style="text-align:center;">(1, 2, 4)</td>
			<td style="text-align:center;">&quot;bc&quot;</td>
			<td style="text-align:center;">&quot;ac&quot;</td>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">2</td>
		</tr>
	</tbody>
</table>

**Constraints:**

- `2 <= s.length <= 2000`
- `s` consists of lowercase English letters.
