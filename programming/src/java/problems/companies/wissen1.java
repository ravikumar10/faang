package src.java.problems.companies;

import java.util.*;

public class wissen1 {
    public static void main(String[] args) {

    }

    public static List<MovieAvgRating> sort(List<MovieRating> movieRatings){

        Map<Integer, Integer> hm = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();

        for(MovieRating m: movieRatings) {
            cnt.put(m.movieId, cnt.getOrDefault(m.movieId, 0));
            if(hm.containsKey(m.movieId)){
                hm.put(m.movieId, hm.get(m.movieId)+m.ratin);
            } else {
                hm.put(m.movieId, m.ratin);
            }
        }


        Map<Integer, Double> avgmap = new HashMap<>();

        for(Map.Entry<Integer, Integer>  l : cnt.entrySet()) {
            double avg = hm.get(l.getKey())/l.getValue();
            avgmap.put(l.getKey(), avg);

        }

        List<Map.Entry<Integer, Double> > list =
                new LinkedList<Map.Entry<Integer, Double> >(avgmap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double> >() {
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        List<MovieAvgRating> c = new LinkedList<>();

        for (Map.Entry<Integer, Double> aa : list) {
            MovieAvgRating m = new MovieAvgRating(aa.getKey(), aa.getValue());
            c.add(m);
        }

        return c;
    }

    class MovieRating{
        int movieId;

        int ratin;
    }

    static class MovieAvgRating{
        int movieId;

        public MovieAvgRating(int movieId, double ratin) {
            this.movieId = movieId;
            this.ratin = ratin;
        }

        double ratin;
    }
}
