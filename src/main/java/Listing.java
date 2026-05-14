public class Listing {
    private String title;
    private int quantity;
    private boolean soldOut;

    public Listing(String title, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1");
        }
        this.title = title;
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