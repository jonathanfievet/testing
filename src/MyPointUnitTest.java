package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MyPointUnitTest {

    MyPoint myPointZero;
    MyPoint myPointNumbers;
    MyPoint myPointNaN;

    @BeforeEach
    void setUp() {
        this.myPointZero = new MyPoint();
        this.myPointNumbers = new MyPoint(32d, 20d);
        this.myPointNaN = new MyPoint(Double.NaN, 20d);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetAndSetXNumber() {
        myPointZero.setX(20d);
        assertEquals(20d, myPointZero.getX());
    }

    @Test
    void testGetAndSetXNaN() {
        myPointNumbers.setX(Double.NaN);
        assertEquals(32d, myPointNumbers.getX());
    }

    @Test
    void testGetAndSetYNumber() {
        myPointZero.setY(50d);
        assertEquals(50d, myPointZero.getY());
    }

    @Test
    void testGetAndSetYNaN() {
        myPointNumbers.setY(Double.NaN);
        assertEquals(20d, myPointNumbers.getY());
    }

    @Test
    void testScaleNumber() {
        MyPoint myPointScaled = myPointNumbers.scale(2d);
        assertEquals(64d, myPointScaled.getX());
        assertEquals(40d, myPointScaled.getY());
    }

    @Test
    void testScaleNaN() {
        MyPoint myPointScaled = myPointNaN.scale(3d);

        assertEquals(0d, myPointScaled.getX());
        assertEquals(60d, myPointScaled.getY());
    }

    @Test
    void testScaleZero() {
        MyPoint myPointScaled = myPointNumbers.scale(0d);

        assertEquals(0d, myPointScaled.getX());
        assertEquals(0d, myPointScaled.getY());
    }

    @Test
    void testHorizontalSymmetryPositiveOrigin() {
        MyPoint origin = new MyPoint(20d, 0d);
        MyPoint myPointSymmetry = myPointNumbers.horizontalSymmetry(origin);

        assertEquals(8d, myPointSymmetry.getX());
        assertEquals(20d, myPointSymmetry.getY());
    }

    @Test
    void testHorizontalSymmetryNegativeOrigin() {
        MyPoint origin = new MyPoint(-30d, 0d);
        MyPoint myPointSymmetry = myPointNumbers.horizontalSymmetry(origin);

        assertEquals(-92d, myPointSymmetry.getX());
        assertEquals(20d, myPointSymmetry.getY());
    }

    @Test
    void testHorizontalSymmetryZeroOrigin() {
        MyPoint origin = new MyPoint(0d, 0d);
        MyPoint myPointSymmetry = myPointNumbers.horizontalSymmetry(origin);

        assertEquals(-32d, myPointSymmetry.getX());
        assertEquals(20d, myPointSymmetry.getY());
    }

    @Test
    void testHorizontalSymmetryNullOrigin() {
        assertThrows(IllegalArgumentException.class, () -> {
            myPointNumbers.horizontalSymmetry(null);
        });
    }

    @Test
    void testComputeAngleMoreZero() {
        MyPoint myPointToCompute = new MyPoint(50d, 23d);

        assertEquals(3.306, myPointToCompute.computeAngle(myPointNumbers), 0.001);
    }

    @Test
    void testComputeAngleXZero() {
        MyPoint myPointToCompute = new MyPoint(0d, 23d);

        assertEquals(-0.093, myPointToCompute.computeAngle(myPointNumbers), 0.001);
    }

    @Test
    void testComputeAngleXZeroYLessZero() {
        MyPoint myPointToCompute = new MyPoint(32d, 26d);

        assertEquals(5.235, myPointToCompute.computeAngle(myPointNumbers), 0.001);
    }

    @Test
    void testRotatePointThetaMoreZero() {
        MyPoint myPointToRotate = new MyPoint(2d, 23d);
        MyPoint myPointRotated = myPointToRotate.rotatePoint(myPointNumbers, 10);

        assertEquals(52.275, myPointRotated.getX(), 0.001);
        assertEquals(55.872, myPointRotated.getY(), 0.001);
    }

    @Test
    void testRotatePointThetaLessZero() {
        MyPoint myPointToRotate = new MyPoint(2d, 23d);
        MyPoint myPointRotated = myPointToRotate.rotatePoint(myPointNumbers, -3);

        assertEquals(60.429, myPointRotated.getX(), 0.001);
        assertEquals(45.143, myPointRotated.getY(), 0.001);
    }

    @Test
    void testCentralSymmetryNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            myPointNumbers.centralSymmetry(null);
        });
    }

    @Test
    void testGetMiddlePoint() {
        MyPoint myPointOther = new MyPoint(50d, 40d);
        MyPoint myPointMiddle = myPointNumbers.getMiddlePoint(myPointOther);

        assertEquals(41, myPointMiddle.getX());
        assertEquals(30, myPointMiddle.getY());
    }

    @Test
    void testTranslate() {
        myPointNumbers.translate(2d, 2d);

        assertEquals(34d, myPointNumbers.getX());
        assertEquals(22d, myPointNumbers.getY());
    }

    @Test
    void testConstructor1() {
        assertNotNull(myPointZero);
        assertEquals(0d, myPointZero.getX());
        assertEquals(0d, myPointZero.getY());
    }

    @Test
    void testConstructor2() {
        assertNotNull(myPointNumbers);
        assertEquals(32d, myPointNumbers.getX());
        assertEquals(20d, myPointNumbers.getY());
    }

    @Test
    void testConstructor3NotNull() {
        MyPoint myPointNew = new MyPoint(myPointNumbers);

        assertNotNull(myPointNew);
        assertEquals(32d, myPointNew.getX());
        assertEquals(20d, myPointNew.getY());
    }

    @Test
    void testConstructor3Null() {
        MyPoint myPointNew = new MyPoint(null);

        assertNotNull(myPointNew);
        assertEquals(0d, myPointNew.getX());
        assertEquals(0d, myPointNew.getY());
    }

    @Test
    void testConstructor3NaN() {
        MyPoint myPointNew = new MyPoint(myPointNaN);

        assertNotNull(myPointNew);
        assertEquals(0d, myPointNew.getX());
        assertEquals(20d, myPointNew.getY());
    }
}