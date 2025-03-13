import java.util.Objects;

/**
 * Represents the neighbourhood with the name and ward.
 */
public class Neighbourhood {
    private String name;
    private String ward;

    /**
     * Makes a Neighbourhood object with the name and ward.
     * @param name Name of the neighbourhood.
     * @param ward Name of the ward.
     */
    public Neighbourhood(String name, String ward) {
        this.name = name.trim();
        this.ward = ward.trim();
    }

    /**
     * Returns the name of the neighbourhood.
     * @return A trimmed name of the neighbourhood.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the name of the ward.
     * @return A trimmed name of the ward.
     */
    public String getWard() {
        return ward;
    }

    @Override
    public String toString() {
        return name + " (" + ward + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbourhood that = (Neighbourhood) o;
        return Objects.equals(name, that.name) && Objects.equals(ward, that.ward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ward);
    }
}
