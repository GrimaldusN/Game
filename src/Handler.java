import java.util.HashMap;
import java.util.Map;

public class Handler {
    Map<Team, Double> map = new HashMap<>();

    @Override
    public String toString() {
        return "Handler{" +
                "map=" + map +
                '}';
    }
}
