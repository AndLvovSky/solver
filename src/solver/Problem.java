package solver;

// клас проблеми
public class Problem {
    
    private String type; // тип
    private int size; // розмір
    private final long id; // ідентифікатор
    private static long counter = 0; // "кількість створених задач"
    // якщо задачі с індексами після деякого значення лічильника
    // ми використовуємо лише один раз, то можна припустити,
    // що вони і не створювались, а для цього використаємо відкатку
    // значення лічильника до даного збереженого лічильника
    // в программі відкатка проходить до кількості задач в списку "Всі"
    private static long savedCounter = 0;
    
    // конструктор проблеми
    // кидає виняток NegativeSizeException
    public Problem(String type, int size) throws NegativeSizeException {
        this.type = type;
        this.setSize(size);
        this.id = counter++;
    }
    
    // гетер ідентифікатора
    public long getId() {
        return this.id;
    }
    
    // гетер типу
    public String getType() {
        return this.type;
    }
    
    // гетер розміру
    public int getSize() {
        return this.size;
    }
    
    // сетер типу
    public void setType(String type) {
        this.type = type;
    }
    
    // сетер розміру
    // кидає виняток, якщо розмір задачі від'ємний
    public void setSize(int size) throws NegativeSizeException {
        if (size < 0) {
            throw new NegativeSizeException();
        } else {
            this.size = size;
        }
    }
    
    @Override
    public String toString() {
        return "p_" + id + " ('" + type + "', " + size + ")";
    }
    
    // зберегти значення лічильника
    public static void saveState() {
        savedCounter = counter;
    }
    
    // відновити значення лічильника
    public static void restore() {
        counter = savedCounter;
    }
    
    // внутрішній клас для опису винятку, що кидається,
    // коли розмір задачі від'ємний
    // клас породжений від RuntimeException
    public static class NegativeSizeException extends RuntimeException {
        
        @Override
        public String toString() {
            return "від'ємний розмір задачі!";
        }
    }
    
}
