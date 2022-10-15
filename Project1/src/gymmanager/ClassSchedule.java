package gymmanager;

public class ClassSchedule {
    private FitnessClass[] classes;
    private int numClasses;

    public ClassSchedule() {
        classes = new FitnessClass[15];
        numClasses = 0;
    }

    public void addFitnessClass(FitnessClass fitnessClass) {
        classes[numClasses++] = fitnessClass;
    }

    public void printClassSchedule() {
        for (FitnessClass fitnessClass : classes) System.out.println(fitnessClass);
    }
}
