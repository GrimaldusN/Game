import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Stream;

public abstract class Team {
    String name;

    List<Member> list;
    Double scour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getList() {
        return list;
    }

    public void setList(List<Member> list) {
        this.list = list;
    }

    public Double getScour() {
        return scour;
    }

    public void setScour(Double scour) {
        this.scour = scour;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", scour=" + scour +
                '}';
    }
}
