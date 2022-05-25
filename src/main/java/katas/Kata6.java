package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        String urlMasGrande = movies
                .stream().flatMap((list)-> list.getBoxarts().stream())
                .reduce((wh1,wh2)-> wh1.getWidth()* wh1.getHeight() > wh2.getWidth()* wh2.getHeight()
                        ? wh1 : wh2).map((item)-> "URL: " + item.getUrl()).toString();



        return urlMasGrande;
    }

    public static void main(String[] args) {
        System.out.println(execute());
    }
}
