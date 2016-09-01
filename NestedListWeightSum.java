/*
 Author:     Minaxi Singla, msingla@usc.edu
 Date:       Sep 01, 2016
 Problem:    Nested List Weight Sum
 Difficulty: Easy
 Source:     https://leetcode.com/problems/nested-list-weight-sum/
 Notes:
 Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 Each element is either an integer, or a list -- whose elements may also be integers or other lists

 Solution: ...
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        if (nestedList == null || nestedList.size()==0)
            return 0;
        
        return parseList(nestedList, 1);
    }
    
    public int parseList(List<NestedInteger> nestedList, int depth){
        if (nestedList == null || nestedList.size()==0)
            return 0;
        
        int sum = 0;
        
        for (NestedInteger curr: nestedList){

            if (curr.isInteger()){
                sum += curr.getInteger() * depth;
            } else {
                sum += parseList(curr.getList(), depth+1);
            }
        }
        
        return sum;
    }
}