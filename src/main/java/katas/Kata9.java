package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> copiaMovies = movieLists.stream().flatMap((list) -> list.getVideos().stream())
                .map((item) -> ImmutableMap.builder()
                        .put("idVideo: ", item.getId())
                        .put("title: ", item.getTitle())
                        .put("tiempo: ", item.getInterestingMoments()
                                .stream()
                                .filter((item2) -> item2.getType().equals("Middle")).findFirst()
                                .get()
                                .getTime()
                                .toString())
                        .put("url: ", item.getBoxarts()
                                .stream()
                                .reduce((wh1, wh2) -> wh1.getWidth() * wh1.getHeight() < wh2.getWidth() * wh2.getHeight()
                                        ? wh1 : wh2).get().getUrl())
                        .build()).collect(Collectors.toList());


        return copiaMovies;
    }

    public static void main(String[] args) {
        System.out.println(execute());
    }
}
