import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    public int priority;
    public String task;

    public Task(int priority, String task) {
        this.priority = priority;
        this.task = task;
    }

    public String getTask() {
        return task;
    }
}

class TaskComparator implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        if (t1.priority > t2.priority) {
            return 1;
        }
        else if(t1.priority < t2.priority) {
            return -1;
        }

        return 0;
    }
}

public class ToDoList {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        PriorityQueue<Task> todoList = new PriorityQueue<>(5, new TaskComparator());

        char ch;

        do {
            System.out.println("To Do List");
            System.out.println("1. Simpan  tugas \n2. Tampilkan tugas \n3. Tandai tugas selesai \n4. Hapus To Do List");
            int choice = input1.nextInt(); input1.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama tugas:");
                    String tugas = input1.nextLine();
                    System.out.print("Masukkan prioritas:");
                    int prioritas = input1.nextInt();

                    todoList.add(new Task(prioritas, tugas));

                    System.out.println("Tugas " + tugas + " berhasil ditambahkan ke list");
                    break;
                case 2:
                    System.out.println("Tugas terdekat yang harus dijelaskan: " + todoList.peek().getTask());
                    break;
                case 3:
                    System.out.println(todoList.poll().getTask() + " selesai dilaksanakan, berikutnya " + todoList.peek().getTask());
                    break;
                case 4:
                    todoList.clear();
                    System.out.println("To Do List berhasil dikosongkan");
                    break;
            }
            
            System.out.println("Lanjut? (y/n)");

            ch = input1.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}