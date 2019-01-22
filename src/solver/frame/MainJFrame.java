package solver.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import solver.Approach;
import solver.Approach.Result;
import solver.Problem;
import solver.Solver;
import solver.SolverException;
import solver.SolvingManager;

public class MainJFrame extends javax.swing.JFrame {

    private final static int STATUS_TIME = 1250; // час обновлення статусу
    // колір "позитивного" повідомлення
    private final static Color GOOD_STATUS_COLOR = Color.decode("#0a7a08"); 
    // колір "негативного" повідомлення
    private final static Color BAD_STATUS_COLOR = Color.decode("#b71200"); 
    private final Solver solver; // вирішувач, що передався в конструктор
    private Solver currentSolver; // поточний вирішувач
    // [i] = true, якшо i-ий підхід в
    // підходів currentSolver-а використовується
    private boolean[] isApproachUsing; 
    // [i] = true, якшо i-а задача в 
    // списку задач currentSolver-а використовується
    private Vector<Boolean> isProblemUsing; 
    // список позицій в currentSolver-і використаних проблем 
    private Vector<Integer> usingProblemPositions; 
    // true, якщо не треба показувати інформацію про задачі вирішені неуспішно
    private boolean showOnlySuccessfull;  
    
    // конструктор вікна
    public MainJFrame(Solver solver) {
        this.solver = solver;
        // ініціалізація компонент за допомогою редактора NetBeans
        initComponents(); 
        setDefaultSettings(); // ручна зміна деяких компонент вікна
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        inputPanel = new javax.swing.JPanel();
        approachProblemPanel = new javax.swing.JPanel();
        approachPanel = new javax.swing.JPanel();
        approachTitleTextField = new javax.swing.JTextField();
        approachInPanel = new javax.swing.JPanel();
        allApproachesPanel = new javax.swing.JPanel();
        allApproachesScrollPane = new javax.swing.JScrollPane();
        allApproachesList = new javax.swing.JList<>();
        allApproachesButtonsPanel = new javax.swing.JPanel();
        allApproachesSpace = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 32767));
        addToUsingApproachesButton = new javax.swing.JButton();
        usingApproachesPanel = new javax.swing.JPanel();
        usingApproachesScrollPane = new javax.swing.JScrollPane();
        usingApproachesList = new javax.swing.JList<>();
        usingApproachesSpace = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        deleteApproachButton = new javax.swing.JButton();
        problemPanel = new javax.swing.JPanel();
        problemTitleTextField = new javax.swing.JTextField();
        problemInPanel = new javax.swing.JPanel();
        allProblemsPanel = new javax.swing.JPanel();
        allProblemsScrollPane = new javax.swing.JScrollPane();
        allProblemsList = new javax.swing.JList<>();
        allProblemsSpace1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        addProblemButton = new javax.swing.JButton();
        allProblemsSpace2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 0));
        toSolveButton = new javax.swing.JButton();
        toSolveProblemsPanel = new javax.swing.JPanel();
        toSolvePane = new javax.swing.JScrollPane();
        toSolveList = new javax.swing.JList<>();
        toSolveSpace = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        deleteProblemButton = new javax.swing.JButton();
        startPanel = new javax.swing.JPanel();
        setTimePanel = new javax.swing.JPanel();
        setTimeTitleTextField = new javax.swing.JTextField();
        setTimeTextField = new javax.swing.JTextField();
        startAlgorithmButton = new javax.swing.JButton();
        outputPanel = new javax.swing.JPanel();
        totalTimePanel = new javax.swing.JPanel();
        totalTimeTitleTextField = new javax.swing.JTextField();
        totalTimeTextField = new javax.swing.JTextField();
        detailsScrollPane = new javax.swing.JScrollPane();
        detailsList = new javax.swing.JList<>();
        solvingProgressBar = new javax.swing.JProgressBar();
        statusTextField = new javax.swing.JTextField();
        MenuBar = new javax.swing.JMenuBar();
        settingsMenu = new javax.swing.JMenu();
        showNotSuccessCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        approachesInfoMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Вирішувач");
        setResizable(false);

        MainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        MainPanel.setPreferredSize(new java.awt.Dimension(550, 500));
        MainPanel.setLayout(new javax.swing.BoxLayout(MainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        inputPanel.setLayout(new javax.swing.BoxLayout(inputPanel, javax.swing.BoxLayout.PAGE_AXIS));

        approachProblemPanel.setLayout(new java.awt.GridLayout(1, 2, 15, 0));

        approachPanel.setLayout(new java.awt.BorderLayout());

        approachTitleTextField.setEditable(false);
        approachTitleTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        approachTitleTextField.setText("Підходи");
        approachTitleTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        approachPanel.add(approachTitleTextField, java.awt.BorderLayout.PAGE_START);

        approachInPanel.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        allApproachesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Всі"));
        allApproachesPanel.setToolTipText("список підходів, якими володіє вирішувач (для мультивиділення зажміть клавішу Ctrl)");
        allApproachesPanel.setPreferredSize(new java.awt.Dimension(0, 200));
        allApproachesPanel.setLayout(new javax.swing.BoxLayout(allApproachesPanel, javax.swing.BoxLayout.PAGE_AXIS));

        allApproachesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        allApproachesList.setToolTipText("");
        allApproachesList.setFocusable(false);
        allApproachesList.setPreferredSize(null);
        allApproachesList.setRequestFocusEnabled(false);
        allApproachesScrollPane.setViewportView(allApproachesList);

        allApproachesPanel.add(allApproachesScrollPane);

        allApproachesButtonsPanel.setLayout(new javax.swing.BoxLayout(allApproachesButtonsPanel, javax.swing.BoxLayout.PAGE_AXIS));
        allApproachesButtonsPanel.add(allApproachesSpace);

        addToUsingApproachesButton.setText("Використати");
        addToUsingApproachesButton.setToolTipText("застосовувати вибрані підходи");
        addToUsingApproachesButton.setAlignmentX(0.5F);
        addToUsingApproachesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToUsingApproachesButton.setFocusable(false);
        addToUsingApproachesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToUsingApproachesButtonActionPerformed(evt);
            }
        });
        allApproachesButtonsPanel.add(addToUsingApproachesButton);

        allApproachesPanel.add(allApproachesButtonsPanel);

        approachInPanel.add(allApproachesPanel);

        usingApproachesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Використані"));
        usingApproachesPanel.setToolTipText("список підходів, який вирішувач застосовуватиме");
        usingApproachesPanel.setPreferredSize(new java.awt.Dimension(0, 200));
        usingApproachesPanel.setLayout(new javax.swing.BoxLayout(usingApproachesPanel, javax.swing.BoxLayout.PAGE_AXIS));

        usingApproachesScrollPane.setPreferredSize(new java.awt.Dimension(35, 130));

        usingApproachesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        usingApproachesList.setToolTipText("");
        usingApproachesList.setFocusable(false);
        usingApproachesList.setMaximumSize(new java.awt.Dimension(33, 80));
        usingApproachesList.setMinimumSize(new java.awt.Dimension(33, 80));
        usingApproachesScrollPane.setViewportView(usingApproachesList);

        usingApproachesPanel.add(usingApproachesScrollPane);
        usingApproachesPanel.add(usingApproachesSpace);

        deleteApproachButton.setText("Видалити");
        deleteApproachButton.setToolTipText("не застосовувати вибрані підходи");
        deleteApproachButton.setAlignmentX(0.5F);
        deleteApproachButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteApproachButton.setFocusable(false);
        deleteApproachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteApproachButtonActionPerformed(evt);
            }
        });
        usingApproachesPanel.add(deleteApproachButton);

        approachInPanel.add(usingApproachesPanel);

        approachPanel.add(approachInPanel, java.awt.BorderLayout.CENTER);

        approachProblemPanel.add(approachPanel);

        problemPanel.setLayout(new java.awt.BorderLayout());

        problemTitleTextField.setEditable(false);
        problemTitleTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        problemTitleTextField.setText("Задачі");
        problemTitleTextField.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        problemPanel.add(problemTitleTextField, java.awt.BorderLayout.PAGE_START);

        problemInPanel.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        allProblemsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Всі"));
        allProblemsPanel.setToolTipText("список задач, про які відомо вирішувачу");
        allProblemsPanel.setPreferredSize(new java.awt.Dimension(0, 200));
        allProblemsPanel.setLayout(new javax.swing.BoxLayout(allProblemsPanel, javax.swing.BoxLayout.PAGE_AXIS));

        allProblemsScrollPane.setPreferredSize(new java.awt.Dimension(35, 100));

        allProblemsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        allProblemsList.setToolTipText("");
        allProblemsList.setFocusable(false);
        allProblemsScrollPane.setViewportView(allProblemsList);

        allProblemsPanel.add(allProblemsScrollPane);
        allProblemsPanel.add(allProblemsSpace1);

        addProblemButton.setText("Додати");
        addProblemButton.setToolTipText("створити нову задачу");
        addProblemButton.setAlignmentX(0.5F);
        addProblemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProblemButton.setFocusable(false);
        addProblemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProblemButtonActionPerformed(evt);
            }
        });
        allProblemsPanel.add(addProblemButton);
        allProblemsPanel.add(allProblemsSpace2);

        toSolveButton.setText("Використати");
        toSolveButton.setToolTipText("додати виділені задачі до списку вирішуваних");
        toSolveButton.setAlignmentX(0.5F);
        toSolveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toSolveButton.setFocusable(false);
        toSolveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSolveButtonActionPerformed(evt);
            }
        });
        allProblemsPanel.add(toSolveButton);

        problemInPanel.add(allProblemsPanel);

        toSolveProblemsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Використані"));
        toSolveProblemsPanel.setToolTipText("список задач, які будуть вирішуватися");
        toSolveProblemsPanel.setPreferredSize(new java.awt.Dimension(0, 200));
        toSolveProblemsPanel.setLayout(new javax.swing.BoxLayout(toSolveProblemsPanel, javax.swing.BoxLayout.PAGE_AXIS));

        toSolveList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        toSolveList.setToolTipText("");
        toSolveList.setFocusable(false);
        toSolveList.setPreferredSize(null);
        toSolvePane.setViewportView(toSolveList);

        toSolveProblemsPanel.add(toSolvePane);
        toSolveProblemsPanel.add(toSolveSpace);

        deleteProblemButton.setText("Видалити");
        deleteProblemButton.setToolTipText("не вирішувати виділені задачі");
        deleteProblemButton.setAlignmentX(0.5F);
        deleteProblemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProblemButton.setFocusable(false);
        deleteProblemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProblemButtonActionPerformed(evt);
            }
        });
        toSolveProblemsPanel.add(deleteProblemButton);

        problemInPanel.add(toSolveProblemsPanel);

        problemPanel.add(problemInPanel, java.awt.BorderLayout.CENTER);

        approachProblemPanel.add(problemPanel);

        inputPanel.add(approachProblemPanel);

        startPanel.setPreferredSize(new java.awt.Dimension(252, 30));

        setTimeTitleTextField.setEditable(false);
        setTimeTitleTextField.setText("Часовий ліміт (мс):");
        setTimeTitleTextField.setToolTipText("обмеження в часі на виконання однієї задачі");
        setTimeTitleTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED),
            BorderFactory.createCompoundBorder(setTimeTitleTextField.getBorder(),
                BorderFactory.createEmptyBorder(2, 2, 2, 2))));
    setTimePanel.add(setTimeTitleTextField);

    setTimeTextField.setToolTipText("введіть час");
    setTimeTextField.setPreferredSize(new java.awt.Dimension(50, 20));
    setTimePanel.add(setTimeTextField);

    startPanel.add(setTimePanel);

    startAlgorithmButton.setText("Вирішити");
    startAlgorithmButton.setToolTipText("запустити алгоритм, що послідовно вирішуватиме задачі зі списку використаних підходами зі списку використаних");
    startAlgorithmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    startAlgorithmButton.setFocusable(false);
    startAlgorithmButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            startAlgorithmButtonActionPerformed(evt);
        }
    });
    startPanel.add(startAlgorithmButton);

    inputPanel.add(startPanel);

    MainPanel.add(inputPanel);

    outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Результати"));
    outputPanel.setLayout(new javax.swing.BoxLayout(outputPanel, javax.swing.BoxLayout.PAGE_AXIS));

    totalTimePanel.setPreferredSize(new java.awt.Dimension(164, 25));

    totalTimeTitleTextField.setEditable(false);
    totalTimeTitleTextField.setText("Загальний час (мс):");
    totalTimeTitleTextField.setToolTipText("час на виконання всіх задач");
    totalTimeTitleTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), BorderFactory.createCompoundBorder(totalTimeTitleTextField.getBorder(),
        BorderFactory.createEmptyBorder(2, 2, 2, 2))));
