package Stack;

import java.util.Stack;

public class PreviousGreaterInStack {
    public static void main(String[] args) {
        int [] arr ={4,5,10,2,8 };
        int [] result = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stk.isEmpty() && stk.peek()>=arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                result[i]= -1;
            }else{
                result[i]= stk.peek();
            }
            stk.push(arr[i]);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }
}
