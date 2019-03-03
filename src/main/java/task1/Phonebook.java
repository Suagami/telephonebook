package task1;

import java.util.*;

public class Phonebook {
    public Map<String, List<String>> phoneMap = new HashMap<>();

    public Map<String, List<String>> addPerson(String person) {
        if (this.phoneMap.containsKey(person)) throw new IllegalArgumentException("Person already exists");
        List<String> numbers = new ArrayList<String>() {};
        this.phoneMap.put(person, numbers);
        return this.phoneMap;
    }

    public Map<String, List<String>> removePerson(String person) {
        if (!this.phoneMap.containsKey(person)) throw new IllegalArgumentException("Person doesn't exist");
        this.phoneMap.remove(person);
        return this.phoneMap;
    }

    public Map<String, List<String>> addNumber(String person, String number){
        if (!this.phoneMap.containsKey(person)) throw new IllegalArgumentException("Person doesn't exist");
        if (!number.matches("(\\+|[-]|\\*|[#]|\\d)+")) throw new IllegalArgumentException("Invalid number");
        List<String> tempList = this.phoneMap.get(person);
        if (tempList.contains(number)) throw new IllegalArgumentException("Number already exists");
        tempList.add(number);
        this.phoneMap.put(person, tempList);
        return this.phoneMap;
    }

    public Map<String, List<String>> removeNumber(String person, String number) {
        if (!this.phoneMap.containsKey(person)) throw new IllegalArgumentException("Person doesn't exist");
        List<String> tempList = this.phoneMap.get(person);
        if (!tempList.contains(number)) throw new IllegalArgumentException("Number doesn't exist");
        tempList.remove(number);
        this.phoneMap.put(person, tempList);
        return this.phoneMap;
    }

    public List<String> getNumbers(String person){
        if (!this.phoneMap.containsKey(person)) throw new IllegalArgumentException("Person doesn't exist");
        return this.phoneMap.get(person);
    }

    public List<String> getPeople(String number) {
        List<String> tempPeople = new ArrayList<String>() {};
        this.phoneMap.forEach((key, value) -> {if (value.contains(number)) tempPeople.add(key);});
        return tempPeople;
    }


}
