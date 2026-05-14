import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListingTest {

    @Test
    public void testQuantityDecreasesAndSoldOutFlag() {
        Listing listing = new Listing("Test Product", 3);
        assertFalse(listing.isSoldOut());
        assertEquals(3, listing.getQuantity());

        listing.sellOne();
        assertEquals(2, listing.getQuantity());
        assertFalse(listing.isSoldOut());

        listing.sellOne();
        assertEquals(1, listing.getQuantity());
        assertFalse(listing.isSoldOut());

        listing.sellOne();
        assertEquals(0, listing.getQuantity());
        assertTrue(listing.isSoldOut());

        Exception exception = assertThrows(IllegalStateException.class, listing::sellOne);
        assertEquals("Listing is sold out", exception.getMessage());
    }

    @Test
    public void testCannotInitializeQuantityLessThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -&gt; new Listing("Invalid Product", 0));
        assertEquals("Quantity must be at least 1", exception.getMessage());
    }
}