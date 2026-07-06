class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;

        for(int num : nums){
            if(num == num1){
                count1++;
            } else if(num == num2){
                count2++;
            } else if(count1 == 0){
                count1 = 1;
                num1 = num;
            } else if(count2 == 0){
                count2 = 1;
                num2 = num;
            }else{
                count1--;
                count2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        count1 = count2 = 0;
        for(int num : nums){
            if(num == num1) count1++;
            else if(num == num2) count2++;
        }

        if(count1 > n / 3) res.add(num1);
        if(count2 > n / 3) res.add(num2);

        return res;
    }
    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
}