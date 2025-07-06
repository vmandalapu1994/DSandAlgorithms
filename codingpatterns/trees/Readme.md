# Binary Tree Cameras

---

## 📚 Table of Contents
- [Binary Tree Cameras](#binary-tree-cameras)
- [Path Sum III using Prefix Sum](#path-sum-iii-using-prefix-sum)

---

This is a classic tree problem that can be solved optimally using a greedy approach with a post-order traversal (DFS). The key is to make decisions for a node only after we know the status of its children.

---

## The Core Insight: A Greedy Strategy

To use the minimum number of cameras, we should avoid placing them unnecessarily. Consider a leaf node. Where is the best place to put a camera to cover it?

- Placing it on the **leaf** covers the leaf and its parent.
- Placing it on the **leaf's parent** covers the parent, the parent's parent, the leaf itself, and the leaf's sibling.

Clearly, placing the camera one level up at the parent is more powerful. This leads to our core greedy strategy:

> **Don't place a camera unless you have to, and when you do, place it as high up as possible.**

We can implement this by having each node return its "state" to its parent. A node's state tells the parent what its situation is regarding camera coverage.

---

## Defining the States

We can define three states for any node in the tree after we have processed its subtree:

- **State 0: NEEDS_COVER** - This node is not monitored. It's relying on its parent to place a camera to cover it.
- **State 1: HAS_CAMERA** - This node has a camera installed on it.
- **State 2: COVERED** - This node is monitored (by a camera on a child node), but it doesn't have a camera itself.

---

## The Algorithm: Post-Order Traversal (DFS)

We'll use a post-order traversal (Left → Right → Root) because we need to know the state of the children before we can decide the state of the parent.

Our DFS function will traverse the tree and return one of the three states for each node. We will also use a global counter or a member variable to keep track of the number of cameras installed.

### Logic inside the DFS function for a given node:

1. **Base Case:**
   - If the node is `null`, it doesn't need monitoring. We can consider it `COVERED` (State 2) so that it doesn't affect its parent's decision-making.

2. **Recursive Step:**
   - Recursively call the DFS on the left and right children to get their states.

   ```java
   int leftState = dfs(node.left);
   int rightState = dfs(node.right);
   ```

3. **Greedy Decisions (The "Meet" Step):**
   - Now, based on the children's states, decide the fate of the current node.

   - **Case 1: A child needs cover.**
     - If either `leftState` or `rightState` is `NEEDS_COVER` (State 0), we have no choice. We must place a camera on the current node to cover that child.
     - Increment the camera count.
     - The current node now has a camera, so it returns the state `HAS_CAMERA` (State 1) to its parent.

   - **Case 2: A child has a camera.**
     - If either `leftState` or `rightState` is `HAS_CAMERA` (State 1), it means the current node is now monitored by its child's camera.
     - The current node is now covered without needing its own camera. It returns the state `COVERED` (State 2) to its parent.

   - **Case 3: Both children are covered (but have no cameras).**
     - If both `leftState` and `rightState` are `COVERED` (State 2), it means the current node itself is not yet monitored by anyone. Following our greedy strategy, we don't place a camera here. Instead, we delegate the responsibility upwards.
     - The current node tells its parent that it needs cover by returning the state `NEEDS_COVER` (State 0).

---

## Handling the Root

After the initial DFS call on the root returns, we need to check the root's final state.

- If the root's state is `NEEDS_COVER` (State 0), it means it was never covered by a child camera, and it has no parent to cover it. We must place one last camera on the root.

---

# Path Sum III using Prefix Sum

## The Optimal Approach: Prefix Sum with a Hash Map

The key to an O(N) solution is to realize that this is a "prefix sum" problem on a tree.

---

## The Core Idea

As we traverse down from the root to a node, we can easily calculate the sum of the path from the root to the current node. Let's call this `currentPathSum`.

Now, consider a path that ends at the current node `curr` and has a sum equal to `targetSum`. Let this path start at an ancestor node `anc`.

This means:

```
sum(anc -> curr) = targetSum
```

We also know:

```
sum(root -> curr) = currentPathSum
sum(root -> anc) = prefixSum
```

From the structure of the tree, we can see that:

```
sum(root -> curr) = sum(root -> anc) + sum(anc -> curr)
```

A clearer way to put it is:

```
currentPathSum - prefixSum = targetSum
```

This means that if we are at a node with a `currentPathSum` from the root, and we want to find paths ending at this node that sum to `targetSum`, we just need to look up how many times we have previously seen a prefix sum of `currentPathSum - targetSum` on the path from the root to the current node.

We can keep track of the frequencies of these prefix sums efficiently using a hash map.

---

## Algorithm Steps

1. **Initialize:**
   - A hash map, `prefixSumCount`, to store the frequency of each prefix sum encountered so far on the current path.
   - A counter for the total number of valid paths, `count`, initialized to 0.

2. **Pre-computation:**
   - Before starting, put `(0, 1)` into the `prefixSumCount` map. This is a crucial step to handle cases where a path starting from the root itself equals the `targetSum`. In this scenario, `currentPathSum` would be `targetSum`, and we would look for a prefix sum of `targetSum - targetSum = 0`.

3. **Create a Recursive DFS function:**
   - Let's call it `dfs(node, currentPathSum)`.

4. **Base Case:**
   - If `node` is null, simply return.

5. **Update Current Sum:**
   - Calculate the new path sum: `currentPathSum += node.val`.

6. **Check for Paths:**
   - Look up `currentPathSum - targetSum` in the hash map. If it exists, it means we have found one or more paths ending at the current node that sum to `targetSum`. Add its frequency to our global count.

7. **Update Map for Current Path:**
   - Add the `currentPathSum` to the map to make it available for its children. Increment its count:

   ```java
   prefixSumCount.put(currentPathSum, prefixSumCount.getOrDefault(currentPathSum, 0) + 1);
   ```

8. **Recurse:**
   - Call the dfs function for the left and right children, passing the updated `currentPathSum`.

9. **Backtrack:**
   - This is the most important step for correctness. After the recursive calls for the children return (meaning we have finished exploring the subtree of the current node), we must remove the `currentPathSum` from the map for the current path. This ensures that when we go back up and traverse a sibling's path, the prefix sums from the current path do not interfere. We do this by decrementing its count:

   ```java
   prefixSumCount.put(currentPathSum, prefixSumCount.get(currentPathSum) - 1);
   ```