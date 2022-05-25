package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.sun.source.tree.LiteralTree;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> copiaMovies = movieLists.stream().flatMap((list) -> list.getVideos().stream())
                .map((item) -> ImmutableMap.builder()
                        .put("id: ", item.getId())
                        .put("title: ", item.getTitle())
                        .put("boxArt: ", item.getBoxarts().stream()
                                .filter((filter) -> filter.getWidth() == 150 && filter.getHeight() == 200)
                                .findFirst()).build())
                .collect(Collectors.toList());

        return copiaMovies;
    }

    public static void main(String[] args) {
        System.out.println(execute());
    }
}
