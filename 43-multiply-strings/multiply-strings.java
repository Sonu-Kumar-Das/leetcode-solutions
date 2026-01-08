class Solution {
    public String multiply(String num1, String num2) {
         if (num1.equals("0") || num2.equals("0")) return "0";

        int n = num1.length(), m = num2.length();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) a[i] = num1.charAt(i) - '0';
        for (int j = 0; j < m; j++) b[j] = num2.charAt(j) - '0';

        int[] res = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int ai = a[i];
            int base = i + 1;
            for (int j = m - 1; j >= 0; j--) {
                res[base + j] += ai * b[j];
            }
        }

        for (int k = res.length - 1; k > 0; k--) {
            int carry = res[k] / 10;
            res[k] -= carry * 10;
            res[k - 1] += carry;
        }

        int start = 0;
        while (start < res.length && res[start] == 0) start++;

        StringBuilder sb = new StringBuilder(res.length - start);
        for (int i = start; i < res.length; i++) sb.append((char) ('0' + res[i]));
        return sb.toString();
    }
}