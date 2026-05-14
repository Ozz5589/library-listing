public class Listing {
    private int quantity;
    private boolean soldOut;

    public Listing(String ignoredTitle, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1");
        }
        this.quantity = quantity;
        updateStatus();
    }

    public void sellOne() {
        if (soldOut) {
            throw new IllegalStateException("Listing is sold out");
        }
        quantity--;
        updateStatus();
    }

    private void updateStatus() {
        soldOut = (quantity <= 0);
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

}