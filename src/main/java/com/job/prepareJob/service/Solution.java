package com.job.prepareJob.service;

import java.util.*;

public class Solution extends Thread{
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
        StringBuilder ans = new StringBuilder();
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

    public int maxSub(int[] nums){
        int res = nums[0];
        for(int i=1; i<nums.length;i++){
            nums[i]+=Math.max(nums[i-1],0);
            res=Math.max(res,nums[i]);
        }
        return res;
    }

    public int lengthOF(int[] nums){
        int len=1, n=nums.length;
        if(n==0){
            return 0;
        }
        int[] test = new int[n+1];
        for(int i=1;i<n;++i){
            if(nums[i]>test[len]){
                test[++len] = nums[i];
            }else{
                int l=1,r=len,pos=0;
                while(l<=r){
                    int mid =(r+l)>>1;
                    if(test[mid] < nums[i]){
                        pos = mid;
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                test[pos+1] = nums[i];
            }
        }
        return len;
    }
    public String changeString(String input){

        String s1="";
        String s2="";
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='*'){
                s1+=input.charAt(i);
            }else{
                s2+=input.charAt(i);
            }
        }

        return s1+s2;
    }

    public String reserveS(String input){
        String result = null;
        char[] s = input.toCharArray();
        int n = s.length;
        for(int left=0,right=n-1;left<right;++left,--right){
            char temp=s[left];
            s[left] = s[right];
            s[right] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(char ss:s){
            sb.append(ss);
        }
        return sb.toString();
//        Stack<String> stack = new Stack<>();
//        for(String s : input){
//            stack.push(s);
//        }
//        String[] result = new String[input.length];
//        for(int i=0;i<input.length;i++){
//            result[i]=stack.pop();
//        }
//        return result;
    }

    public boolean match(String s, String p, int i, int j){
        if(i==0) return false;
        if(p.charAt(j-1)=='.') return true;
        return s.charAt(i-1) == p.charAt(j-1);
    }
    public List<Integer> longTime(int[] input){
//        int[] res = new int[input.length];
        List<Integer> res = new ArrayList<>();
        int sum=0;
        sum=this.doSum(input);

        if(sum>0){
            for(int x:input){
                res.add(x);
            }
            return res;
        }else if(sum<0){
            for(int i=input.length-1;i>=0;i--){
                sum=checkSum(input[i],sum);
                if(sum>0){
                    int j=0;
                    while(j<=i){
                        res.add(input[j]);
                        j++;
                    }
                }else{
                    continue;
                }
            }
        }else{
            if(input[0]<80){
                for(int i=0;i<input.length-1;i++){
                    res.add(input[i+1]);
                }
            }else{
                for(int i=0;i<input.length-1;i++){
                    res.add(input[i]);
                }
            }
        }
        return res;
    }
    public int doSum(int[] input){
        int sum=0;
        for(int i=0;i<input.length;i++){
            if(input[i]>=80){
                sum += 1;
            }else{
                sum -= 1;
            }
        }
        return sum;
    }
    public int checkSum(int x, int sum){
        if(x>=80){
            sum-=1;
        }else{
            sum+=1;
        }
        return sum;
    }
    public void run(){
        System.out.println(this.getKQue(10,5));
    }
    public static int cnt;

    public static void solution(int[]arr,boolean[] flag,int tar,int start,ArrayList<Integer>temp){

        if(tar==0)
        {
            cnt++;
            return;
        }

        for(int i=start;i<arr.length;i++)
        {
            if(arr[i]>tar)
                continue;
            if(i!=0&&arr[i]==arr[i-1]&&!flag[i-1])
                continue;
            temp.add(arr[i]);
            flag[i]=true;

            solution(arr,flag,tar-arr[i],i+1,temp);

            flag[i]=false;
            temp.remove(temp.size()-1);
        }
    }
    public boolean checkS(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        String flag = s2+s2;
        return flag.contains(s1);
    }

    public Stack<Integer> reverseStack(Stack<Integer> stack){
        Stack<Integer> res = new Stack<>();
        int n=stack.size();
        ListNode node = new ListNode(stack.pop());
       for(int i=1;i<n-1;i++){
           node.next= new ListNode(stack.pop());
           node=node.next;
       }
        while(node==null){
            res.push(node.val);
            node = node.next;
        }
        return res;
    }

    public int helper(Stack<Integer> stack){
        int res = stack.pop();
        if(stack.isEmpty()){
            return res;
        }else{
            int last = helper(stack);
            stack.push(res);
            return last;
        }

    }

    public String addString(String num1,String num2){
        int i = num1.length()-1;
        int j = num2.length()-1;
        int flag = 0;
        StringBuilder ans = new StringBuilder();
        while(i>=0||j>=0||flag!=0){
            int x = i>=0?num1.charAt(i)-'0':0;
            int y = j>=0?num2.charAt(j)-'0':0;
            int result=0;
            x=x+flag;
            if(x<y){
                result = 10+x-y;
                flag=-1;
            }else{
                result = x-y;
                flag=0;
            }
            ans.append(result);
//            flag = result/10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public String[] findSorted(String[] input){
        int n=input.length;
        List<String> list = new ArrayList<>();

        String[] res = new String[n];
        String start = input[0];
        list.add(start);
        String[] s1 = input[0].split("->");
        String flag=s1[1];
        for(int i=1;i<n;i++){
            String[] s2 = input[i].split("->");
            if(s2[0].equals(flag)){
                flag = s2[1];
                list.add(input[i]);
                i=0;
            }else{
                continue;
            }
        }
        for(int i=0;i<n;i++){
            res[i]=list.get(i);
        }
        return res;
    }

    public int fip(int i){
        if (i < 0) {
            return -1;
        } else if (i == 0) {
            return 0;
        } else if (i == 1 || i == 2) {
            return 1;
        } else {
            return fip(i - 1) + fip(i - 2);
        }
    }

    public ArrayList<Map.Entry<String,Integer>> hashMapSort(HashMap<String,Integer> map){
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue())-(o2.getValue());
            }
        });
        return list;
    }
    Random random = new Random();
    public int findKthLargest(int[] nums, int k){
        return helper(nums,0,nums.length-1,nums.length-k);
    }
    public int helper(int[] a,int l, int r, int index){
        int rand = randomPartition(a,l,r);
        if(rand == index){
            return a[rand];
        }else{
            return rand<index?helper(a,rand+1,r,index):helper(a,l,rand-1,index);
        }
    }
    public int randomPartition(int[] a,int l, int r){
        int i = random.nextInt(r-l+1)+1;
        swap(a,i,r);
        return partition(a,l,r);
    }
    public int partition(int[] a, int l, int r){
        int x = a[r], i = l-1;
        for(int j=l;j<r;++j){
            if(a[j]<=x){
                swap(a,++i,j);
            }
        }
        swap(a,i+1,r);
        return i+1;
    }
    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws InterruptedException {
        Solution m = new Solution();
        String[] input = {"Shanghai->Beijing","New York->Sydney","Beijing->London","London->New York","Sydney->Shanghai"};
//        String result = m1.reserveS("school");
//        System.out.println(result);
        int[] nums = {3,4,1,2,5};
        System.out.println(m.findKthLargest(nums,2));
//        String[] res = m.findSorted(input);
//        for(String s:res){
//            System.out.println(s);
//        }
//        System.out.println(m1.checkS("abcde","cdeab`"));
//        Solution m2 = new Solution();


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
//        m1.run();
        m.run();
        System.out.println(m.getKQue(9,7));
//        Scanner s = new Scanner(System.in);
//        String inputS = s.nextLine();
//        System.out.println("请输入字符");
//        Scanner s2 = new Scanner(System.in);
//        String inputP = s2.next();
//        String[] input = inputS.split(" ");
//        for(int i=0;i<input.length;i++) {
//            if (m.isMatch(input[i], inputP)) {
//                System.out.print(i + ",");
//            }
//        }
//        int[] input = new int[]{0,90,90,90,0,60,60,90};
//        int[] input2 = new int[]{60,90,0,90,60};
//        for(int x:m1.longTime(input2)){
//            System.out.print(x+",");
//        }
        //System.out.println(m1.changeString("*c*b*a*d"));


//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        int[] arr=new int[a];
//        for(int i=0;i<a;i++)
//        {
//            arr[i]=in.nextInt();
//        }
//        ArrayList<Integer> temp=new ArrayList<>();
//        boolean [] flag=new boolean[a];
//        int tar=24;
//        Arrays.sort(arr);
//        solution(arr,flag,24,0,temp);
//
//        System.out.println(cnt);
    }
}
