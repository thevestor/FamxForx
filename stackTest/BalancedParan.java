/*********************************************************************************************************
*  Copyright (c) 2020 FamxForx. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <s1074862962@gmail.com> or <s1074862962@163.com>                                                 
*                                                                                                        
*  FileName:  BalancedParan                                                                         
*  Author:  FamxForx                                                                                     
*  Version:  2.2                                                                                         
*  Date:  2020                                                                                     
*  Title: paranthesis are balanced                                                              
*  Others:                                                                                                                                                    
**********************************************************************************************************/
package test;

import java.util.*;
public class BalancedParan {

	/**
	 * @brief function to check if paranthesis are balanced 
	 * @author FamxForx
	 * @param expr
	 * @return
	 */
    static boolean areParanthesisBalanced(String expr) 
    { 
        // Using ArrayDeque is faster than using Stack class 
        Deque<Character> stack = new ArrayDeque<Character>(); 
  
        // Traversing the Expression 
        for (int i = 0; i < expr.length(); i++) { 
            char x = expr.charAt(i); 
  
            if (x == '(' || x == '[' || x == '{') { 
                // Push the element in the stack 
                stack.push(x); 
                continue; 
            } 
  
            // IF current current character is not opening 
            // bracket, then it must be closing. So stack 
            // cannot be empty at this point. 
            if (stack.isEmpty()) 
                return false; 
  
            switch (x) { 
            case ')': 
                stack.pop(); 
                if (x == '{' || x == '[') 
                    return false; 
                break; 
  
            case '}': 
                stack.pop(); 
                if (x == '(' || x == '[') 
                    return false; 
                break; 
  
            case ']': 
                stack.pop(); 
                if (x == '(' || x == '{') 
                    return false; 
                break; 
            } 
        } 
  
        // Check Empty Stack 
        return (stack.isEmpty()); 
    } 
  
    /**
     * @brief driver program to test above functions
     * @author FamxForx
     * @param args
     */
    public static void main(String[] args) 
    { 
        //String expr = "([{}])"; 
        System.out.println("ÇëÊäÈëÀ¨ºÅ½á¹¹¡£¡£¡£");
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        String expr = scan.next();
        if (areParanthesisBalanced(expr)) 
            System.out.println("Balanced "); 
        else
            System.out.println("Not Balanced "); 
    } 

}
