package repository;

import domain.Issue;

import java.util.ArrayList;
import java.util.Collection;

public class IssueRepository {

    Collection<Issue> issues = new ArrayList<>();

    public Collection<Issue> getAll() {
        return issues;
    }

    public Issue getById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        return null;
    }

    public boolean add(Issue issue) {
        return issues.add(issue);
    }

    public Collection<Issue> removeById(int id) {
        issues.removeIf(issue -> issue.getId() == id);
        return issues;
    }


    public boolean addAll(Collection<Issue> issues) {
        return this.issues.addAll(issues);
    }

    public boolean removeAll(Collection<Issue> issues) {
        return this.issues.removeAll(issues);
    }

}