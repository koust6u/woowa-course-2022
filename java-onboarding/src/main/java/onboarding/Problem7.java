package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriends = findUserFriend(user, friends);
        Map<String, Integer> points = calculatePoints(user, friends, myFriends);
        calculateVisitors(points, visitors);
        return points.keySet().stream()
                .filter(name -> !myFriends.contains(name) && points.getOrDefault(name, 0) != 0)
                .map(name -> new Friend(name, points.get(name)))
                .sorted(Comparator.comparing(Friend::getPoint).reversed().thenComparing(Friend::getName))
                .map(Friend::getName)
                .collect(Collectors.toList());

    }

    private static class Friend{
        private final String name;
        private final int point;

        public String getName() {
            return name;
        }

        public Friend(String name, int point) {
            this.name = name;
            this.point = point;
        }

        public int getPoint() {
            return point;
        }

    }

    private static void calculateVisitors(Map<String, Integer> pointBoard, List<String> visitors){
        visitors.forEach(v -> pointBoard.put(v, pointBoard.getOrDefault(v, 0)+1));
    }
    private static Map<String, Integer> calculatePoints(String user, List<List<String>> friends, List<String> myFriends){
        return friends.stream()
                .filter(friend -> myFriends.contains(friend.get(0)) || myFriends.contains(friend.get(1)))
                .map(friend -> !myFriends.contains(friend.get(0))?friend.get(0):friend.get(1))
                .filter(friend -> !friend.equals(user))
                .collect(Collectors.toMap(friend-> friend, friend -> 5,(oldValue, newValue)-> newValue += oldValue));
    }
    private static List<String> findUserFriend(String target, List<List<String>> friends){
        return friends.stream()
                .filter(friend -> friend.get(0).equals(target) || friend.get(1).equals(target))
                .map(friend -> friend.get(0).equals(target)?friend.get(1):friend.get(0))
                .collect(Collectors.toList());
    }

}