totalTimePanel.add(totalTimeTitleTextField);

totalTimeTextField.setEditable(false);
totalTimeTextField.setToolTipText("");
totalTimeTextField.setPreferredSize(new java.awt.Dimension(50, 20));
totalTimePanel.add(totalTimeTextField);

outputPanel.add(totalTimePanel);

detailsScrollPane.setMaximumSize(new java.awt.Dimension(350, 32767));

detailsList.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 51)));
detailsList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
detailsList.setModel(new DefaultListModel());
detailsList.setToolTipText("список вирішених задач та термінів їх вирішення");
detailsList.setVisibleRowCount(5);
detailsScrollPane.setViewportView(detailsList);

outputPanel.add(detailsScrollPane);

MainPanel.add(outputPanel);

solvingProgressBar.setToolTipText("прогрес процесу вирішування задач");
solvingProgressBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
solvingProgressBar.setStringPainted(true);
MainPanel.add(solvingProgressBar);

statusTextField.setEditable(false);
statusTextField.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
statusTextField.setForeground(new java.awt.Color(204, 0, 0));
statusTextField.setText("алгоритм не виконується");
statusTextField.setToolTipText("підказка");
statusTextField.setMaximumSize(new java.awt.Dimension(2147483647, 20));
MainPanel.add(statusTextField);

