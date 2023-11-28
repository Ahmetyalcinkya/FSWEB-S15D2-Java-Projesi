import com.workintech.enums.Priority;
import com.workintech.enums.Status;
import com.workintech.sets.Task;
import com.workintech.sets.TaskData;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void setChallange() {

        Task eCommerce = new Task("E-commerce",
                "This is an e-commerce website",
                "ann",Priority.MEDIUM, Status.IN_QUEUE);
        Task barcodeReader = new Task("Barcode reader",
                "You can read your barcodes.",
                "bob",Priority.LOW, Status.ASSIGNED);
        Task clone = new Task("Clone",
                "This project includes website clones.",
                "carol",Priority.HIGH, Status.IN_PROGRESS);

        Task eCommerce2 = new Task("E-commerce",
                "This is an e-commerce website",
                "carol",Priority.LOW, Status.IN_PROGRESS);
        Task barcodeReader2 = new Task("Barcode reader",
                "You can read your barcodes.",
                "bob",Priority.HIGH, Status.IN_QUEUE);
        Task clone2 = new Task("Clone",
                "This project includes website clones.",
                "ann",Priority.MEDIUM, Status.ASSIGNED);

        Set<Task> all = new HashSet<>();
        all.add(eCommerce);
        all.add(barcodeReader);
        all.add(clone);
        all.add(eCommerce2);
        all.add(barcodeReader2);
        all.add(clone2);

        Set<Task> annsTask = new LinkedHashSet<>();
        annsTask.add(eCommerce);
        annsTask.add(clone2);

        Set<Task> bobsTask = new LinkedHashSet<>();
        bobsTask.add(barcodeReader);
        bobsTask.add(barcodeReader2);

        Set<Task> carolsTask = new LinkedHashSet<>();
        carolsTask.add(clone);
        carolsTask.add(eCommerce2);

        TaskData taskData = new TaskData(annsTask, bobsTask, carolsTask);

        System.out.println("All tasks : ");
        System.out.println(taskData.getTasks("all"));

        System.out.println("AnnsTasks : ");
        System.out.println(taskData.getTasks("ann"));

        System.out.println("BobsTasks : ");
        System.out.println(taskData.getTasks("bob"));

        System.out.println("CarolsTasks : ");
        System.out.println(taskData.getTasks("carol"));

        System.out.println(taskData.getDifference(annsTask, taskData.getTasks("all")));

        System.out.println("Ann + Carol: " + taskData.getIntersect(annsTask, carolsTask));
        System.out.println("Bob + Carol: " + taskData.getIntersect( carolsTask,bobsTask));
        System.out.println("Ann + Bob: " + taskData.getIntersect(annsTask, bobsTask));
    }
    public static void main(String[] args) {

        setChallange();
    }
}