
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NotebookStore{
    private List<Notebook> notebooks;

    public NotebookStore() {
        this.notebooks = new ArrayList<>();
    }
    
    public void addNotebook(Notebook notebook) {
        this.notebooks.add(notebook);
    }

    public void filterNotebooks() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> criteria = new HashMap<>();
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        // Добавить другие критерии при необходимости

        String input = scanner.nextLine();
        while(!input.trim().isEmpty()) {
            switch (input) {
                case "1":
                    System.out.print("Введите минимальное количество ОЗУ (ГБ) 8/16 ");
                    criteria.put("ram", scanner.nextLine());
                    break;
                case "2":
                    System.out.print("Введите минимальный объем ЖД (ГБ): 256/512 ");
                    criteria.put("storage", scanner.nextLine());
                    break;
                case "3":
                    System.out.print("Введите название операционной системы: Windows 10 или macOS ");
                    criteria.put("os", scanner.nextLine());
                    break;
                case "4":
                    System.out.print("Введите цвет: Silver, Space Gray, Black ");
                    criteria.put("color", scanner.nextLine());
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
            System.out.print("Добавьте другой критерий или нажмите Enter для продолжения: ");
            input = scanner.nextLine();
        }

        List<Notebook> filteredNotebooks = new ArrayList<>(this.notebooks);
        for (Map.Entry<String, String> entry : criteria.entrySet()) {
            filteredNotebooks.removeIf(notebook -> !matchesCriterion(notebook, entry.getKey(), entry.getValue()));
        }

        System.out.println("Ноутбуки, соответствующие указанным критериям:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    private boolean matchesCriterion(Notebook notebook, String criterion, String value) {
        switch (criterion) {
            case "ram":
                return notebook.getRam() >= Integer.parseInt(value);
            case "storage":
                return notebook.getStorage() >= Integer.parseInt(value);
            case "os":
                return notebook.getOs().equalsIgnoreCase(value);
            case "color":
                return notebook.getColor().equalsIgnoreCase(value);
            default:
                return true;
        }
    }

    public static void main(String[] args) {
        NotebookStore store = new NotebookStore();
        
        store.addNotebook(new Notebook("Lenovo", "IdeaPad", 16, 512, "Windows 10", "Silver", 15.6, 50000));
        store.addNotebook(new Notebook("Apple", "MacBook Air", 8, 256, "macOS", "Space Gray", 13.3, 100000));
        store.addNotebook(new Notebook("Dell", "XPS", 16, 512, "Windows 10", "Black", 15.0, 120000));
        store.filterNotebooks();
    }
}
