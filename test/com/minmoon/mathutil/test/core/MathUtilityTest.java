package com.minmoon.mathutil.test.core;

import com.minmoon.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mint_leo
 */
public class MathUtilityTest {    
    //đây là class sẽ sử dụng các hàm của thư viên/framework JUnit
    //để kiểm tra/kiểm thử code chính - hàm tinhsGiaThua() bên
    //class core.MathUtil
    //viết code để test code chính bên kia
    
    //có nhiều quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ là nói lên mục đích của các case kiểm thử
    //tình huống xài hàm theo kiểu thành ông và thất bại
    
    //hàm dưới đây là tính huống tesst hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5!, 6!, ko chơi -5!, 301
    
    //@Test JUnit sẽ phối hợp với JVM để chạy hàm này
    //@Test phía hậu trường chính là public static void main()
    //có nhiều @Test ứng với nhiều case khác nhau
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0; //test thử tình huống đầu vào tử tế, chạy đúng
        long expexted = 1;
        long actual = MathUtil.getFactorial(n);//gọi hàm cần test bên core
        Assert.assertEquals(expexted, actual);
        
        //gộp thêm vài case thành công nữa
        Assert.assertEquals(1, MathUtil.getFactorial(1));
        Assert.assertEquals(2, MathUtil.getFactorial(2));
        Assert.assertEquals(6, MathUtil.getFactorial(3));
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        Assert.assertEquals(120, MathUtil.getFactorial(5));
        Assert.assertEquals(720, MathUtil.getFactorial(6));
    }
    
    //đưa data cà chớn: âm, > 20; thiết kế hàm là ném ra ngoại lệ
    //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆ KHI N < 0 || N > 20
    //rất mong ngoại lệ xuất hiện vơi sn cà chớn này
    //nếu nhận vào n < 0 || n > 20 và hàm ném ra ngọa lệ
    //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ -> XANH P XUẤT HIỆN
     
    //TEST CASE:
    //input: -5
    //expected: IllegalArgumentException xuất hiện
    //tình huống bất thường, ngoại lệ là những thứ
    //ko thể ss theo kiểu value mfa chỉ có thể
    //đo lường = cách chúng có xuất hiện hay ko
    //assertEquals() ko dùng để ss 2 ngoại lệ, chỉ ss treenn value
    //test case failed
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException() {
//        MathUtil.getFactorial(-5); //hàm @Test chạy, hay hàm getF() chạy
//        //sẽ ném về ngoại lệ NumberFormat...
//    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5); //hàm @Test chạy, hay hàm getF() chạy
        //sẽ ném về ngoại lệ NumberFormat...
    }
    //cách khác để bắt ngoại lệ, vt tự nhiên hơn
    
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_LambdaVersion() {
//        Assert.assertThrows(tham số 1: loại ngoại lệ muốn ss
//                            tham số 2: đoạn code chạy văng ra ngoại runnable);
    Assert.assertThrows(IllegalArgumentException.class, 
                    () -> MathUtil.getFactorial(-5)
            );
    }
    
    //bắt ngoại lệ, xem hàm có ném về ngoại lệ hya ko khi n cà chớn
    //có ném, tức là hàm chạy đúng thiết kế -> xanh
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_TryCatch() {
    //chủ động kiểm soát ngoại lệ
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bắt try-catch là JUnit sẽ ra màu xanh do đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko
            //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException
            Assert.assertEquals("Invalid argumnent. N must be from 0 to 20", e.getMessage());
        }
    
    }
    
}
