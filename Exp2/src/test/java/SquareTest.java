import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SquareTest {

    @Test
    public void testComputeAreaSquare() {
        Square square = new Square(5);
        assertEquals(25, square.computeArea());
    }

}