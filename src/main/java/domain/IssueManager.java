package domain;

import repository.IssueRepository;

import java.util.*;

public class IssueManager {
    private IssueRepository repository;


    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.add(issue);
    }

    public List<Issue> findByAuthor(String author) {
        List<Issue> byAuthor = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getAuthor().equalsIgnoreCase(author))
                byAuthor.add(issue);
        }
        return byAuthor;
    }

    public List<Issue> findByAssignee(String assignee) {
        List<Issue> byAssignee = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getAssignee().contains(assignee))
                byAssignee.add(issue);
        }
        return byAssignee;
    }

    public List<Issue> findByLabel(String label) {
        List<Issue> byLabel = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.getLabel().contains(label))
                byLabel.add(issue);
        }
        return byLabel;
    }

    public List<Issue> findOpenIssue() {
        List<Issue> byOpen = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.isOpen()) {
                byOpen.add(issue);
            }
        }
        return byOpen;
    }

    public List<Issue> findClosedIssue() {
        List<Issue> byClosed = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (!issue.isOpen()) {
                byClosed.add(issue);
            }
        }
        return byClosed;

    }
}










