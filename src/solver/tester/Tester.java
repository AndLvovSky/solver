package solver.tester;

import solver.*;

// клас тестера, що може бути використаний для тестування
// алгоритмічної частини програми
// тестер має 10 методів, що створюють деякий вирішувач, а потім запускають його,
// результати тестування виводяться в стандартний вивід, необхідно лише
// розкоментувати рядки під написом 
//--код для тестування алгоритмічної коректності--//
// та визвати методи з main
public final class Tester {
    
    public static void test1() {
        Solver solver = new Solver();
        solver.setTimeLimit(200);
        solver.addApproach(new RegularApproach("a0", "pa", 1.f, false, 1));
        solver.addApproach(new RegularApproach("a1", "pa", 0.5f, true, 2));
        solver.addApproach(new RegularApproach("a2", "pb", 0.5f, false, 3));
        solver.addProblem(new Problem("pa", 10));
        solver.addProblem(new Problem("pb", 5));
        solver.addProblem(new Problem("pa", 50));
        solver.addProblem(new Problem("pb", 10));
        solver.addProblem(new Problem("pa", 2));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test2() {
        Solver solver = new Solver();
        solver.setTimeLimit(150);
        solver.addApproach(new ImprovableApproach("a0", "pa", 0.5f, true, 5, 0.5f, 1));
        solver.addApproach(new ImprovableApproach("a1", "pa", 0.4f, false, 4, 0.3f, 1));
        solver.addApproach(new ImprovableApproach("a2", "pb", 0.7f, false, 6, 0.1f, 3));
        solver.addApproach(new ImprovableApproach("a3", "pb", 0.5f, true, 3, 0.5f, 1));
        solver.addProblem(new Problem("pa", 10));
        solver.addProblem(new Problem("pb", 5));
        solver.addProblem(new Problem("pa", 20));
        solver.addProblem(new Problem("pb", 30));
        solver.addProblem(new Problem("pa", 5));
        solver.addProblem(new Problem("pb", 40));
        solver.addProblem(new Problem("pb", 15));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test3() {
        Solver solver = new Solver();
        solver.setTimeLimit(150);
        solver.addApproach(new DegradedApproach("a0", "pa", 0.5f, true, 3, 0.5f, 2));
        solver.addApproach(new DegradedApproach("a1", "pa", 0.4f, true, 2, 0.2f, 1));
        solver.addApproach(new DegradedApproach("a2", "pb", 0.7f, false, 4, 0.3f, 3));
        solver.addApproach(new DegradedApproach("a3", "pb", 0.5f, true, 1, 0.2f, 1));
        solver.addProblem(new Problem("pa", 10));
        solver.addProblem(new Problem("pb", 5));
        solver.addProblem(new Problem("pa", 20));
        solver.addProblem(new Problem("pb", 30));
        solver.addProblem(new Problem("pa", 5));
        solver.addProblem(new Problem("pb", 40));
        solver.addProblem(new Problem("pb", 15));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test4() {
        Solver solver = new Solver();
        solver.setTimeLimit(500);
        solver.addApproach(new RegularApproach("a0", "pa", 0.3f, true, 5));
        solver.addApproach(new RegularApproach("a1", "pa", 0.7f, true, 20));
        solver.addApproach(new MultitypeApproach("a2", "pb", 0.5f, true, 3, 2, new String[]{"pa", "pa"}, solver));
        solver.addProblem(new Problem("pb", 10));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test5() {
        Solver solver = new Solver();
        solver.setTimeLimit(750);
        solver.addApproach(new RegularApproach("a0", "pa", 0.3f, true, 3));
        solver.addApproach(new RegularApproach("a1", "pa", 0.7f, true, 10));
        solver.addApproach(new MultitypeApproach("a2", "pb", 0.5f, true, 3, 2, new String[]{"pa", "pc"}, solver));
        solver.addApproach(new MultitypeApproach("a3", "pc", 0.5f, true, 5, 2, new String[]{"pa", "pa"}, solver));
        solver.addProblem(new Problem("pb", 10));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test6() {
        Solver solver = new Solver();
        solver.setTimeLimit(250);
        solver.addApproach(new ResizableApproach("a0", "pa", 0.8f, true, 3, 2, 2));
        solver.addProblem(new Problem("pa", 8));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test7() {
        Solver solver = new Solver();
        solver.setTimeLimit(150);
        solver.addApproach(new RegularApproach("a0", "pa", 0.4f, false, 4));
        solver.addApproach(new ImprovableApproach("a1", "pa", 0.5f, true, 5, 0.5f, 1));
        solver.addApproach(new DegradedApproach("a2", "pb", 0.7f, true, 6, 0.1f, 3));
        solver.addProblem(new Problem("pa", 10));
        solver.addProblem(new Problem("pb", 5));
        solver.addProblem(new Problem("pa", 20));
        solver.addProblem(new Problem("pb", 30));
        solver.addProblem(new Problem("pa", 5));
        solver.addProblem(new Problem("pb", 40));
        solver.addProblem(new Problem("pb", 15));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test8() {
        Solver solver = new Solver();
        solver.setTimeLimit(500);
        solver.addApproach(new RegularApproach("a0", "pa", 0.7f, true, 5));
        solver.addApproach(new MultitypeApproach("a1", "pb", 0.5f, true, 5, 2, new String[]{"pa", "pb"}, solver));
        solver.addApproach(new ResizableApproach("a0", "pb", 0.8f, true, 3, 2, 2));
        solver.addProblem(new Problem("pa", 10));
        solver.addProblem(new Problem("pb", 8));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test9() {
        Solver solver = new Solver();
        solver.setTimeLimit(200);
        solver.addApproach(new RegularApproach("a0", "pa", 0.5f, true, 3));
        solver.addApproach(new ImprovableApproach("a1", "pa", 0.2f, false, 8, 0.4f, 1));
        solver.addApproach(new DegradedApproach("a2", "pb", 0.8f, true, 10, 0.35f, 5));
        solver.addApproach(new MultitypeApproach("a3", "pb", 0.5f, false, 3, 2, new String[]{"pa", "pa"}, solver));
        solver.addApproach(new ResizableApproach("a4", "pb", 0.95f, false, 1, 5, 2));
        solver.addProblem(new Problem("pb", 10));
        solver.addProblem(new Problem("pb", 20));
        solver.addProblem(new Problem("pa", 10));
        solver.addProblem(new Problem("pa", 15));
        solver.addProblem(new Problem("pb", 5));
        solver.showResults(solver.solveAll(null));
    }
    
    public static void test10() {
        Solver solver = new Solver();
        solver.setTimeLimit(100);
        solver.addApproach(new RegularApproach("a0", "pa", 0.3f, true, 3));
        solver.addApproach(new ImprovableApproach("a1", "pa", 0.2f, false, 8, 0.4f, 1));
        solver.addApproach(new DegradedApproach("a2", "pb", 0.8f, true, 10, 0.35f, 5));
        solver.addApproach(new MultitypeApproach("a3", "pb", 0.5f, false, 3, 2, new String[]{"pa", "pa"}, solver));
        solver.addApproach(new ResizableApproach("a4", "pb", 0.95f, false, 1, 5, 2));
        solver.addApproach(new RegularApproach("a5", "pa", 0.8f, false, 2));
        solver.addApproach(new ImprovableApproach("a6", "pb", 0.3f, false, 4, 0.1f, 1));
        solver.addApproach(new DegradedApproach("a7", "pa", 0.8f, true, 5, 0.35f, 3));
        solver.addApproach(new MultitypeApproach("a8", "pa", 0.5f, false, 2, 3, new String[]{"pa", "pa", "pb"}, solver));
        solver.addApproach(new ResizableApproach("a9", "pa", 0.95f, false, 3, 4, 2));
        solver.addProblem(new Problem("pb", 5));
        solver.addProblem(new Problem("pb", 10));
        solver.addProblem(new Problem("pa", 4));
        solver.addProblem(new Problem("pa", 5));
        solver.addProblem(new Problem("pb", 3));
        solver.addProblem(new Problem("pa", 5));
        solver.addProblem(new Problem("pa", 2));
        solver.addProblem(new Problem("pb", 6));
        solver.addProblem(new Problem("pb", 7));
        solver.addProblem(new Problem("pa", 5));
        solver.showResults(solver.solveAll(null));
    }
    
}
