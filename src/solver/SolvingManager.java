package solver;

import solver.frame.MainJFrame;

// клас описує проміжний об'єкт, що використовується для передачі деяких
// даних під час виконання алгоритмічної частини програми
// в частину з графічним інтерфейсом
public class SolvingManager {
    
    private final MainJFrame frame; // фрейм, звідки запустився алгоритм
    
    // конструктор
    public SolvingManager(MainJFrame frame) {
        this.frame = frame;
    }
    
    // передає у фрейм кількість розв'язаних на даний момент задач
    public void progress(int problemSolved) {
        frame.setProgress(problemSolved);
    }
    
    // передає у фрейм статус виконання алгоритму
    public void changeStatus(String message, Boolean isGood) {
        frame.updateStatus(message, isGood);
    }
}
