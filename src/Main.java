import com.github.javafaker.Faker;
import dk.brics.automaton.StringUnionOperations;

import java.lang.reflect.Member;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static StringUnionOperations list;

    public static void main(String[] args) {
        Faker faker = new Faker();
        Handler handler = new Handler();
        System.out.println(generator(faker, handler));
        System.out.println(sort(handler));
        System.out.println(play(handler));
        System.out.println(maxScour(handler.map));


    }

    public static Stream<Double> sort(Handler handler){
        return handler.map.entrySet().stream()
                .sorted().map(teamDoubleEntry -> teamDoubleEntry.getValue());
    }

    public static Handler play(Handler handler){
        Random random = new Random();
        int rnd = random.nextInt(2);
        for (Map.Entry<Team, Double> e : handler.map.entrySet() ) {
            if (rnd == 0){
                e.getValue().equals(e.getValue()+1);
            }
            if (rnd==1){
                e.getValue().equals(e.getValue()+0.5);
            }
            else {
                e.getValue().equals(e.getValue()-1);
            }
        }

        return handler;
    }

    public static Set<Adult> generator(Faker faker, Handler handler){
        Random random = new Random();
        int rnd = random.nextInt(21, 45);
        Set<Adult> teams = new HashSet<>();
        Set<Member> members = new HashSet<>();
        while (teams.size()<=25){
            Adult adultTeam = new Adult();
            adultTeam.name = String.valueOf(faker.team());
            for (int i = 0; i < 3; i++) {
                String name = String.valueOf(faker.name());
                Member member = new Member() {
                };
            }
            teams.add(adultTeam);
            handler.map.put(adultTeam, (double) 0);
        }

        return teams;
    }

    public static Set<Teenager> generatorT(Faker faker, Handler handler) {
        Set<Teenager> teams = new HashSet<>();
        Member member = new Member();
        while (teams.size() <= 25) {
            Teenager teenagerTeam = new Teenager();
            teenagerTeam.name = String.valueOf(faker.team());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                 member.name = String.valueOf(faker.name());
            }
            teams.add(teenagerTeam);
            handler.map.put(teenagerTeam, (double) 0);
        }
        return teams;
    }

    public static Set<Pupil> generatorP(Faker faker, Handler handler) {
        Set<Pupil> teams = new HashSet<>();
        Member member = new Member();
        while (teams.size() <= 25) {
            Pupil pupilTeam = new Pupil();
            pupilTeam.name = String.valueOf(faker.team());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                member.name = String.valueOf(faker.name());

            }
            teams.add(pupilTeam);
            handler.map.put(pupilTeam, (double) 0);
        }
        return teams;
    }

    public static Optional<Double> maxScour(Map<Team, Double> map){
        return map.values().stream().max(Double::compareTo);
    }

    public static Optional<Double> sumScour(Map<Team, Double> map){
        return map.values().stream().reduce(Double::sum);
    }

    public static List<Team> listEmplyScours(Map<Team, Double> map){
        return map.keySet().stream()
                .filter(team -> team.scour.equals(0))
                .toList();
    }

//    public static  averageAge(Map<Team, Double> map){
//        return map.keySet().stream()
//                .flatMap(team -> team.list.stream())
//                .;
//    }
}