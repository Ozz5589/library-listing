# Library Listing

A simple Java Maven project for managing product listings with multiple quantities.  
This project supports listing items with stock counts, reducing quantity after sales, and marking listings as **Sold Out** when inventory reaches zero.

## User Story Covered

**As a seller, I want to list multiple quantities so that I can sell more than one item.**

### Acceptance Criteria
- Seller can define quantity > 1
- Quantity decreases after each sale
- Listing auto-updates when stock reaches 0
- Listing is marked **Sold Out** when empty

---

## Features

- Create a listing with an initial quantity
- Sell one item at a time
- Automatically update sold-out status
- Prevent selling items after stock reaches zero
- Unit tests using JUnit 5
- GitHub Actions workflow for automatic test execution on push

---

## Project Structure

```text
library-listing/
├── .github/
│   └── workflows/
│       └── maven-tests.yml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Listing.java
│   └── test/
│       └── java/
│           └── ListingTest.java
├── pom.xml
└── README.md
```

---

## Technologies Used

- Java
- Maven
- JUnit 5
- GitHub Actions

---

## How It Works

### `Listing.java`
Represents a listing with:
- `title`
- `quantity`
- `soldOut` status

### Key Behavior
- A listing must start with a quantity of at least 1
- Each call to `sellOne()` reduces quantity by 1
- When quantity reaches 0, the listing is marked sold out
- If a sale is attempted after stock is gone, the program throws an exception

---

## Unit Tests

The project includes two JUnit tests:

1. **testQuantityDecreasesAndSoldOutFlag**
   - Verifies quantity decreases after each sale
   - Verifies the listing becomes sold out when quantity reaches 0
   - Verifies an exception is thrown when trying to sell a sold-out listing

2. **testCannotInitializeQuantityLessThanOne**
   - Verifies that a listing cannot be created with quantity less than 1

---

## Running the Tests

From the project root, run: 
```bash
mvn clean test
