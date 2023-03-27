import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/*
  Unit test for Piece class -- starter shell.
 */
public class PieceTest {
    // You can create data to be used in the your test cases like this.
    // For each run of a test method, a new PieceTest object is created
    // and setUp() is called automatically by JUnit.
    // For example, the code below sets up some pyramid and s pieces
    // in instance variables that can be used in tests.
    private Piece pyr1, pyr2, pyr3, pyr4;
    private Piece s, sRotated;

    private Piece stick, stickRotated;

    private Piece l1, l12, l13, l14;

    private Piece l2, l22, l23, l24;

    private Piece s2, s2Rotated;

    private Piece square, squareRotated;


    @Before
    public void setUp() {
        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();

        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();

        stick = new Piece(Piece.STICK_STR);
        stickRotated = stick.computeNextRotation();

        l1 = new Piece(Piece.L1_STR);
        l12 = l1.computeNextRotation();
        l13 = l12.computeNextRotation();
        l14 = l13.computeNextRotation();

        l2 = new Piece(Piece.L2_STR);
        l22 = l2.computeNextRotation();
        l23 = l22.computeNextRotation();
        l24 = l23.computeNextRotation();

        s2 = new Piece(Piece.S2_STR);
        s2Rotated = s2.computeNextRotation();

        square = new Piece(Piece.SQUARE_STR);
        squareRotated = square.computeNextRotation();




    }

    // Here are some sample tests to get you started
    @Test
    public void testSampleSize() {
        // Check size of pyr piece
        assertEquals(3, pyr1.getWidth());
        assertEquals(2, pyr1.getHeight());

        // Now try after rotation
        // Effectively we're testing size and rotation code here
        assertEquals(2, pyr2.getWidth());
        assertEquals(3, pyr2.getHeight());

        // Now try with some other piece, made a different way

        assertEquals(1, stick.getWidth());
        assertEquals(4, stick.getHeight());

        assertEquals(2, square.getWidth() );
        assertEquals(2, square.getHeight());

        assertEquals(2, sRotated.getWidth());
        assertEquals(3, sRotated.getHeight());

        assertEquals(2, s2Rotated.getWidth());
        assertEquals(3, s2Rotated.getHeight());
    }


    // Test the skirt returned by a few pieces
    @Test
    public void testSampleSkirt() {
        // Note must use assertTrue(Arrays.equals(... as plain .equals does not work
        // right for arrays.
        assertTrue(Arrays.equals(new int[]{0, 0, 0}, pyr1.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0, 1}, pyr3.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0, 0, 1}, s.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0}, sRotated.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0}, stick.getSkirt()));
        assertTrue(Arrays.equals(new int[]{0, 0, 0, 0}, stickRotated.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0, 0, 1}, s.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0}, sRotated.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0, 0}, square.getSkirt()));
        assertTrue(Arrays.equals(new int[]{0, 0}, squareRotated.getSkirt()));




    }


    @Test
    public void testFastRotation_Equals() {
        Piece[] piecesArray = new Piece[]{
                new Piece(Piece.STICK_STR),
                new Piece(Piece.L1_STR),
                new Piece(Piece.L2_STR),
                new Piece(Piece.S1_STR),
                new Piece(Piece.S2_STR),
                new Piece(Piece.SQUARE_STR),
                new Piece(Piece.PYRAMID_STR)
        };



        assertTrue(!piecesArray[1].fastRotation().equals(piecesArray[1]));
        assertTrue(!piecesArray[2].fastRotation().equals(piecesArray[2]));
        assertTrue(!piecesArray[3].fastRotation().equals(piecesArray[3]));
        assertTrue(!piecesArray[4].fastRotation().equals(piecesArray[4]));
        assertTrue(!piecesArray[6].fastRotation().equals(piecesArray[6]));


        assertTrue(!piecesArray[1].fastRotation().fastRotation().equals(piecesArray[1]));
        assertTrue(!piecesArray[2].fastRotation().fastRotation().equals(piecesArray[2]));
        assertTrue(!piecesArray[6].fastRotation().fastRotation().equals(piecesArray[6]));

        assertTrue(!piecesArray[1].fastRotation().fastRotation().fastRotation().equals(piecesArray[1]));
        assertTrue(!piecesArray[2].fastRotation().fastRotation().fastRotation().equals(piecesArray[2]));
        assertTrue(!piecesArray[6].fastRotation().fastRotation().fastRotation().equals(piecesArray[6]));

        }
}
