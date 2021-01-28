package repository;

import domain.Issue;
import domain.IssueManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);

    private Issue issue1 = new Issue(1, true, "Andrey", new HashSet<String>(Arrays.asList("bug")), new HashSet<String>(Arrays.asList("Nikolay")));
    private Issue issue2 = new Issue(2, false, "Anna", new HashSet<String>(Arrays.asList("question")), new HashSet<String>(Arrays.asList("Sergey")));
    private Issue issue3 = new Issue(3, true, "Sergey", new HashSet<String>(Arrays.asList("documentation")), new HashSet<String>(Arrays.asList("Andrey")));
    private Issue issue4 = new Issue(4, true, "Anna", new HashSet<String>(Arrays.asList("question")), new HashSet<String>(Arrays.asList("Nikolay")));
    private Issue issue5 = new Issue(5, true, "Nikolay", new HashSet<String>(Arrays.asList("bug")), new HashSet<String>(Arrays.asList("Sergey")));
    private Issue issue6 = new Issue(6, false, "Andrey", new HashSet<String>(Arrays.asList("bug")), new HashSet<String>(Arrays.asList("Anna")));

    @BeforeEach
    public void addIssue() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.add(issue5);
        repository.add(issue6);

    }

    @Test
    public void shouldGetAll() {
        Collection<Issue> actual = repository.getAll();
        Collection<Issue> expected = Arrays.asList(issue1, issue2, issue3, issue4, issue5, issue6);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldGetById() {
        int id = 3;
        Issue actual = repository.getById(id);
        Issue expected = issue3;
        assertEquals(actual, expected);

    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(4);
        Collection<Issue> actual = repository.getAll();
        Collection<Issue> expected = Arrays.asList(issue1,issue2,issue3,issue5,issue6);
        assertEquals(actual,expected);
    }
}