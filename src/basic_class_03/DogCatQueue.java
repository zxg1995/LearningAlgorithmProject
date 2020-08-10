package basic_class_03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Paul Z on 2019/12/19
 */
public class DogCatQueue {

    static class Pet {
        private String type;

        Pet(String type) {
            this.type = type;
        }

        String getPetType() {
            return this.type;
        }
    }

    static class Dog extends Pet {
        Dog() {
            super("dog");
        }
    }

    static class Cat extends Pet {
        Cat() {
            super("cat");
        }
    }

    static class PetInQueue{
        private Pet pet;
        private int count;

        PetInQueue(Pet pet, int count){
            this.pet = pet;
            this.count = count;
        }

        Pet getPet(){
            return pet;
        }

        int getCount(){
            return count;
        }

        String getPetType(){
            return pet.getPetType();
        }
    }

    static class DogAndCatQueue {
        Queue<PetInQueue> dogQueue;
        Queue<PetInQueue> catQueue;
        int count;

        DogAndCatQueue() {
            dogQueue = new LinkedList<>();
            catQueue = new LinkedList<>();
            count = 0;
        }

        private void add(Pet pet) {
            if (pet.getPetType().equals("dog"))
                dogQueue.add(new PetInQueue(pet, count++));
            else if (pet.getPetType().equals("cat"))
                catQueue.add(new PetInQueue(pet, count++));
            else
                throw new RuntimeException("异常的输入参数");
        }

        private Dog pollDog() {
            if (dogQueue.isEmpty())
                throw new RuntimeException("Dog队列已空，无法出队");
            return (Dog) dogQueue.poll().getPet();
        }

        private Cat pollCat() {
            if (catQueue.isEmpty())
                throw new RuntimeException("Cat队列已空，无法出队");
            return (Cat) catQueue.poll().getPet();
        }

        private Pet pollAll() {
            if (catQueue.isEmpty() && dogQueue.isEmpty())
                throw new RuntimeException("队列已空，无法出队");
            else if (catQueue.isEmpty())
                return dogQueue.poll().getPet();
            else if (dogQueue.isEmpty())
                return catQueue.poll().getPet();

            if (catQueue.peek().getCount() < dogQueue.peek().getCount())
                return catQueue.poll().getPet();
            else
                return dogQueue.poll().getPet();
        }

        private boolean isCatEmpty(){
            return catQueue.isEmpty();
        }

        private boolean isDogEmpty(){
            return dogQueue.isEmpty();
        }

        private boolean isEmpty(){
            return catQueue.isEmpty() && dogQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogAndCatQueue queue = new DogAndCatQueue();
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Cat());
        queue.add(new Dog());
        System.out.println(queue.pollAll().getPetType());
        System.out.println(queue.pollAll().getPetType());
        System.out.println(queue.pollDog().getPetType());
        System.out.println(queue.pollAll().getPetType());
        System.out.println(queue.isEmpty());
    }
}
