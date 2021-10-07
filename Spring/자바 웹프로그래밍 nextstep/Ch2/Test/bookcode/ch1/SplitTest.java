package bookcode.ch1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SplitTest {
    @Test
    public void split(){
        assertArrayEquals(new String[] {"1"},"1".split(",") );
        assertArrayEquals(new String[] {"1","2"},"1,2".split(","));
    }


}
