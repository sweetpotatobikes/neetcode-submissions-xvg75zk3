class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] arr = s.toLowerCase().toCharArray();

        while (left < right) {
            System.out.println("arr[left] is " + arr[left] + " and arr[right] is " + arr[right]);
            if (!Character.isLetterOrDigit(arr[left])) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[right])) {
                right--;
                continue;
            }
            else if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
