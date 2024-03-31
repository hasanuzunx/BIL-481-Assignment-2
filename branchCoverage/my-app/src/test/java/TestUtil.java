import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestUtil {

  @Test
  public void test1() { // Tek bir argümanın compute metodunda input olması durumunda false dönmeli.
    Util util = new Util();
    assertFalse(util.compute(5));
  }

  @Test
  public void test2() { //Çift sayıda inputun compute metoduna geçirilmesi durumunda false dönmeli
    Util util = new Util();
    assertFalse(util.compute(2, 4, 6, 8));
  }

  @Test(expected = RuntimeException.class)
  public void test3() { // inputlarda 0 varsa error atmalı
    Util util = new Util();
    util.compute(2, 0, 4);
  }

  @Test
  public void test4() { // inputların toplamı, en az 1 inputlara tam bölünmüyorsa true dönmeli
    Util util = new Util();
    assertTrue(util.compute(3, 4, 5)); 
  }

  @Test
  public void test5() { // inputların toplamı bütün inputlara tam bölünmüyorsa false dönmeli.
    Util util = new Util();
    assertFalse(util.compute(3, 4, 6));
  }
}