// Last updated: 8/3/2026, 12:46:01 PM
#include <stdlib.h>
#include <limits.h>

// Struct to keep track of a number and its original index
typedef struct {
    int val;
    int idx;
} Element;

// Comparator to sort primarily by value, then by original index
int cmp(const void* a, const void* b) {
    Element* ea = (Element*)a;
    Element* eb = (Element*)b;
    if (ea->val != eb->val) {
        return (ea->val < eb->val) ? -1 : 1; 
    }
    return ea->idx - eb->idx;
}

int* solveQueries(int* nums, int numsSize, int* queries, int queriesSize, int* returnSize) {
    // 1. Create and sort the array of elements
    Element* arr = (Element*)malloc(numsSize * sizeof(Element));
    for (int i = 0; i < numsSize; i++) {
        arr[i].val = nums[i];
        arr[i].idx = i;
    }
    
    qsort(arr, numsSize, sizeof(Element), cmp);

    // 2. Map original indices to their new positions in the sorted array
    int* pos_in_sorted = (int*)malloc(numsSize * sizeof(int));
    for (int i = 0; i < numsSize; i++) {
        pos_in_sorted[arr[i].idx] = i;
    }

    // 3. Find the start and end boundaries of each identical value group
    int* group_start = (int*)malloc(numsSize * sizeof(int));
    int* group_end = (int*)malloc(numsSize * sizeof(int));
    
    int i = 0;
    while (i < numsSize) {
        int j = i;
        while (j < numsSize && arr[j].val == arr[i].val) {
            j++;
        }
        // Assign bounds for this entire group
        for (int k = i; k < j; k++) {
            group_start[k] = i;
            group_end[k] = j - 1;
        }
        i = j;
    }

    // 4. Process queries
    int* answer = (int*)malloc(queriesSize * sizeof(int));
    *returnSize = queriesSize;

    for (int q = 0; q < queriesSize; q++) {
        int targetIdx = queries[q];
        int p = pos_in_sorted[targetIdx];
        int S = group_start[p];
        int E = group_end[p];

        // If the group only has 1 element, no duplicates exist
        if (S == E) {
            answer[q] = -1;
            continue;
        }

        int minData = INT_MAX;

        // Check left neighbor (wrap around backwards if we are at the start)
        if (p > S) {
            int dist = arr[p].idx - arr[p - 1].idx;
            if (dist < minData) minData = dist;
        } else {
            int dist = arr[p].idx + numsSize - arr[E].idx;
            if (dist < minData) minData = dist;
        }

        // Check right neighbor (wrap around forwards if we are at the end)
        if (p < E) {
            int dist = arr[p + 1].idx - arr[p].idx;
            if (dist < minData) minData = dist;
        } else {
            int dist = arr[S].idx + numsSize - arr[p].idx;
            if (dist < minData) minData = dist;
        }

        answer[q] = minData;
    }

    // Free memory
    free(arr);
    free(pos_in_sorted);
    free(group_start);
    free(group_end);

    return answer;
}
