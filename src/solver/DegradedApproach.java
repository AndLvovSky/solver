package solver;

// клас описує підхід, в якому, зменшується ймовірність успіху та
// збільшується складність, якщо він застосовується повторно до тієї ж задачі 
// успадковує клас для підходів, які
// можуть змінювати свої властивості після рішення задач
public class DegradedApproach extends MutableApproach {
    
    // дефолтний індекс останньої розв'язаної задачі
    private final static long DEFAULT_ID = -1; 
    // індекс останньої розв'язаної цим підходом задачі
    private long lastProblemId;
    
    // конструктор підходу
    public DegradedApproach(String name, String problemType, 
        float successProbability, boolean repeatable, int complexity,
        float probabilityDecrease, int complexityIncrease) {
        super(name, problemType, successProbability, repeatable,
            complexity, probabilityDecrease, complexityIncrease, false, true);
        lastProblemId = DEFAULT_ID;
    }
    
    @Override
    protected boolean needToTransform(Result result) {
        return true;
    }
    
    @Override
    protected boolean needToRestore(Problem problem) {
        return problem.getId() != lastProblemId;
    }
    
    @Override
    protected void transform(Problem problem) {
        super.transform(problem);
        lastProblemId = problem.getId();
    }
    
    @Override
    public void restore() {
        super.restore();
        lastProblemId = DEFAULT_ID;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", спадання ймовірності - " + 
            probabilityShift + ", зростання складності - " + complexityShift;
    }
    
}
