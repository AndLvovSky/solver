package solver;

// даний клас описує винятки, що кидаються
// об'єктами класу вирішувача
// є породженим від RuntimeException
public class SolverException extends RuntimeException {
       
        // визивається конструктор базового класу RuntimeException
        public SolverException(String message) {
            super(message);
        }
        
        @Override
        public String toString() {
            return "виняток вирішувача! " + getMessage();
        }
}
