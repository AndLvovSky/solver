package solver;

// клас описує підхід, в якому, збільшується ймовірність успіху та
// зменшується складність, якщо вже вирішувались інші задачі такого ж типу
// успадковує клас для підходів, які
// можуть змінювати свої властивості після рішення задач
public class ImprovableApproach extends MutableApproach {
 
    // конструктор підходу
    public ImprovableApproach(String name, String problemType, 
        float successProbability, boolean repeatable, int complexity,
        float probabilityIncrease, int complexityDecrease) {
        super(name, problemType, successProbability, repeatable,
            complexity, probabilityIncrease, complexityDecrease, true, false);
    }

    @Override
    protected boolean needToTransform(Result result) {
        return result.isSolved;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", зростання ймовірності - " + 
            probabilityShift + ", спадання складності - " + complexityShift;
    }
    
}
