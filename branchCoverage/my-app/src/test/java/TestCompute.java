import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestCompute {
  Compute c;
  MessageQueue mq;

  @Before
  public void setUp() {
    // Mock bir MessageQueue oluşturulur ve Compute sınıfına bu mock nesnesi ile birlikte başlatılır.
    mq = mock(MessageQueue.class);
    c = new Compute(mq);
  }

  @Test
  public void test1() {
    // Kuyruk boş olduğunda, countNumberOfOccurrences metodunun -1 döndürmesi gerektiğini kontrol eder.
    when(mq.size()).thenReturn(0);
    assertEquals(-1, c.countNumberOfOccurrences("test"));
  }

  @Test
  public void test2() {
    // Aranan öğe kuyrukta bulunmadığında, countNumberOfOccurrences metodunun 0 döndürmesi gerektiğini kontrol eder.
    when(mq.size()).thenReturn(3);
    when(mq.contains("test")).thenReturn(false);
    assertEquals(0, c.countNumberOfOccurrences("test"));
  }

  @Test
  public void test3() {
    // Aranan öğe kuyrukta bir kez bulunduğunda, countNumberOfOccurrences metodunun 1 döndürmesi gerektiğini kontrol eder.
    when(mq.size()).thenReturn(3);
    when(mq.contains("test")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("test");
    when(mq.getAt(1)).thenReturn("other");
    when(mq.getAt(2)).thenReturn("another");
    assertEquals(1, c.countNumberOfOccurrences("test"));
  }

  @Test
  public void test4() {
    // Aranan öğe kuyrukta birden fazla kez bulunduğunda, countNumberOfOccurrences metodunun doğru sayıda döndürmesini kontrol eder.
    when(mq.size()).thenReturn(5);
    when(mq.contains("test")).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn("test");
    assertEquals(5, c.countNumberOfOccurrences("test"));
  
  }  


}