package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import lib.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyPointIntegrationTest {

    MyPoint myPoint;
    ITranslation iTranslation;

    @Mock Random random1;
    @Mock Random random2;

    @BeforeEach
    void setUp() {
        myPoint = new MyPoint();
        iTranslation = mock(ITranslation.class);

        when(iTranslation.getTx()).thenReturn(50);
        when(iTranslation.getTy()).thenReturn(24);

        when(random1.nextInt()).thenReturn(32);
        when(random2.nextInt()).thenReturn(20);
    }

    @Test
    void testSetPointRandomMock() {
        myPoint.setPoint(random1, random2);

        assertEquals(32, myPoint.getX());
        assertEquals(20, myPoint.getY());
    }

    @Test
    void testTranslateMock() {
        myPoint.translate(iTranslation);

        assertEquals(50, myPoint.getX());
        assertEquals(24, myPoint.getY());
    }
}
