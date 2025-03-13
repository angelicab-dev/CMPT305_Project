import java.util.Objects;

/**
 * Represents a full address: suit, house number, and street.
 */
public class Address {
    private String fullAddress;

    /**
     * Concatenate the full address using suit, house number, and the street.
     * @param suit The suit of the address, column 2 in the csv.
     * @param houseNumber The house number of the address, column 3 in the csv.
     * @param street The street of the address, column 4 in the csv.
     */
    public Address(String suit, String houseNumber, String street) {
        this.fullAddress = (suit + " " + houseNumber + " " + street).trim();
    }

    /**
     * Returns full address as one string.
     * @return the concatenated address.
     */
    public String getFullAddress() {
        return fullAddress;
    }

    @Override
    public String toString() {
        return fullAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(fullAddress, address.fullAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullAddress);
    }
}
