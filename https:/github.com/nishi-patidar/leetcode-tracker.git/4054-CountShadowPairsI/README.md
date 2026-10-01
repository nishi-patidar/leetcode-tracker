# 4054. Count Shadow Pairs I

**Difficulty:** Medium  
[View on LeetCode](https://leetcode.com/problems/count-shadow-pairs-i/)

---

You are given an integer array `nums` of length `n`.

A pair of indices `(i, j)` is called a **shadow pair** if all of the following conditions are satisfied:

- `0 <= i < j < n`
- `nums[i] < nums[j]`
- There **does not exist** an index `k` such that `i < k < j` and `nums[k] < nums[i] < nums[j]`.

Return the total number of **shadow pairs**.

**Example 1:**

**Input:** nums = [3,1,4,1,5]

**Output:** 3

**Explanation:**

<table style="border-collapse: collapse; text-align: center; width: 70%;">
	<thead>
		<tr>
			<th style="padding: 8px;"><code>(i, j)</code></th>
			<th style="padding: 8px;"><code>nums[i]</code></th>
			<th style="padding: 8px;"><code>nums[j]</code></th>
			<th style="padding: 8px;">Shadow Pair</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>(1, 2)</td>
			<td>1</td>
			<td>4</td>
			<td>No index <code>k</code> exists such that <code>1 &lt; k &lt; 2</code></td>
		</tr>
		<tr>
			<td>(1, 4)</td>
			<td>1</td>
			<td>5</td>
			<td><code>nums[2] = 4</code> and <code>nums[3] = 1</code> are not smaller than 1</td>
		</tr>
		<tr>
			<td>(3, 4)</td>
			<td>1</td>
			<td>5</td>
			<td>No index <code>k</code> exists such that <code>3 &lt; k &lt; 4</code></td>
		</tr>
	</tbody>
</table>

Thus, the answer is 3.

**Example 2:**

**Input:** nums = [6,7,6,6,7]

**Output:** 4

**Explanation:**

<table style="border-collapse: collapse; text-align: center; width: 70%;">
	<thead>
		<tr>
			<th style="padding: 8px;"><code>(i, j)</code></th>
			<th style="padding: 8px;"><code>nums[i]</code></th>
			<th style="padding: 8px;"><code>nums[j]</code></th>
			<th style="padding: 8px;">Shadow Pair</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>(0, 1)</td>
			<td>6</td>
			<td>7</td>
			<td>No index <code>k</code> exists such that <code>0 &lt; k &lt; 1</code></td>
		</tr>
		<tr>
			<td>(0, 4)</td>
			<td>6</td>
			<td>7</td>
			<td><code>nums[1] = 7</code>, <code>nums[2] = 6</code>, and <code>nums[3] = 6</code> are not smaller than 6</td>
		</tr>
		<tr>
			<td>(2, 4)</td>
			<td>6</td>
			<td>7</td>
			<td><code>nums[3] = 6</code> is not smaller than 6</td>
		</tr>
		<tr>
			<td>(3, 4)</td>
			<td>6</td>
			<td>7</td>
			<td>No index <code>k</code> exists such that <code>3 &lt; k &lt; 4</code></td>
		</tr>
	</tbody>
</table>

Thus, the answer is 4.

**Example 3:**

**Input:** nums = [1,2,3,4]

**Output:** 6

**Explanation:**

<table style="border-collapse: collapse; text-align: center; width: 70%;">
	<thead>
		<tr>
			<th style="padding: 8px;"><code>(i, j)</code></th>
			<th style="padding: 8px;"><code>nums[i]</code></th>
			<th style="padding: 8px;"><code>nums[j]</code></th>
			<th style="padding: 8px;">Shadow Pair</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>(0, 1)</td>
			<td>1</td>
			<td>2</td>
			<td>No index <code>k</code> exists such that <code>0 &lt; k &lt; 1</code></td>
		</tr>
		<tr>
			<td>(0, 2)</td>
			<td>1</td>
			<td>3</td>
			<td><code>nums[1] = 2</code> is not smaller than 1</td>
		</tr>
		<tr>
			<td>(0, 3)</td>
			<td>1</td>
			<td>4</td>
			<td><code>nums[1] = 2</code> and <code>nums[2] = 3</code> are not smaller than 1</td>
		</tr>
		<tr>
			<td>(1, 2)</td>
			<td>2</td>
			<td>3</td>
			<td>No index <code>k</code> exists such that <code>1 &lt; k &lt; 2</code></td>
		</tr>
		<tr>
			<td>(1, 3)</td>
			<td>2</td>
			<td>4</td>
			<td><code>nums[2] = 3</code> is not smaller than 2</td>
		</tr>
		<tr>
			<td>(2, 3)</td>
			<td>3</td>
			<td>4</td>
			<td>No index <code>k</code> exists such that <code>2 &lt; k &lt; 3</code></td>
		</tr>
	</tbody>
</table>

Thus, the answer is 6.

**Constraints:**

- `3 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
