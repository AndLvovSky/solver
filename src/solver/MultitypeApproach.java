package solver;

// клас підходу, що розбиває задачу на підзадачі інших типів того ж розміру
// успадковує абстрактний клас для підходів,
// що використовують розбиття задачі на підзадачі
public class MultitypeApproach extends DividedApproach {
    
    // масив типів підзадач, на які розбивається задача
    private final String[] dividedProblemsTypes;
    // вирішувач, що буде містити даний підхід
    // дане поле є необхідним, оскільки після розбиття задачі на 
    // підзадачі інших типів вони вирішуються підходами вирішувача,
    // в якому застосовується цей підхід
    private final Solver solver; 

    // конструктор підходу
    public MultitypeApproach(String name, String problemType,
        float successProbability, boolean repeatable, int complexity, 
        int partsCount, String[] dividedProblemsTypes, Solver solver) {
        super(name, problemType, successProbability, 
              repeatable, complexity, partsCount);
        this.dividedProblemsTypes = dividedProblemsTypes; 
        this.solver = solver;
    }

    @Override
    public Result apply(Problem problem, int timeLast) {
        Result divisionResult = divide(problem, timeLast);
        return union(divisionResult, problem, timeLast);
    }
    
    @Override
    protected Problem[] generateDividedProblems(Problem mainProblem) {
        Problem[] dividedProblems = new Problem[partsCount];
        for (int i = 0; i < partsCount; i++) {
            dividedProblems[i] = 
                new Problem(dividedProblemsTypes[i], mainProblem.getSize());
        }
        return dividedProblems; 
    }
    
    @Override
    protected Result partApply(Problem partProblem, int timeLast) {
        return solver.solve(partProblem, timeLast, null);
    }
    
    @Override
    public String toString() {
        String s = super.toString() + ", типи розбиття(";
        for (int i = 0; i < dividedProblemsTypes.length - 1; i++) {
            s += dividedProblemsTypes[i] + ", ";
        }
        return s + dividedProblemsTypes[dividedProblemsTypes.length - 1] + ")";
    }
    
}
