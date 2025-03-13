import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    private Address address1;
    private Address address2;
    private Address address3;

    @BeforeEach
    void setUp() {
        address1 = new Address("Main St", "123", "444");
        address2 = new Address("Main St", "123", "444");
        address3 = new Address("Elm St", "456", "777");
    }

    @Test
    void getFullAddress() {
        assertEquals("Main St 123 444", address1.getFullAddress());
    }

    @Test
    void testToString() {
        assertEquals("Main St 123 444", address1.toString());
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(address1, address1);
    }

    @Test
    void testEquals_DifferentObjectsSameData() {
        assertEquals(address1, address2);
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    void testEquals_DifferentObjectsDifferentData() {
        assertNotEquals(address1, address3);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        assertEquals(address1.hashCode(), address2.hashCode());
        assertNotEquals(address1.hashCode(), address3.hashCode());
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(address1.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(address1.equals("Some String"));
    }
}
