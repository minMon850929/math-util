package com.minmoon.mathutil.test.core;

import com.minmoon.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author mint_leo
 */
//câu lệnh này là của JUnit báo hiệu rằng sẽ cần loop qua tập data để
//lấy cặp input/expected nhồi vào hàm test
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {

    //ta sẽ trả về mảng 2 chiều gồm nhiều cặp Expected|Input
    @Parameterized.Parameters //JUnit ngầm chạy loop qua từng dòng
    //của mảng để lấy ra đc cắp data input/expected
    //tên hàm k qtrong, qtrong là @
    public static Object[][] initData() {

        return new Integer[][]{
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
            {6, 720}
        };
    }

    //giả sử loop qua từng dòng của mảng, ta vẫn cần gán từng value của cột
    //vào biến tương ứng input, expected để lát hồi feed cho hàm
    @Parameterized.Parameter(value = 0)//value = 0 là map với mảng data
    public int n; //biến map với value của cột 0 của mảng
    @Parameterized.Parameter(value = 1)
    public long expected; //kiểu trả về của hàm getF() là long

    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException() throws IllegalAccessException {
        Assert.assertEquals(expected, MathUtil.getFactorial(n));

    }
}
