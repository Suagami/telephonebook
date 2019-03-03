package task1;

import telephonebook.Phonebook;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PhoneBookTests {
    @Test
    public void addPersonTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        testMap.put("Foo", new ArrayList<>());
        Phonebook testBook = new Phonebook();
        assertEquals(testMap, testBook.addPerson("Foo"));
        assertThrows(IllegalArgumentException.class, () -> testBook.addPerson("Foo"));
    }

    @Test
    public void removePersonTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        Phonebook testBook = new Phonebook();
        testBook.addPerson("Foo");
        testBook.addNumber("Foo","123");
        assertEquals(testMap, testBook.removePerson("Foo"));
        assertThrows(IllegalArgumentException.class, () -> testBook.removePerson("Foo"));
    }

    @Test
    public void addNumberTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        List<String> fooNumbers = new ArrayList<>();
        fooNumbers.add("1234567");
        testMap.put("Foo", fooNumbers);
        Phonebook testBook = new Phonebook();
        testBook.addPerson("Foo");
        assertEquals(testMap, testBook.addNumber("Foo", "1234567"));
        assertThrows(IllegalArgumentException.class, () -> testBook.addNumber("Foo", "k234567"));
        assertThrows(IllegalArgumentException.class, () -> testBook.addNumber("Foo", "1234567"));
        assertThrows(IllegalArgumentException.class, () -> testBook.addNumber("Bar", "1234567"));
    }

    @Test
    public void removeNumberTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        List<String> fooNumbers = new ArrayList<>();
        fooNumbers.add("123");
        testMap.put("Foo", fooNumbers);
        Phonebook testBook = new Phonebook();
        testBook.addPerson("Foo");
        testBook.addNumber("Foo", "123");
        testBook.addNumber("Foo", "456");
        assertEquals(testMap, testBook.removeNumber("Foo", "456"));
        assertThrows(IllegalArgumentException.class, () -> testBook.removeNumber("Foo", "456"));
        assertThrows(IllegalArgumentException.class, () -> testBook.removeNumber("Bar", "123"));
    }

    @Test
    public void getNumbersTest() {
        List<String> tempList = new ArrayList<>();
        tempList.add("123");
        tempList.add("456");
        Phonebook testBook = new Phonebook();
        testBook.addPerson("Foo");
        testBook.addNumber("Foo", "123");
        testBook.addNumber("Foo", "456");
        assertEquals(tempList, testBook.getNumbers("Foo"));
        assertThrows(IllegalArgumentException.class, () -> testBook.getNumbers("Bar"));
    }

    @Test
    public void getPeople() {
        List<String> tempList = new ArrayList<>();
        tempList.add("Foo");
        Phonebook testBook = new Phonebook();
        testBook.addPerson("Foo");
        testBook.addNumber("Foo", "123");
        testBook.addNumber("Foo", "456");
        testBook.addPerson("Bar");
        testBook.addNumber("Bar", "456");
        assertEquals(tempList, testBook.getPeople("123"));
        tempList.add("Bar");
        tempList.sort(Comparator.naturalOrder());
        assertEquals(tempList, testBook.getPeople("456"));
    }
}