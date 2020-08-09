package com.example.thread.chapter2;

public class Bank {
    public static void main(String[] args) {
        TicketWindows windows1=new TicketWindows("窗口1");
        TicketWindows windows2=new TicketWindows("窗口2");
        TicketWindows windows3=new TicketWindows("窗口3");
        windows1.start();
        windows2.start();
        windows3.start();
    }
}
