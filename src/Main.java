import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] passNum = {0, 0, 1};
        new Solution().moveZeroes(passNum);
    }
}

// best solution
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num:nums){ // loops through array
            if(num != 0){ // if not 0
                nums[i] = num; // value assigned to index 0,1,2, etc.
                i++; //increments i to designate the next index only when not 0 val
            }
        }
        while(i<nums.length){ // but i also serves as the indeex for 0's to begin when no further non-0 values found
            // i becomes a maximum oof final index and assigns 0 to all indexes aftere last non-0 val
            nums[i] = 0;
            i++;
        }
    }
}

// working solution
/*
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int loopEnd = 0;
        while (i < nums.length && loopEnd<nums.length) {
            loopEnd++;
            if (nums[i] == 0) { // if zero found
                reIndex(nums, i);// re-index, returns mutated array

            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private int[] reIndex(int[] mod, int startIndex) {
        for (int j = startIndex; j < mod.length - 1; j++) { // need to assign zero to last index, so we need to ultimatley
            // obtain the second to last index, copy value of last index to second to last, then make the last index val 0
            // < length obtains last index, so second to last index is  <length -1
            mod[j] = mod[j + 1]; // supposing length of 5 (max index 4), length 5-1 = 4. < 4 = index 3. j = 3 so
            // mod[3 = mod[4] (second to last = last)
        }
        mod[mod.length - 1] = 0; // last index assigned to 0

        return mod;
    }
}