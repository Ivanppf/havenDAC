package com.ippf.havendac.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyCustomIO {

    public String read() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void print(String text) {
        System.out.print(text);
    }
}
