import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void setHeight() {
        Rectangle rectangle = new Rectangle(2, 4);
        rectangle.setHeight(6);
        assertEquals(6, rectangle.getHeight());
    }

    @Test
    void setWidth() {
        Rectangle rectangle = new Rectangle(3, 5);
        rectangle.setWidth(4);
        assertEquals(4, rectangle.getWidth());
    }

    @Test
    void getHeight() {
        Rectangle rectangle = new Rectangle(14, 17);
        assertEquals(14, rectangle.getHeight());
    }

    @Test
    void getWidth() {
        Rectangle rectangle = new Rectangle(23, 24);
        assertEquals(24, rectangle.getWidth());
    }

    @Test
    void computeArea() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(12, rectangle.computeArea());
    }

    @Test
    public void testSetAndGet() {
        Rectangle rectangle = new Rectangle(6, 10);
        rectangle.setHeight(8);
        rectangle.setWidth(13);
        assertEquals(8, rectangle.getHeight());
        assertEquals(13, rectangle.getWidth());
    }
}