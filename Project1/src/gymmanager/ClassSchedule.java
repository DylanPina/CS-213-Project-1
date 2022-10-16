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

    public FitnessClass getFitnessClass(FitnessClass fitnessClass) {
        for (int i = 0; i < numClasses; i++)
            if ((classes[i] != null) && (classes[i].equals(fitnessClass))){
                return classes[i];
            }
        return null;
    }

    public FitnessClass[] getClasses() {
        return classes;
    }

    public int getNumClasses() {
        return numClasses;
    }

    public void printClassSchedule() {
        for (FitnessClass fitnessClass : classes)
            if (fitnessClass != null) System.out.println(fitnessClass);
    }
}
