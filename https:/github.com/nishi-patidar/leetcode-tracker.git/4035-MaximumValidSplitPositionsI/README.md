# 4035. Maximum Valid Split Positions I

**Difficulty:** Medium  
[View on LeetCode](https://leetcode.com/problems/maximum-valid-split-positions-i/)

---

You are given an integer array `nums`.

You may remove **at most one** element from `nums`. Let `arr` be the array of remaining elements in their original order, and let `m` be its length.

A **split position** `i` of `arr` is **valid** if:

- `0 <= i < m - 1`, and
- `gcd(arr[0..i]) == gcd(arr[i + 1..m - 1])`.

An array of length 1 has no valid split positions.

The **score** of `arr` is the number of valid split positions in it.

Return the **maximum possible score** of `arr`.

Here, `gcd(a)` denotes the **greatest common divisor** of all elements in the array `a`.

**Example 1:**

**Input:** nums = [10,30,15,10]

**Output:** 2

**Explanation:**

One optimal solution is to remove `nums[2] = 15`. Then `arr = [10, 30, 10]`.

The split positions are:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse; text-align:center;">
	<tbody>
		<tr>
			<th>Split Position <code>i</code></th>
			<th><code>gcd(arr[0..i])</code></th>
			<th><code>gcd(arr[i + 1..m - 1])</code></th>
		</tr>
		<tr>
			<td>0</td>
			<td>10</td>
			<td>10</td>
		</tr>
		<tr>
			<td>1</td>
			<td>10</td>
			<td>10</td>
		</tr>
	</tbody>
</table>

All split positions are valid. Thus, the answer is 2.

**Example 2:**

**Input:** nums = [2,10,14]

**Output:** 1

**Explanation:**

One optimal solution is to not remove any element. Then `arr = [2, 10, 14]`.

The split positions are:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse; text-align:center;">
	<tbody>
		<tr>
			<th>Split Position <code>i</code></th>
			<th><code>gcd(arr[0..i])</code></th>
			<th><code>gcd(arr[i + 1..m - 1])</code></th>
		</tr>
		<tr>
			<td>0</td>
			<td>2</td>
			<td>2</td>
		</tr>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>14</td>
		</tr>
	</tbody>
</table>

Only the split position at index 0 is valid. Thus, the answer is 1.

**Example 3:**

**Input:** nums = [2,4]

**Output:** 0

**Explanation:**

The only remaining array that has a split position is `arr = [2, 4]`.

The split positions are:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse; text-align:center;">
	<tbody>
		<tr>
			<th>Split Position <code>i</code></th>
			<th><code>gcd(arr[0..i])</code></th>
			<th><code>gcd(arr[i + 1..m - 1])</code></th>
		</tr>
		<tr>
			<td>0</td>
			<td>2</td>
			<td>4</td>
		</tr>
	</tbody>
</table>

There are no valid split positions. Thus, the answer is 0.

**Constraints:**

- `2 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^9`​​​​​​​
