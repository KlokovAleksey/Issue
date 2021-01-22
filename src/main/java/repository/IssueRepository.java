package domain;

import java.util.ArrayList;
import java.util.Collection;

public class IssueRepository {
    Collection<Issue> issues = new ArrayList<>();

    public void save(Issue issue){
        issues.add(issue);
    }
    public Collection<Issue> findAll(){
        return issues;
    }

}
