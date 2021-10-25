package ua.com.alevel;

import ua.com.alevel.controller.Controller;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            new Controller().run(args[0], args[1]);
        }
    }
}
