package ua.com.alevel;

public class FindUniqueName {

    public void findUniqueName(String  name) {
        if (name.equals("exit")) {
            System.exit(0);
        }
        String[] names = name.split(" ");
        String uniqueName = names[0];
        for (int i = 1; i < names.length-1; i++) {
            uniqueName = names[0];
            if (!names[i].equals(uniqueName)) {
                uniqueName = names[i + 1];
            }
        }
        System.out.println("First unique name is: " + uniqueName);
    }
}
