package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        Double mayorPuntuacion = movies.stream().reduce((p1,p2)-> p1.getRating() > p2.getRating()? p1 : p2)
                .get()
                .getRating();


        return mayorPuntuacion;
    }

    public static void main(String[] args) {
        System.out.println(execute());
    }
}
