package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {

    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);


    private Issue issue1 = new Issue(1, true, "Andrey",new HashSet<String>(Arrays.asList("bug")),new HashSet<String>(Arrays.asList("Nikolay")));
    private Issue issue2 = new Issue(2, false, "Anna", new HashSet<String>(Arrays.asList("question")), new HashSet<String>(Arrays.asList("Sergey")));
    private Issue issue3 = new Issue(3, true, "Sergey", new HashSet<String>(Arrays.asList("documentation")), new HashSet<String>(Arrays.asList("Andrey")));
    private Issue issue4 = new Issue(4, true, "Anna",new HashSet<String>(Arrays.asList("question")), new HashSet<String>(Arrays.asList("Nikolay")));
    private Issue issue5 = new Issue(5, true, "Nikolay", new HashSet<String>(Arrays.asList("bug")), new HashSet<String>(Arrays.asList("Sergey")));
    private Issue issue6 = new Issue(6, false, "Andrey", new HashSet<String>(Arrays.asList("bug")), new HashSet<String>(Arrays.asList("Anna")));


    @BeforeEach
    public void addIssue() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);
        manager.add(issue5);
        manager.add(issue6);
    }

    @Test
    public void shouldFindByAuthor() {
        List<Issue> actual = manager.findByAuthor("Andrey");
        List<Issue> expected = List.of(issue1, issue6);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldNotAuthor() {
        List<Issue> actual = manager.findByAuthor("Jora");
        List<Issue> expected = List.of();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldOpenIssue() {
        List<Issue> actual = manager.findOpenIssue();
        List<Issue> expected = List.of(issue1, issue3, issue4, issue5);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldClosedIssue() {
        List<Issue> actual = manager.findClosedIssue();
        List<Issue> expected = List.of(issue2, issue6);
        assertEquals(actual, expected);

    }
    @Test
    public void shouldFindByAssignee() {
        List<Issue> actual = manager.findByAssignee("Nikolay");
        List<Issue> expected = List.of(issue1,issue4);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFindByNotAssignee() {
        List<Issue> actual = manager.findByAssignee("Jora");
        List<Issue> expected = List.of();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFindByLabel() {
        List<Issue> actual = manager.findByLabel("bug");
        List<Issue> expected = List.of(issue1,issue5,issue6);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFindByNotLabel() {
        List<Issue> actual = manager.findByLabel("answer");
        List<Issue> expected = List.of();
        assertEquals(actual, expected);
    }

}
