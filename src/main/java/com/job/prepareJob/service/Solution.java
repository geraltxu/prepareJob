package com.job.prepareJob.service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public ListNode question1(int num,int count){
        ListNode head = new ListNode(1);
        ListNode start = head;
        for(int i=2;i<=num;i++){
            head.next = new ListNode(i);
            head = head.next;
            if(i==num){
                head.next = start;
            }
        }
        return start;
    }

    public String result(String input){
       // Stack<String> stack = new Stack<>();
        String[] s1 = input.split("#");
        String re="";
        String res = "";
        for(int i=0;i<s1.length;i++){
            if(s1[i].contains("$")){
                String[] s2 = s1[i].split("\\$");
                for(int j=0;j<s2.length;j++){
                    if(j<=1){
                        re = op2(s2[0],s2[1]);
                    }else{
                        re = op2(re,s2[j]);
                    }
                }
                s1[i] = re;
            }
        }
        for(int i=0;i<s1.length;i++){
            if(i<=1){
                res = op1(s1[0],s1[1]);
            }else{
                res = op1(res,s1[i]);
            }
        }
        return res;
    }
    public String op1(String i1, String i2){
        int s1= Integer.parseInt(i1);
        int s2 = Integer.parseInt(i2);
        int result = 2*s1+3*s2+4;
        return result+"";
    }

    public String op2(String i1, String i2){
        int s1= Integer.parseInt(i1);
        int s2 = Integer.parseInt(i2);
        int result = 3*s1+s2+2;
        return result+"";
    }


    public String getKQue(int n, int k){
        int[] i1 = new int[n];
        i1[0] = 1;
        for(int i=1;i<n;++i){
            i1[i] = i1[i-1]*i;
        }
        --k;
        StringBuffer ans = new StringBuffer();
        int[] i2 = new int[n+1];
        Arrays.fill(i2,1);
        for(int i = 1; i<=n; ++i){
            int order = k/i1[n-i]+1;
            for(int j = 1; j <=n; ++j){
                order -= i2[j];
                if(order == 0){
                    ans.append(j);
                    i2[j]=0;
                    break;
                }
            }
            k%=i1[n-i];
        }
        return ans.toString();
    }

    public boolean isMatch(String s, String p){
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for(int i = 0; i<=m ; ++i){
            for(int j = 1; j<=n; ++j){
                if(p.charAt(j-1)=='*'){
                    f[i][j] = f[i][j-2];
                    if(match(s,p,i,j-1)){
                        f[i][j] = f[i][j]||f[i-1][j];
                    }
                }else{
                    if(match(s,p,i,j)){
                        f[i][j] = f[i-1][j-1];
                    }
                }
            }
        }
        return f[m][n];
    }
    public boolean match(String s, String p, int i, int j){
        if(i==0) return false;
        if(p.charAt(j-1)=='.') return true;
        return s.charAt(i-1) == p.charAt(j-1);
    }

    public static void main(String[] args) {
        Solution m = new Solution();
//        int i=5;
//        ListNode list = s.question1(5,0);
//        while(i>=0){
//            System.out.println(list.val+"-->");
//            list=list.next;
//            i--;
//        }
//        String ss = "7#6$5$3";
//        System.out.println(s.result(ss));
//        Scanner sss = new Scanner(System.in);
//        String input = sss.next();
//        System.out.println(s.getKQue(3,3));
        Scanner s = new Scanner(System.in);
        String inputS = s.nextLine();
        System.out.println("请输入字符");
        Scanner s2 = new Scanner(System.in);
        String inputP = s2.next();
        String[] input = inputS.split(" ");
        for(int i=0;i<input.length;i++) {
            if (m.isMatch(input[i], inputP)) {
                System.out.print(i + ",");
            }
        }
    }
}
