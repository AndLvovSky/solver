package solver;

import java.util.logging.Level;
import java.util.logging.Logger;

// клас підходу, що розбиває задачу на підзадачі того ж типу менших розмірів
// успадковує абстрактний клас для підходів,
// що використовують розбиття задачі на підзадачі
public class ResizableApproach extends DividedApproach {

    private final int divisor; // у скільки разів зменшується розмір задачі
    
    // конструктор підходу
    public ResizableApproach(String name, String problemType, 
        float successProbability, boolean repeatable, int complexity,
        int partsCount, int divisor) {
        super(name, problemType, successProbability,
              repeatable, complexity, partsCount);
        this.divisor = divisor;
    }
    
    @Override
    public Result apply(Problem problem, int timeLast) {
        if (problem.getSize() < divisor) {
            int processingTime = complexity;
            try {
                Thread.sleep(Math.min(processingTime, timeLast));
            } catch (InterruptedException ex) {
                Logger.getLogger(ResizableApproach.class.getName()).
                    log(Level.SEVERE, null, ex);
            }
            if (processingTime >= timeLast) {
                return new Result(false, timeLast);
            } else {
                return new Result(true, processingTime);
            }
        } else {
            Result divisionResult = divide(problem, timeLast);
            return union(divisionResult, problem, timeLast);
        }
    }
    
    @Override
    protected Problem[] generateDividedProblems(Problem mainProblem) {
        Problem[] dividedProblems = new Problem[partsCount];
        for (int i = 0; i < partsCount; i++) {
            dividedProblems[i] = new Problem(
                mainProblem.getType(), mainProblem.getSize() / divisor);
        }
        return dividedProblems; 
    }
    
    @Override
    protected Result partApply(Problem partProblem, int timeLast) {
        return this.apply(partProblem, timeLast);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", кількість частин - " 
            + partsCount + ", дільник - " + divisor;
    }
}
