package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> copiaMovies = movieLists.stream()
                .flatMap((list) -> list.getVideos().stream())
                .map((item) -> ImmutableMap.builder()
                        .put("id: ", item.getId())
                        .put("title: ", item.getTitle())
                        .put("url: ", item.getBoxarts().stream()
                                .reduce((wh1, wh2) -> wh1.getWidth() * wh1.getHeight() < wh2.getWidth() * wh2.getHeight()
                                        ? wh1 : wh2).map((item2) -> "Url: " + item2.getUrl()).stream().findFirst()).build()
                ).collect(Collectors.toList());


        return copiaMovies;
    }

    public static void main(String[] args) {
        System.out.println(execute());
    }
}
