
package com.minmoon.mathutil.main;

import com.minmoon.mathutil.core.MathUtil;

/**
 *
 * @author mint_leo
 */
public class Main {
    public static void main(String[] args) {
        //thử nghiệm hàm tính giai thừa coi chạy đúng như thiết kế ko
        //ta p đưa các tính huống sử dụng hàm trong thực tế
        //vd: đưa vào -5, 0, 20, 21 
        //=> TEST CASE: một tình huống hàm, app đc đưa vào sử dụng
        //giả lập hành vi xài của ai đó gồm có
        //data đầu vào và output đầu ra
        //so sánh để xem kết quả (Actual) có như kì vọng(Expected) hay ko
        
        long expected = 120;
        int n = 5;
        long actual = MathUtil.getFactorial(5);
        System.out.println("5! = " + expected + " expected");
        System.out.println("5! = " + actual + " actual");
    }   
    
}
