# 4074. Maximum Product Pair With Target Sum

**Difficulty:** Easy  
[View on LeetCode](https://leetcode.com/problems/maximum-product-pair-with-target-sum/)

---

You are given an integer array `nums` and an integer `target`.

A pair of **distinct** indices `(i, j)` is **valid** if:

- `nums[i] + nums[j] == target`
- `nums[i] > nums[j]`

Return a **valid** pair `[i, j]` whose **product** `nums[i] * nums[j]` is **maximum** among all valid pairs. If no valid pair exists, return `[-1, -1]`.

If multiple valid pairs achieve the **maximum** product, you may return **any** of them.

**Example 1:**

**Input:** nums = [1,2,3,4], target = 5

**Output:** [2,1]

**Explanation:**

There are 2 valid pairs:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse;">
	<thead>
		<tr>
			<th scope="col" style="text-align:center;">No.</th>
			<th scope="col" style="text-align:center;"><code>(i, j)</code></th>
			<th scope="col" style="text-align:center;"><code>nums[i]</code></th>
			<th scope="col" style="text-align:center;"><code>nums[j]</code></th>
			<th scope="col" style="text-align:center;">Sum</th>
			<th scope="col" style="text-align:center;">Product</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">(3, 0)</td>
			<td style="text-align:center;">4</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">5</td>
			<td style="text-align:center;">4</td>
		</tr>
		<tr>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">(2, 1)</td>
			<td style="text-align:center;">3</td>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">5</td>
			<td style="text-align:center;">6</td>
		</tr>
	</tbody>
</table>

Both pairs sum to 5 and satisfy `nums[i] > nums[j]`. The second pair has the larger product, `3 * 2 = 6`, so the answer is `[2, 1]`.

**Example 2:**

**Input:** nums = [-3,-1,4,2], target = 1

**Output:** [3,1]

**Explanation:**

There are 2 valid pairs:

<table border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse;">
	<thead>
		<tr>
			<th scope="col" style="text-align:center;">No.</th>
			<th scope="col" style="text-align:center;"><code>(i, j)</code></th>
			<th scope="col" style="text-align:center;"><code>nums[i]</code></th>
			<th scope="col" style="text-align:center;"><code>nums[j]</code></th>
			<th scope="col" style="text-align:center;">Sum</th>
			<th scope="col" style="text-align:center;">Product</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">(2, 0)</td>
			<td style="text-align:center;">4</td>
			<td style="text-align:center;">-3</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">-12</td>
		</tr>
		<tr>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">(3, 1)</td>
			<td style="text-align:center;">2</td>
			<td style="text-align:center;">-1</td>
			<td style="text-align:center;">1</td>
			<td style="text-align:center;">-2</td>
		</tr>
	</tbody>
</table>

Since `-2 > -12`, the pair at indices `(3, 1)` is chosen and the answer is `[3, 1]`.

**Example 3:**

**Input:** nums = [3,3,5], target = 6

**Output:** [-1,-1]

**Explanation:**

**​​​​​​​**No valid pair exists, since `nums[0]` and `nums[1]` sum to 6 but are equal.

**Constraints:**

- `2 <= nums.length <= 100`
- `-100 <= nums[i], target <= 100`​​​​​​​
