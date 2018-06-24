import java.util.Objects;

public class Key {

    private final String a;
    private final String b;
    private final String c;

    public Key(int index) {
        this.a = "A_"+index;
        this.b = "B_"+index;
        this.c = "C_"+index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(a, key.a) &&
                Objects.equals(b, key.b) &&
                Objects.equals(c, key.c);
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Key{");
        sb.append("a='").append(a).append('\'');
        sb.append(", b='").append(b).append('\'');
        sb.append(", c='").append(c).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
