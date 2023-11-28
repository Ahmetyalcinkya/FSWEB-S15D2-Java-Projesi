package com.workintech.sets;

import java.util.*;

public class TaskData {
    private Set<Task> annsTask;
    private Set<Task> bobsTask;
    private Set<Task> carolsTask;

    public TaskData(Set<Task> annsTask, Set<Task> bobsTask, Set<Task> carolsTask) {
        this.annsTask = annsTask;
        this.bobsTask = bobsTask;
        this.carolsTask = carolsTask;
    }
    public Set<Task> getTasks(String name){

        if(name.equalsIgnoreCase("ann")){
            return annsTask;
        }
        else if(name.equalsIgnoreCase("bob")){
            return bobsTask;
        }
        else if(name.equalsIgnoreCase("carol")){
            return carolsTask;
        }else if(name.equalsIgnoreCase("all")){
            List<Set<Task>> alltasks = new ArrayList<>();
            alltasks.add(annsTask);
            alltasks.add(bobsTask);
            alltasks.add(carolsTask);
            return getUnion(alltasks);
        }else {
            System.out.println("Geçerli bir isim giriniz!");
            return null;
        }
    }
    public Set<Task> getUnion(List<Set<Task>> alltasks){
        Set<Task> totalTask = new LinkedHashSet<>();
        for(Set<Task> tasks: alltasks){
            totalTask.addAll(tasks);
        }
        return totalTask;
    }
    public Set<Task> getIntersect(Set<Task> firstTask, Set<Task> secondTask){
        Set<Task> intersection = new HashSet<>();
        intersection.addAll(firstTask);
        intersection.retainAll(secondTask);
        return intersection;
    }

    public Set<Task> getDifference(Set<Task> first, Set<Task> second){
        Set<Task> difference = new HashSet<>();
        difference.addAll(first);
        difference.removeAll(second);
        return difference;
    }
}
