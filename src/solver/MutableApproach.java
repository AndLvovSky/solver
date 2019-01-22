package solver;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

// базовий клас для підходів, які
// можуть змінювати свої властивості після рішення задач
// деякі поля необхідні для того, мати змогу
// повернути підхід у початковий стан
public class MutableApproach extends Approach {

    private final float startProbability;  // початкова ймовірність успіху
    private final int startComplexity; // початкова складність
    // величина, на яку може змінюватися ймовірність успіху
    protected final float probabilityShift; 
    // величина, на яку може змінюватися складність
    protected final int complexityShift; 
    // true, якщо ймовірність збільшується
    private final boolean isProbabilityIncreasing; 
    // true, якщо складність збільшується
    private final boolean isComplexityIncreasing;
    
    // конструктор підходу
    public MutableApproach(String name, String problemType, 
        float successProbability, boolean repeatable, int complexity,
        float probabilityShift, int complexityShift, 
        boolean isProbabilityIncreasing, boolean isComplexityIncreasing) {
        super(name, problemType, successProbability, repeatable, complexity);
        this.startProbability = successProbability;
        this.startComplexity = complexity;
        this.probabilityShift = probabilityShift;
        this.complexityShift = complexityShift;
        this.isProbabilityIncreasing = isProbabilityIncreasing;
        this.isComplexityIncreasing = isComplexityIncreasing;
    }
    
    @Override
    public Result apply(Problem problem, int timeLast) {
        if (needToRestore(problem)) {
            restore();
        }
        // обчислимо час вирішення задачі 
        int processingTime = (int)(complexity * problem.getSize());
        // зімітуємо процес вирішення задачі
        // якщо обчислений час менше ліміту, то зупинимося на цей час, інакше 
        // будемо вирішувати задачу допоки не закінчиться виділений час
        try {
            Thread.sleep(Math.min(processingTime, timeLast));
        } catch (InterruptedException ex) {
            Logger.getLogger(RegularApproach.class.getName()).
                log(Level.SEVERE, null, ex);
        }
        boolean isSolved = new Random().nextFloat() <= successProbability;
        Result result = 
            processingTime < timeLast ? new Result(isSolved, processingTime) :
            new Result(false, timeLast);
        if (needToTransform(result)) {
            transform(problem);
        }
        return result;
    }
    
    // чи потрібно змінювати властивості підходу
    protected boolean needToTransform(Result result) {
        return false;
    }
    
    // чи потрібно відновити властивості підходу
    protected boolean needToRestore(Problem problem) {
        return false;
    }
    
    // зміна властивостей підходу
    protected void transform(Problem problem) {
        this.successProbability = Math.max(Math.min(
            this.successProbability + (isProbabilityIncreasing ? 1 : -1) * 
            probabilityShift, (float)1.0), (float)0.0);
        this.complexity = Math.max(this.complexity + 
            (isComplexityIncreasing ? 1 : -1) * complexityShift, 1);
    }
    
    // відновлення властивостей підходу
    public void restore() {
        this.successProbability = this.startProbability;
        this.complexity = this.startComplexity;
    }
    
}
