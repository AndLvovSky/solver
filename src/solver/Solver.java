package solver;

import solver.frame.MainJFrame;
import solver.Approach.Result;
import java.util.ArrayList;
import java.util.Random;

// головний клас програми "Вирішувач", або
// клас вирішувача
public class Solver {

    private ArrayList<Approach> approaches;
    private ArrayList<Problem> problems;
    private int timeLimit;
    
    // дефолтний конструктор
    public Solver() {
        this.approaches = new ArrayList<>();
        this.problems = new ArrayList<>();
        this.timeLimit = 0;
    }
    
    // повний конструктор
    // кидає виняток SolverException
    public Solver(int timeLimit, ArrayList<Problem> problems,
        ArrayList<Approach> approaches) throws SolverException {
        this.setTimeLimit(timeLimit);
        this.setApproaches(approaches);
        this.setProblems(problems);       
    }
    
    // сетер підходів
    // кидає виключення, якщо список підходів пустий
    public void setApproaches(ArrayList<Approach> approaches) 
        throws SolverException {
        if (approaches.isEmpty()) {
            throw new SolverException("список підходів пустий!");
        } else {
            this.approaches = approaches;
        }
    }
    
    // сетер задач
    // кидає виключення, якщо список задач пустий
    public void setProblems(ArrayList<Problem> problems) 
        throws SolverException {
        if (problems.isEmpty()) {
            throw new SolverException("список задач пустий!");
        } else {
            this.problems = problems;
        }
    }
    
    // сетер обмеження часу на розв'язання однієї задачі
    // кидає виключення, якщо цей час не додатній
    public void setTimeLimit(int timeLimit) 
        throws SolverException {
        if (timeLimit <= 0) {
            throw new SolverException(timeLimit < 0 ?
                "від'ємне обмеження часу!" :
                "відсутній час для виконання задач!");
        } else {
            this.timeLimit = timeLimit;
        }
    }
    
    // додати підхід
    public void addApproach(Approach approach) {
        this.approaches.add(approach);
    }
    
    // додати проблему
    public void addProblem(Problem problem) {
        this.problems.add(problem);
    }
    
    // повертає список підходів
    public ArrayList<Approach> getApproaches() {
        return this.approaches;
    }
    
    // повертає список проблем
    public ArrayList<Problem> getProblems() {
        return this.problems;
    }
    
    // повертає часове обмеження
    public int getTimeLimit() {
        return this.timeLimit;
    }
    
    // повертає результат розв'язання всіх задач,
    // використовуючі всі підходи вирішувача
    public ArrayList<Result> solveAll(SolvingManager solvingManager) {
        Problem.saveState(); // (1)
        ArrayList<Result> results = new ArrayList<>();
        int solved = 0;
        for (Problem problem : problems) {
            results.add(solve(problem, timeLimit, solvingManager));
            // перевірка на випадок застосування класу Tester
            if (solvingManager != null) {
                solvingManager.progress(solved++);
            }
        }
        // (2)
        for (Approach approach : approaches) {
            if (approach instanceof MutableApproach) {
                ((MutableApproach) approach).restore();
            } 
        }
        Problem.restore(); // (3)
        // блоки 1, 2, 3 необхідні для того, щоб
        // після вирішення задач вирішувач вернувся
        // до початкового стану, тобто
        // щоб программа з заданими списками підходів і задач
        // працювала так само, як після перезапуску
        return results;
    }
    
