import com.workintech.enums.Priority;
import com.workintech.enums.Status;
import com.workintech.sets.Task;
import com.workintech.sets.TaskData;

import java.sql.SQLOutput;
import java.util.*;

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

        String a = "Carroll began writing the manuscript of the story the next day," +
                " although that earliest version is lost. " + "The girls and Carroll took another boat" +
                " trip a month later, when he elaborated the plot to the story of Alice, " +
                "and in November he began working on the manuscript in earnest. To add the finishing " +
                "touches he researched " + "natural history in connection with the animals presented " +
                "in the book and then had the book examined " + "by other children—particularly those " +
                "of George MacDonald. Though Carroll did add his own illustrations " + "to the original " +
                "copy, on publication he was advised to find a professional illustrator so the pictures " +
                "were more appealing to its audiences. He subsequently approached John Tenniel to reinterpret " +
                "Carroll's visions through his own artistic eye, telling him that the story had been well liked by " +
                "the" + " children.\n" + "\n" + "Carroll began planning a print edition of the Alice story in 1863. "
                + "He wrote on 9 May 1863 that MacDonald's family had suggested he publish Alice." +
                " A diary entry for 2 July says that he received a specimen page of the print edition around that date. " +
                "On 26 November 1864, Carroll gave Alice the manuscript of Alice's Adventures Under Ground, with illustrations "
                + "by Carroll, dedicating it as A Christmas Gift to a Dear Child in Memory of a Summer's Day."
                + " The published version of Alice's Adventures in Wonderland is about twice the length of " +
                "Alice's Adventures Under Ground and includes episodes, such as the Mad Tea-Party, " +
                "that did not appear in the manuscript. The only known manuscript copy of Under Ground " +
                "is held in the British Library. Macmillan published a facsimile of the manuscript in 1886.";

        String[] words = a.split(" ");
        System.out.println(words.length);
        TreeSet<String> unique = new TreeSet<>(Arrays.asList(words));
        System.out.println(unique.size());
        System.out.println(unique);
    }
    public static void main(String[] args) {

        setChallange();
    }
}