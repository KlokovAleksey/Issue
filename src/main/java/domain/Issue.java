package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class Issue implements Comparable<Issue> {

    private int id;
    private boolean open;
    private String author;
    private Set<String> label;
    private Set<String> assignee;

    @Override
    public int compareTo(Issue o) {
        return 0;
    }

}
