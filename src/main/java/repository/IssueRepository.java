package repository;

import domain.Issue;

import java.util.ArrayList;
import java.util.Collection;

public class IssueRepository {

    Collection<Issue> issues = new ArrayList<>();

    public Collection<Issue> getAll() {
        return issues;
    }

    public Collection<Issue> getById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                return issues;
            }
        }
        return null;
    }

    public boolean add(Issue issue) {
        return issues.add(issue);
    }

    public void removeById(int id) {
        issues.removeIf(issue -> issue.getId() == id);
    }

    public void addAll(Collection<Issue> issues) {
        this.issues.addAll(issues);
    }

    public void removeAll(Collection<Issue> issues) {
        this.issues.removeAll(issues);
    }

}