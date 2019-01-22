package solver;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

// абстрактний базовий клас для підходів, що
// використовують розбиття задачі на підзадачі
public abstract class DividedApproach extends Approach {
    
    // кількість задач, на які підхід розділяє початкову задачу
    protected final int partsCount; 
    
    // конструктор підходу
    public DividedApproach(String name, String problemType, 
        float successProbability, boolean repeatable, int complexity,
        int partsCount) {
        super(name, problemType, successProbability, repeatable, complexity);
        this.partsCount = partsCount;
    }
    
    // повертає список задач,
    // на які розбивається основна задача
    protected abstract Problem[] generateDividedProblems(Problem mainProblem);
    
    // повертає результат застосування деякого підходу
    // для однієї з підзадач, на які розбилася основна задача
    protected abstract Result partApply(Problem partProblem, int timeLast);
    
    // повертає результат застосування деяких підходів для всіх підзадач
    // розбиття задачі вважається успішним, якщо сумарний час на 
    // виконання всіх підзадач менше ніж встановлений для неї ліміт та
    // всі підзадачі розв'язані успішно
    protected Result divide(Problem problem, int timeLast) {
        Problem[] dividedProblems = generateDividedProblems(problem);
        int timeSum = 0;
        for (int i = 0; i < partsCount; i++) {
            Result result = partApply(dividedProblems[i], timeLast);
            timeSum += result.time;
            if (result.time >= timeLast || !result.isSolved) {
                return new Result(false, timeSum);
            } else {
                timeLast -= result.time;
            }
        }
        return new Result(true, timeSum);
    }
    
    // повертає результат об'єднання розвя'зків підзадач
    // результат об'єднання є результатом застосування підходу до задачі
    // якщо сумарний час витрачений на розбиття та
    // об'єднання менший за ліміт, то задача розв'язана упішно
    protected Result union(Result divisionResult, Problem problem,
        int timeLast) {
        if (divisionResult.isSolved == true) {
            timeLast -= divisionResult.time;
            int unionTime = (int)(complexity * problem.getSize());
            try {
                Thread.sleep(Math.min(unionTime, timeLast));
            } catch (InterruptedException ex) {
                Logger.getLogger(RegularApproach.class.getName()).
                    log(Level.SEVERE, null, ex);
            }
            if (unionTime <= timeLast) {
                boolean isSolved =
                    new Random().nextFloat() <= successProbability;
                return new Result(isSolved, divisionResult.time + unionTime);
            }  else {
                return new Result(false, timeLast);
            }
        } else {
            return new Result(false, divisionResult.time);
        }
    }
    
}
