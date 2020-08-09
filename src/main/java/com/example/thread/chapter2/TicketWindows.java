package com.example.thread.chapter2;

public class TicketWindows extends Thread {
    private static  int INDEX=1;
    private static  final int TOTAL=50;
    private String name;

    public TicketWindows(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (INDEX<=TOTAL) {
            System.out.println(name + ":取到了号码==》" + (INDEX++));
        }
    }
}
