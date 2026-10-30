# 4094. Count Frequency Staircase Subarrays I

**Difficulty:** Medium  
[View on LeetCode](https://leetcode.com/problems/count-frequency-staircase-subarrays-i/)

---

You are given an integer array `nums`.

Consider the **distinct** values of a **subarray** in the order in which they first appear.

If there are `k` distinct values, the subarray is called a **frequency staircase** if the first distinct value occurs **exactly once**, the second distinct value occurs **exactly twice**, and so on, with the `k^th` distinct value occurring **exactly** `k` times.

Equivalently, the frequencies of the distinct values, in the order of their first occurrence, must be exactly `1, 2, 3, ..., k`.

Return the **number** of frequency staircase subarrays in `nums`.

A **subarray** is a contiguous **non-empty** sequence of elements within an array.

The **frequency** of a value in a subarray is the number of times it occurs in that subarray.

**Example 1:**

**Input:** nums = [5,8,8,2,2,2]

**Output:** 9

**Explanation:**

Every single-element subarray has frequencies `[1]`, and there are 6 of them. 3 longer subarrays also qualify:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse;">
	<thead>
		<tr>
			<th scope="col" style="text-align:center;">Subarray</th>
			<th scope="col" style="text-align:center;">Values by first appearance</th>
			<th scope="col" style="text-align:center;">Frequencies</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align:center;"><code>nums[0...2] = [5, 8, 8]</code></td>
			<td style="text-align:center;">5, then 8</td>
			<td style="text-align:center;">[1, 2]</td>
		</tr>
		<tr>
			<td style="text-align:center;"><code>nums[2...4] = [8, 2, 2]</code></td>
			<td style="text-align:center;">8, then 2</td>
			<td style="text-align:center;">[1, 2]</td>
		</tr>
		<tr>
			<td style="text-align:center;"><code>nums[0...5] = [5, 8, 8, 2, 2, 2]</code></td>
			<td style="text-align:center;">5, then 8, then 2</td>
			<td style="text-align:center;">[1, 2, 3]</td>
		</tr>
	</tbody>
</table>

So the answer is `6 + 3 = 9`.

**Example 2:**

**Input:** nums = [6,6,9,9]

**Output:** 5

**Explanation:**

Every single-element subarray has frequencies `[1]`, and there are 4 of them. 1 longer subarray also qualifies:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse;">
	<thead>
		<tr>
			<th scope="col" style="text-align:center;">Subarray</th>
			<th scope="col" style="text-align:center;">Values by first appearance</th>
			<th scope="col" style="text-align:center;">Frequencies</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align:center;"><code>nums[1...3] = [6, 9, 9]</code></td>
			<td style="text-align:center;">6, then 9</td>
			<td style="text-align:center;">[1, 2]</td>
		</tr>
	</tbody>
</table>

So the answer is `4 + 1 = 5`.

**Example 3:**

**Input:** nums = [2,3,4,4,3,4]

**Output:** 8

**Explanation:**

Every single-element subarray has frequencies `[1]`, and there are 6 of them. 2 longer subarrays also qualify:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse;">
	<thead>
		<tr>
			<th scope="col" style="text-align:center;">Subarray</th>
			<th scope="col" style="text-align:center;">Values by first appearance</th>
			<th scope="col" style="text-align:center;">Frequencies</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align:center;"><code>nums[1...3] = [3, 4, 4]</code></td>
			<td style="text-align:center;">3, then 4</td>
			<td style="text-align:center;">[1, 2]</td>
		</tr>
		<tr>
			<td style="text-align:center;"><code>nums[0...5] = [2, 3, 4, 4, 3, 4]</code></td>
			<td style="text-align:center;">2, then 3, then 4</td>
			<td style="text-align:center;">[1, 2, 3]</td>
		</tr>
	</tbody>
</table>

So the answer is `6 + 2 = 8`.

**Constraints:**

- `1 <= nums.length <= 1500`
- `1 <= nums[i] <= 10^5`