settingsMenu.setText("Налаштування");

showNotSuccessCheckBoxMenuItem.setText("показувати неуспіхи");
showNotSuccessCheckBoxMenuItem.setToolTipText("показувати інформацію про задачі, що вирішені не успішно");
showNotSuccessCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
    showNotSuccessCheckBoxMenuItemActionPerformed(evt);
    }
    });
    settingsMenu.add(showNotSuccessCheckBoxMenuItem);

    MenuBar.add(settingsMenu);

    helpMenu.setText("Довідка");

    approachesInfoMenuItem.setText("підходи");
    approachesInfoMenuItem.setToolTipText("детальна інформація про підходи, якими володіє вирішувач");
    approachesInfoMenuItem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            approachesInfoMenuItemActionPerformed(evt);
        }
    });
    helpMenu.add(approachesInfoMenuItem);

    MenuBar.add(helpMenu);
    helpMenu.getAccessibleContext().setAccessibleDescription("");

    setJMenuBar(MenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    getAccessibleContext().setAccessibleDescription("");

    pack();
    }// </editor-fold>//GEN-END:initComponents

    // використати вибрані підходи
    private void addToUsingApproachesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToUsingApproachesButtonActionPerformed
        int[] selectedApproaches = allApproachesList.getSelectedIndices();
        allApproachesList.clearSelection();
        for (int position : selectedApproaches) {
            isApproachUsing[position] = true;
        }
        DefaultListModel model =
            (DefaultListModel)usingApproachesList.getModel();
        model.clear();
        for (int i = 0; i < isApproachUsing.length; i++) {
            if (isApproachUsing[i]) {
                model.addElement(solver.getApproaches().get(i).getName());
            }
        }
    }//GEN-LAST:event_addToUsingApproachesButtonActionPerformed

    // початок алгоритму вирішення задач
    private void startAlgorithmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startAlgorithmButtonActionPerformed
        // формуємо новий вирішувач на основі вибраних 
        // підходів, задач та зазначеного ліміту часу
        ArrayList<Approach> approaches = new ArrayList<>();
        ArrayList<Problem> problems = new ArrayList<>();
        for (int i = 0; i < isApproachUsing.length; i++) {
            if (isApproachUsing[i]) {
                approaches.add(solver.getApproaches().get(i));
            }
        }
        for (int i = 0; i < usingProblemPositions.size(); i++) {
            problems.add(
                solver.getProblems().get(usingProblemPositions.get(i)));
        }
        // обробимо можливі винятки
        try {
            currentSolver = new Solver(
                Integer.parseInt(setTimeTextField.getText()),
                problems, approaches);
        } catch (NumberFormatException ex) {
            updateStatus("введено не ціле обмеження часу!", false);
            return;
        } catch (SolverException ex) {
            updateStatus(ex.toString(), false);
            return;
        }
        // підготуємо інтерфейс до запуску алгоритму
        solvingProgressBar.setMaximum(currentSolver.getProblems().size());
        solvingProgressBar.setValue(0);
        startAlgorithmButton.setEnabled(false);
        setTimeTextField.setFocusable(false);
        setTimeTextField.setFocusable(true);
        // запускаємо алгоритм в новому потоці
        new Thread() {
            @Override
            public void run() {
                ArrayList<Result> results = 
                    currentSolver.solveAll(new SolvingManager(MainJFrame.this));
                // виконується, якщо алгоритм успішно закінчився
                onAlgorithmFinish(results);
            }
        }.start();
        updateStatus("задачі почали вирішуватися", true);
    }//GEN-LAST:event_startAlgorithmButtonActionPerformed
    
    private void onAlgorithmFinish(ArrayList<Result> results) {
        updateStatus("задачі вирішилися", true);
        // вивід результатів
        solvingProgressBar.setValue(solvingProgressBar.getMaximum());
        int timeSum = 0;
        DefaultListModel model = (DefaultListModel)detailsList.getModel();
        model.removeAllElements();
        for (int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            timeSum += result.time;
            if (result.isSolved) {
                model.addElement(
                   "успіх p_"+ currentSolver.getProblems().get(i).getId() +
                    " - " + result.time);
            } else if (!showOnlySuccessfull) {
                model.addElement(
                    "неуспіх p_"+ currentSolver.getProblems().get(i).getId() +
                    " - " + result.time + " (" +
                    (result.time < currentSolver.getTimeLimit() ? 
                    "відсутність підходів" : "вичерпання часу") + ")");
            }
        }
        totalTimeTextField.setText(Integer.toString(timeSum));
        startAlgorithmButton.setEnabled(true); // кнопка запуску знову доступна
    }
    
    // використати вибрані задачі
    private void toSolveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSolveButtonActionPerformed
        int[] selectedProblems = allProblemsList.getSelectedIndices();
        allProblemsList.clearSelection();
        DefaultListModel model = (DefaultListModel)toSolveList.getModel();
        for (int position : selectedProblems) {
            if (!isProblemUsing.get(position)) {
                isProblemUsing.set(position, true);
                usingProblemPositions.add(position);
                model.addElement(solver.getProblems().get(position));
            }
        }
    }//GEN-LAST:event_toSolveButtonActionPerformed

    // не використовувати вибрані підходи
    private void deleteApproachButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteApproachButtonActionPerformed
        int[] selectedApproaches = usingApproachesList.getSelectedIndices();
        for (int k = selectedApproaches.length - 1; k >= 0; k--) {
            int position = selectedApproaches[k];
            for (int i = 0, j = -1; ; i++) {
                if (isApproachUsing[i]) {
                    j++;
                }
                if (j == position) {
                    isApproachUsing[i] = false;
                    break;
                }
            }
        }
        DefaultListModel model = 
            (DefaultListModel)usingApproachesList.getModel();
        model.clear();
        for (int i = 0; i < isApproachUsing.length; i++) {
            if (isApproachUsing[i]) {
                model.addElement(solver.getApproaches().get(i).getName());
            }
        }
    }//GEN-LAST:event_deleteApproachButtonActionPerformed

    // не використовувати вибрані задачі
    private void deleteProblemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProblemButtonActionPerformed
        int[] selectedProblems = toSolveList.getSelectedIndices();
        DefaultListModel model = (DefaultListModel)toSolveList.getModel();
        for (int i = selectedProblems.length - 1; i >= 0; i--) {
             isProblemUsing.set(
                usingProblemPositions.get(selectedProblems[i]), false);
             usingProblemPositions.remove(selectedProblems[i]);
             model.remove(selectedProblems[i]);
        }
    }//GEN-LAST:event_deleteProblemButtonActionPerformed

    // додати нову задачу в вирішувача solver
    private void addProblemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProblemButtonActionPerformed
        JTextField typeField = new JTextField();
        JTextField sizeField = new JTextField();
        JComponent[] content = new JComponent[] {
                new JLabel("Тип:"),
                typeField,
                new JLabel("Розмір:"),
                sizeField
        };
        int result = JOptionPane.showConfirmDialog(null, content,
            "Параметри нової задачі", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Problem problem = null;
            // обробимо можливі винятки
            try {
                problem = new Problem(
                    typeField.getText(), Integer.parseInt(sizeField.getText()));
            } catch (NumberFormatException ex) {
                updateStatus("введено не ціле значення розміру!", false);
                return;
            } catch (Problem.NegativeSizeException ex) {
                updateStatus(ex.toString(), false);
                return;
            }
            solver.addProblem(problem);
            isProblemUsing.add(false);
            ((DefaultListModel)allProblemsList.getModel()).addElement(problem);
            updateStatus("додана нова задача", true);
        } else {
            updateStatus("додавання задачі скасовано", false);
        }
    }//GEN-LAST:event_addProblemButtonActionPerformed

    // показати інформацію про всі підходи вирішувача solver
    private void approachesInfoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approachesInfoMenuItemActionPerformed
        JScrollPane infoPane = new JScrollPane();
        JList infoList = new JList();
        DefaultListModel model = new DefaultListModel();
        infoList.setModel(model);
        infoPane.setViewportView(infoList);
        for (Approach approach : solver.getApproaches()) {
           model.addElement(approach);
        }
        infoPane.setPreferredSize(new Dimension(450, 125));
        int result = 
            JOptionPane.showConfirmDialog(null, new JComponent[] { infoPane },
            "Інформація про підходи", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_approachesInfoMenuItemActionPerformed

    // (не) показувати інформацію про вирішення задач з неуспіхом
    private void showNotSuccessCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showNotSuccessCheckBoxMenuItemActionPerformed
        showOnlySuccessfull = !showOnlySuccessfull;
    }//GEN-LAST:event_showNotSuccessCheckBoxMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton addProblemButton;
    private javax.swing.JButton addToUsingApproachesButton;
    private javax.swing.JPanel allApproachesButtonsPanel;
    private javax.swing.JList<String> allApproachesList;
    private javax.swing.JPanel allApproachesPanel;
    private javax.swing.JScrollPane allApproachesScrollPane;
    private javax.swing.Box.Filler allApproachesSpace;
    private javax.swing.JList<String> allProblemsList;
    private javax.swing.JPanel allProblemsPanel;
    private javax.swing.JScrollPane allProblemsScrollPane;
    private javax.swing.Box.Filler allProblemsSpace1;
    private javax.swing.Box.Filler allProblemsSpace2;
    private javax.swing.JPanel approachInPanel;
    private javax.swing.JPanel approachPanel;
    private javax.swing.JPanel approachProblemPanel;
    private javax.swing.JTextField approachTitleTextField;
    private javax.swing.JMenuItem approachesInfoMenuItem;
    private javax.swing.JButton deleteApproachButton;
    private javax.swing.JButton deleteProblemButton;
    private javax.swing.JList<String> detailsList;
    private javax.swing.JScrollPane detailsScrollPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JPanel problemInPanel;
    private javax.swing.JPanel problemPanel;
    private javax.swing.JTextField problemTitleTextField;
    private javax.swing.JPanel setTimePanel;
    private javax.swing.JTextField setTimeTextField;
    private javax.swing.JTextField setTimeTitleTextField;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JCheckBoxMenuItem showNotSuccessCheckBoxMenuItem;
    private javax.swing.JProgressBar solvingProgressBar;
    private javax.swing.JButton startAlgorithmButton;
    private javax.swing.JPanel startPanel;
    private javax.swing.JTextField statusTextField;
    private javax.swing.JButton toSolveButton;
    private javax.swing.JList<String> toSolveList;
    private javax.swing.JScrollPane toSolvePane;
    private javax.swing.JPanel toSolveProblemsPanel;
    private javax.swing.Box.Filler toSolveSpace;
    private javax.swing.JPanel totalTimePanel;
    private javax.swing.JTextField totalTimeTextField;
    private javax.swing.JTextField totalTimeTitleTextField;
    private javax.swing.JList<String> usingApproachesList;
    private javax.swing.JPanel usingApproachesPanel;
    private javax.swing.JScrollPane usingApproachesScrollPane;
    private javax.swing.Box.Filler usingApproachesSpace;
    // End of variables declaration//GEN-END:variables

    // показ вирішувача solver в графічному інтерфейсі та
    // деякі додаткові підготування
    private void setDefaultSettings() {
        showOnlySuccessfull = true;
        setTimeTextField.setText(Integer.toString(solver.getTimeLimit()));
        usingProblemPositions = new Vector();
        isApproachUsing = new boolean[solver.getApproaches().size()];
        for (int i = 0; i < isApproachUsing.length; i++) {
            isApproachUsing[i] = false;
        }
        isProblemUsing = new Vector<>();
        for (int i = 0; i < solver.getProblems().size(); i++) {
            isProblemUsing.add(false);
        }
        DefaultListModel allApproachesListModel = new DefaultListModel();
        for (Approach approach : solver.getApproaches()) {
            allApproachesListModel.addElement(approach.getName());
        }
        allApproachesList.setModel(allApproachesListModel);
        DefaultListModel allProblemsListModel = new DefaultListModel();
        for (Problem problem : solver.getProblems()) {
            allProblemsListModel.addElement(problem);
        }
        allProblemsList.setModel(allProblemsListModel);
        usingApproachesList.setModel(new DefaultListModel());
        toSolveList.setModel(new DefaultListModel());
        updateStatus("вирішувач сформований", true);
    }
    
    // обновити статус программи
    public void updateStatus(String message, boolean isGood) {
        new Thread() {
            @Override
            public void run() {
                statusTextField.setText(message);
                statusTextField.setForeground(isGood ? 
                    GOOD_STATUS_COLOR : BAD_STATUS_COLOR);
                try {
                    sleep(STATUS_TIME);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainJFrame.class.getName()).
                        log(Level.SEVERE, null, ex);
                }
                if (statusTextField.getText().equals(message)) {
                    statusTextField.setText("");
                }
            }
        }.start();
    }
    
    // змінити значення індикатора виконання
    public void setProgress(int problemSolved) {
        solvingProgressBar.setValue(problemSolved);
    }

}
