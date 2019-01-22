package solver;

// абстрактний базовий клас для всіх типів підходів
public abstract class Approach {
    
    protected final String name; // назва підходу
    protected final String problemType; // тип проблем, що даний підхід вирішує
    // true, якщо підхід можна застосувати повторно
    protected final boolean repeatable; 
    protected float successProbability; // ймовірність успіху
    protected int complexity; // складність підходу
    
    // конструктор підходу
    public Approach(String name, String problemType, float successProbability, 
        boolean repeatable, int complexity) {
        this.name = name;
        this.problemType = problemType;
        this.successProbability = successProbability;
        this.repeatable = repeatable;
        this.complexity = complexity;
    }
    
    // гетер назви підходу
    public String getName() {
        return this.name;
    }
    
    // абстрактний метод, що повертає результат вирішення проблеми
    // при даному обмеженні в часі
    public abstract Result apply(Problem problem, int timeLast);
    
    @Override
    public String toString() {
        return "назва - " + name + ", тип вирішуваних задач - " + problemType +
            ", ймовірність успіху - " + successProbability +
            ", повторюваність - " + repeatable +
            ", складність - " + complexity;
    }
    
    // внутрішній клас, що описує результат застосування підходу    
    public static class Result {
        
        public boolean isSolved; // true, якщо задача розв'язана успішно
        public int time;  // час застосування підходу
        
        // конструктор результату застосування підходу
        public Result(boolean isSolved, int time) {
            this.isSolved = isSolved;
            this.time = time;
        }
    }
}
