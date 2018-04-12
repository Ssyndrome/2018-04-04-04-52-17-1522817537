package com.tw;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public boolean someLibraryMethod() {
        return true;
    }

    public static void main(String[] args) {
        List<Student> list= new ArrayList<>();
        Command command = new Command(list);
        command.mainInterface();
    }
}
