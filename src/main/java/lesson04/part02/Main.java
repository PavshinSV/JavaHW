package lesson04.part02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Tasks> orderList = new ArrayList<>();
        long startTime = System.nanoTime();
        long endTime = 120000000000L;
        int getTaskEx = 0;
        int leave = 0;
        int served = 0;
        List<String> log = new ArrayList<>();

        int executionTime = 0;

        while (System.nanoTime() - startTime < endTime) { //чтобы не растягивать выполнение на 8 рабочих часов зададим масштаб. 8ч=2мин
            try {
                Tasks newTask = createTask();//запускаем каждые "5минут" вероятность появления нового посетителя с новой задачей
                log.add(getLog(newTask, "create", startTime, System.nanoTime()));
                if (orderList.size() < 1) {
                    orderList.add(newTask);
                } else {
                    int i = 1;
                    while (i < orderList.size() && orderList.get(i).prioritet() >= newTask.prioritet()) {
                        i++;
                    }
                    if (i < orderList.size()) {
                        orderList.add(i, newTask);
                    } else {
                        orderList.add(newTask);
                    }
                }
            } catch (Exception ex) {
                getTaskEx++;
            }
            if (orderList.size() > 5) { //при условии что очередь больше 5 проверяется вероятность ухода из очереди
                int leaveIndex = getLeave(orderList.size());
                if (leaveIndex > -1) {
                    log.add(getLog(orderList.get(leaveIndex), "leave", startTime, System.nanoTime()));
                    orderList.remove(leaveIndex);
                    leave++;
                }
            }

            if (orderList.size() > 0) {
                if (executionTime * 5 < orderList.get(0).time()) {
                    executionTime++;
                } else {
                    executionTime = 0;
                    log.add(getLog(orderList.get(0), "complete", startTime, System.nanoTime()));
                    orderList.remove(0);
                    served++;
                }
            }

            try {
                Thread.sleep(1000);//предполагаем, что 1 секунда - 5 минут реального времени
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        System.out.println("End of work day. My documents are closed");
        System.out.printf("Today were served %d citizen, %d are leaving out without deal", served, leave);

    }//конец блока main

    private static int getLeave(int size) {
        int index = -1;
        int probability = new Random().nextInt(100);
        if (probability > 80) {
            index = new Random().nextInt(5, size);
        }
        return index;
    }

    private static String getLog(Tasks el, String status, long start, long now) {
        String log = new String();
        Long time = (now - start) / (100000 * 38);
        int hours = 8 + time.intValue() / 3600;
        int minutes = (time.intValue() % 3600) / 60;
        log = Integer.toString(hours/10)+Integer.toString(hours%10) + ":" + Integer.toString(minutes/10)+ Integer.toString(minutes%10) + ", ";
        if (status.equals("create")) {
            log += "Create:\t" + el.toString();
        } else if (status.equals("complete")) {
            log += "Complete:" + el.toString();
        } else if (status.equals("leave")) {
            log += "Leave:\t" + el.toString();
        }
        System.out.println(log);
        return log;
    }

    public static Tasks createTask() throws Exception {
        Tasks newTask;
        int probability = new Random().nextInt(100);
        Exception exception = new Exception();
        if (probability > 50) {
            probability = new Random().nextInt(70);
            if (probability < 10) {
                newTask = new Passport();
            } else if (probability < 20) {
                newTask = new Snils();
            } else if (probability < 30) {
                newTask = new MarriageСertificate();
            } else if (probability < 40) {
                newTask = new Purchase();
            } else if (probability < 50) {
                newTask = new Kadastr();
            } else if (probability < 60) {
                newTask = new Credit();
            } else {
                newTask = new Insurance();
            }
            return newTask;
        } else throw exception;

    }
}