    // повертає результат вирішення заданої задачі
    protected Result solve(Problem problem, int timeLast,
        SolvingManager solvingManager) {
        // формуємо список підходів, які взагалі можна
        // застосувати до задач зі списку
        ArrayList<Approach> correctApproaches = new ArrayList<>();
        for (Approach approach : approaches) {
            if (approach.problemType.equals(problem.getType())) {
                correctApproaches.add(approach);
            }
        }
        int timeSum = 0; // час вирішення задачі
        Random random = new Random();
        // поки залишився час та не закінчилися 
        // підходи, що можна застосувати
        while (timeLast > 0 && !correctApproaches.isEmpty()) {
            // вибираємо випадковий підхід
            Approach approach = correctApproaches.get(
                random.nextInt(correctApproaches.size()));
            // приміняємо підхід до задачі
            Result result = approach.apply(problem, timeLast);
            // на це витратився певний час
            timeSum += result.time;
            timeLast -= result.time;
            if (result.isSolved) {
                //--код для тестування алгоритмічної коректності--//
                /*System.out.println("p" + problem.getId() +
                " solved by " + approach.name +
                " in " + Integer.toString(result.time));*/
                
                return new Result(true, timeSum); // успішне рішення
            }
            //--код для тестування алгоритмічної коректності--//
            /*System.out.println("p" + problem.getId() +
            " not solved by " + approach.name +
            (result.time >= timeLast ? " (TL)" : " (AC)") + 
            " in " + Integer.toString(result.time));*/
            
            // якщо ймовірність успіху впала до нуля або
            // підхід не можна повторно застосовувати
            // виключити його зі списку застосовних
            if (approach.successProbability == 0.0 ||
                !approach.repeatable) {
                correctApproaches.remove(approach);
            }
        }
        // жоден підхід не зміг розв'язати задачу успішно
        return new Result(false, timeSum);
    }
    
//--код для тестування алгоритмічної коректності--//
    public void showResults(ArrayList<Result> results) {
        int timeSum = 0;
        for (Result result : results) {
            timeSum += result.time;
        }
        System.out.println();
        System.out.println("Total time = " + Integer.toString(timeSum));
        for (int i = 0; i < problems.size(); i++) {
            System.out.print("- p" + problems.get(i).getId() + ": ");
            Result result = results.get(i);
            if (result.isSolved) {
                System.out.println("solved in " +
                    Integer.toString(result.time));
            } else {
                System.out.println("not solved " +
                    (result.time >= timeLimit ? "(TL)" : "(LA)") +
                    " in " + Integer.toString(result.time));
            }
        }
        System.out.println();
    }
    
    // повертає згенерований вирішувач
    // з 15-ма підходами 5-ти типів та 15-ма задачами
    // якщо створити породжений клас і перегрузити дану функцію,
    // можна отримати інші підходи та дефолтні задачі 
    protected static Solver generateDefaultSolver() {
        Solver solver = new Solver();
        solver.setTimeLimit(200);
        solver.addApproach(
            new RegularApproach("combinatorics", "pa", 0.8f, true, 5));
        solver.addApproach(
            new RegularApproach("constructive", "pb", 0.7f, false, 3));
        solver.addApproach(
            new RegularApproach("string", "pa", 0.4f, true, 4));
        solver.addApproach(
            new RegularApproach("bitmask", "pc", 0.6f, false, 7));
        solver.addApproach(
            new RegularApproach("probability theory", "pc", 0.9f, true, 2));
        solver.addApproach(
            new ImprovableApproach("greedy", "pa", 0.35f, true, 8, 0.5f, 2));
        solver.addApproach(
            new ImprovableApproach(
            "data structure", "pb", 0.7f, false, 4, 0.1f, 1));
        solver.addApproach(
            new ImprovableApproach("geometry", "pc", 0.4f, true, 9, 0.3f, 3));
        solver.addApproach(
            new DegradedApproach("brute force", "pb", 0.6f, true, 5, 0.2f, 5));
        solver.addApproach(
            new DegradedApproach("game theory", "pa", 0.5f, true, 2, 0.25f, 3));
        solver.addApproach(
            new MultitypeApproach("tree", "pb", 0.8f, false, 10,
            2, new String[]{"pa", "pb"}, solver));
        solver.addApproach(
            new MultitypeApproach("dp", "pa", 0.5f, true, 2,
            3, new String[]{"pa", "pb", "pc"}, solver));
        solver.addApproach(
            new ResizableApproach("binary search", "pb",
            0.95f, false, 1, 2, 2));
        solver.addApproach(
            new ResizableApproach("thread", "pc", 0.85f, false, 3, 5, 2));
        solver.addApproach(
            new ResizableApproach("graph", "pa", 0.6f, false, 2, 6, 3));
        solver.addProblem(new Problem("pa", 10));
        solver.addProblem(new Problem("pb", 5));
        solver.addProblem(new Problem("pa", 20));
        solver.addProblem(new Problem("pb", 3));
        solver.addProblem(new Problem("pa", 20));
        solver.addProblem(new Problem("pb", 35));
        solver.addProblem(new Problem("pb", 1));
        solver.addProblem(new Problem("pc", 40));
        solver.addProblem(new Problem("pa", 5));
        solver.addProblem(new Problem("pc", 30));
        solver.addProblem(new Problem("pc", 25));
        solver.addProblem(new Problem("pa", 15));
        solver.addProblem(new Problem("pb", 6));
        solver.addProblem(new Problem("pb", 70));
        solver.addProblem(new Problem("pa", 55));
        return solver;
    }
    
    // точка входу в программу
    public static void main(String[] args) {
        // генеруємо дефолтний вирішувач
        Solver solver = generateDefaultSolver();
        // запускаємо графічний інтерфейс користувача
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainJFrame(solver).setVisible(true);
            }
        });
    }
    
}
