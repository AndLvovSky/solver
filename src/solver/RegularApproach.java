package solver;

// клас підходу з фіксованою ймовірністю та складністю
// успадковує клас підходів, які
// можуть змінювати свої властивості після рішення задач
public class RegularApproach extends MutableApproach {

    // конструктор підходу
    public RegularApproach(String name, String problemType, 
        float successProbability, boolean repeatable, int complexity) {
        super(name, problemType, successProbability, repeatable, complexity,
            0, 0, false, false);
    }
    
}
